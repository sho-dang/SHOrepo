package com.example.DEMO;

//import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	@PostMapping
	public String getDateLists(@RequestParam(name="textData")String text, Model model) {
		List<DateList> id = dateListMapper.id();
		for(int i = 1 ; i <= id.size();i++ ) {
		String[] textRead = { text.substring(0,4), text.substring(4,6), text.substring(6,8),};  //入力された文字を３分割して配列に変換
		int[] textInt = Stream.of(textRead).mapToInt(Integer::parseInt).toArray();  //Stream 配列そのものをString型からint型へ変換するAPI
        String[] ymdSplit =dateListMapper.ymd(i).split("/");                       //データベースから呼び出した/区切りのStringを/ごとに分割し配列に変換
        int[] ymdInt = Stream.of(ymdSplit).mapToInt(Integer::parseInt).toArray();    //Stream 配列そのものをString型からint型へ変換するAPI
		int[][] ymdIndex = {      //２次元配列使用     [レコード(上から下)][カラム(左から右)]
				{textInt[0],textInt[1],textInt[2]},             //0行目
				{ymdInt[0],ymdInt[1],ymdInt[2],}                //1行目
		        } ;
		int year = ymdIndex[0][0]+ymdIndex[1][0];           //年計算
		int month = ymdIndex[0][1]+ymdIndex[1][1];          //月計算
		int day = ymdIndex[0][2]+ymdIndex[1][2];            //日計算
		String ymdCalc = year + "/" + month + "/" + day ;    //年月日結合
        dateListMapper.updateCalc(ymdCalc,i); //
		}
        model.addAttribute("text",text);                 //出力確認用
		List<DateList> list =dateListMapper.selectAll();      //selectAllでデータをList配列に入れる
		model.addAttribute("dateList",list);            //add=追加 attribute=属性 ("htmlで使う変数名",オブジェクトを渡す)
		return "index-dateList";                        //　"○○○"にテキストを返す
	}
	@GetMapping("new")
	public String getDateListNew() {

		return "index-new";
	}
	@GetMapping("update")
	public String getDateListUpdate() {

		return "index-update";
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
