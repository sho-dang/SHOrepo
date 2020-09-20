package com.example.DEMO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/dateList")
@Controller
public class DateListController {

	 //一覧画面の表示
  @Autowired  //DateListMapper dateListMapper = new DatelistMapper(); インスタンス作成
              //今回の場合interfaceを
	DateListMapper dateListMapper;    //final =  定数の固定


  @GetMapping
  public String index() {
      return "index-dateList";
  }
  @GetMapping("new")
	public String getDateListNew() {
		return "index-new";
	}

  @GetMapping("update/{id}")
	public String getDateListUpdate() {
		return "index-update";
	}

	@PostMapping
	public String getDateLists(@RequestParam(name="textData")String text, Model model) {

		List<DateList> id = dateListMapper.id();                                       //idをList化  forのところで件数呼び出しに使う
		for(int i = 1 ; i <= id.size();i++ ) {                                         //取得したidの数だけデータ更新を繰り返す(id全てにデータを入れる)
		   String[] textRead =
		    	{ text.substring(0,4), text.substring(4,6), text.substring(6,8),};     //入力された文字を３分割して配列に変換
		   String textX = textRead[0] + "/" + textRead[1] + "/" + textRead[2];         //テキストを日付パターンへ変更
		   DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy/MM/dd")          //日付がオーバーしたら自動修正
				                       .withResolverStyle(ResolverStyle.LENIENT);
		   LocalDate ymd = LocalDate.parse(textX,date);                                //日付パターンと自動修正を組み合わせて日付の完成
		   String[] ymdSplit =dateListMapper.ymd(i).split("/");                        //データベースから呼び出した/区切りのStringを/ごとに分割し配列に変換
           int[] ymdInt = Stream.of(ymdSplit).mapToInt(Integer::parseInt).toArray();   //Stream 配列そのものをString型からint型へ変換するAPI
		       ymd = ymd.plusYears(ymdInt[0]);                                         //年の値
		       ymd = ymd.plusMonths(ymdInt[1]);                                        //月の値
		       ymd = ymd.plusDays(ymdInt[2]);                                          //日の値
		   String ymdCalc = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(ymd);     //LocalDate型からString型に変更
		   dateListMapper.updateCalc(ymdCalc,i);                                       //データの更新
		}
        model.addAttribute("text",text);                                               //出力確認で使用可能
		List<DateList> list =dateListMapper.selectAll();                               //selectAllでデータをList配列に入れる
		model.addAttribute("dateList",list);                                           //add=追加 attribute=属性 ("htmlで使う変数名",オブジェクトを渡す)
		return "index-dateList";                                                       //"○○○"にテキストを返す
	}
	@PostMapping("update/{id}")
	public String DateListUpdate(
			@PathVariable("id")int id,
			@RequestParam(name="idText") String idText,
			@RequestParam(name="nameText") String nameText,
			@RequestParam(name="yearText") String yearText,
			@RequestParam(name="monthText") String monthText,
			@RequestParam(name="dayText") String dayText,
			Model model
      ) {
		String ymdS =yearText + "/" + monthText + "/" + dayText;

        dateListMapper.update(idText, nameText, ymdS, id);

		return "index-update";
	    }
    @PostMapping("{id}")
    public String deleteUser(@PathVariable int id) {
      dateListMapper.delete(id);
      return "redirect:/dateList";
    }
    @PostMapping("new")
	public String indexCreate(
			@RequestParam(name="NewId")String NewId,
			@RequestParam(name="NewName")String NewName,
			@RequestParam(name="NewYear")String NewYear,
			@RequestParam(name="NewMonth")String NewMonth,
			@RequestParam(name="NewDay")String NewDay
			) {
    	String ymdS = NewYear + "/" + NewMonth + "/" + NewDay;
    	dateListMapper.create(NewId, NewName, ymdS);
		return "redirect:/dateList";
	}
			   //詳細画面の表示
    /*
	@GetMapping("{id}")//←{pass変数の指定} ↓＠PathVariable この引数が、パス変数によって値を渡される
	public String getDateList(@PathVariable int id,Model model) {
		DateList dateList = (DateList) dateListMapper.selectAll();
		model.addAttribute("dateList",dateList);//("テンプレートから参照する")
		return "dateList";
	}
	  /**
	   * 新規作成画面の挿入処理

	@GetMapping("new")
	public String getDateListNew(Model model) {
		DateList dateList = new DateList();
		model.addAttribute("dateList",dateList);
		return "dateList/new";
	}
	/**
	   * 新規作成画面の挿入処理

	/*
	@PostMapping
	public String postDateListCreate(@ModelAttribute @Validated DateList dateList,
	      BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
		      return "dateLists/new";
		    }
		    dateListMapper.insert(dateList);
		    return "redirect:/datelists";
		  }
	/**
	   * 編集画面の表示

    @GetMapping("{id}/edit")
    public String getDateListEdit(@PathVariable int id, Model model) {
    	DateList dateList = dateListMapper.select(id);
    		model.addAttribute("dateList",dateList);
    		return "dateLists/edit";
    	}
    /**
     * 編集画面の更新処理

    @PutMapping("{id}")
    public String putDateListEdit(@PathVariable int id, @ModelAttribute @Validated DateList dateList,
        BindingResult bindingResult) {
      if (bindingResult.hasErrors()) {
        return "dateList/edit";
      }
      dateList.setId(id);
      dateListMapper.update(dateList);
      return "redirect:/dateList";
    }
    /**
     * 削除処理

    @DeleteMapping("{id}")
    public String deleteUser(@PathVariable int id, Model model) {
      dateListMapper.delete(id);
      return "redirect:/dateLists";
    }
*/
}
