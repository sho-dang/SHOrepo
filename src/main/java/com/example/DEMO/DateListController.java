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
	DateListMapper dateListMapper;


  @GetMapping
  public String index() {
      return "index-dateList";
  }
  @GetMapping("new")
	public String getDateListNew() {
		return "index-new";
	}
  @GetMapping("update/{dateId}")
	public String getDateListUpdate() {
		return "index-update";
	}

	@PostMapping      //計算メソッド
	public String getDateLists(@RequestParam(name="textData")String text, Model model) {
		List<DateList> dateId = dateListMapper.id();                                       //idをList化  forのところで件数呼び出しに使う
		String[] dateIdList = dateListMapper.selectOne();                                  //dateIdすべて取得できるように配列化
		for(int i = 0 ; i < dateId.size();i++ ) {                                         //取得したidの数だけデータ更新を繰り返す(id全てにデータを入れる)
		   String[] textRead =
		    	{ text.substring(0,4), text.substring(4,6), text.substring(6,8),};     //入力された文字を３分割して配列に変換
		   String textX = textRead[0] + "/" + textRead[1] + "/" + textRead[2];         //テキストを日付パターンへ変更
		   DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy/MM/dd")          //日付がオーバーしたら自動修正
				                       .withResolverStyle(ResolverStyle.LENIENT);
		   LocalDate ymd = LocalDate.parse(textX,date);                                //日付パターンと自動修正を組み合わせて日付の完成
		   String[] ymdSplit =dateListMapper.ymd(dateIdList[i]).split("/");            //データベースから呼び出した/区切りのStringを/ごとに分割し配列に変換
           int[] ymdInt = Stream.of(ymdSplit).mapToInt(Integer::parseInt).toArray();   //Stream 配列そのものをString型からint型へ変換するAPI
		       ymd = ymd.plusYears(ymdInt[0]);                                         //年の値
		       ymd = ymd.plusMonths(ymdInt[1]);                                        //月の値
		       ymd = ymd.plusDays(ymdInt[2]);                                          //日の値
		   String ymdCalc = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(ymd);     //LocalDate型からString型に変更
		   dateListMapper.updateCalc(ymdCalc,dateIdList[i]);                           //データの更新
		}
        model.addAttribute("text",text);                                               //出力確認で使用可能
		List<DateList> list =dateListMapper.selectAll();                               //selectAllでデータをList配列に入れる
		model.addAttribute("dateList",list);                                           //add=追加 attribute=属性 ("htmlで使う変数名",オブジェクトを渡す)
		return "index-dateList";                                                       //"○○○"にテキストを返す
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
	@PostMapping("update/{dateId}")
	public String DateListUpdate(
			@PathVariable("dateId")String dateId,                                      //PathVariableでパラメータ取得し、変数として使用できる
			@RequestParam(name="idText") String idText,                                //入力したテキストにnameを与え、変数として使用可能×５
			@RequestParam(name="nameText") String nameText,
			@RequestParam(name="yearText") String yearText,
			@RequestParam(name="monthText") String monthText,
			@RequestParam(name="dayText") String dayText,
			Model model
      ) {
		String ymdS =yearText + "/" + monthText + "/" + dayText;                       //年月日それぞれ分割されているので一つにまとめる

        dateListMapper.update(idText, nameText, ymdS, dateId);                         //日付、日付名、年月日を更新(dateIdで指定)

		return "index-update";
	    }
    @PostMapping("{dateId}")
    public String indexDelete(@PathVariable String dateId) {
      dateListMapper.delete(dateId);                                                       //削除メソッド()
      return "redirect:/dateList";
    }
}
