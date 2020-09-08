package com.example.DEMO;

//import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/dateList")
@Controller
public class DateListController {

	 //一覧画面の表示
  @Autowired  //DateListMapper dateListMapper = new DatelistMapper(); インスタンス作成
              //今回の場合interfaceを
	DateListMapper dateListMapper;    //final =  定数の固定

  /*
    public DateListController(DateListMapper dateListMapper) {
		this.dateListMapper = dateListMapper;
	}

    @Override
	  public void run(String... args) {
	   //System.out.println(dateListMapper.select(0));
       ///System.out.println(this.dateListMapper.count());
	  }
      */



	@GetMapping       //GetMappingのメソッドは書き方が決まっている・・・public String ****(){ return *****}
	public String getDateLists(Model model) {
		//int number = 1;
		//for(int i = 1; i <= numberList;i++) {}

		List<DateList> list =dateListMapper.selectAll(3);
		//for(int i = 1; i <= )
		System.out.println(list);
		model.addAttribute("dateList",list);//add=追加 attribute=属性 ("htmlで使う変数名",オブジェクトを渡す)
		return "index-dateList";
		//　"○○○"にテキストを返す
	}

	   //詳細画面の表示

	@GetMapping("{id}")//←{pass変数の指定} ↓＠PathVariable この引数が、パス変数によって値を渡される
	public String getDateList(@PathVariable int id,Model model) {
		DateList dateList = (DateList) dateListMapper.selectAll(2);
		model.addAttribute("dateList",dateList);//("テンプレートから参照する")
		return "dateList";
	}
	  /**
	   * 新規作成画面の挿入処理
       */
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
