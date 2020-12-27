package com.example.days.Tests.ServiceTest;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assume.assumeThat;
import static org.mockito.Mockito.calls;

import java.util.List;

import com.example.days.Service.AppService;
import com.example.days.domain.Day.DayList;
import com.example.days.domain.NameList.NameList;

import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;

/*
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppServiceTest {
    public AppService service;

        @Before
        public void initialize(){
        service = new AppService();
        }

    @Test
    public void ーnameListAllメソッドーnameListを全件取得できていること()throws Exception{
        List<NameList> nameList = service.nameListAll();
        int matcher = 16 ;
        assertThat(nameList, hasSize(matcher));
    }
    @Test
    public void ーlistOneメソッドー選択したshiftNameのレコード件数が一致すること()throws Exception{
        List<NameList> listOne = service.listOne("シフト1");
        int matcher = 4;
        assertThat( listOne, hasSize(matcher));
    }

    @Test
    public void ーconvertNameメソッドー指定したIDの名前を取得できていること()throws Exception{
        String nameId = "SA";
        String matcherName = "伊藤A子";
        String convertName = service.convertName(nameId);
        assertThat(convertName, is(matcherName));
    }
    @Test(expected = NullPointerException.class)
    public void ーconvertNameメソッドー指定したIDが存在しない場合にエラーとなること()throws Exception{
        String nameId = "AA";
        String convertName = service.convertName(nameId);
        assertThat(convertName, is(null));
    }

    @Test
    public void ーconvertIdメソッドー指定した名前のIDを取得できていること()throws Exception{
        String name = "伊藤A子";
        String matcherId = "SA";
        String convertId = service.convertId(name);
        assertThat(convertId, is(matcherId));
    }
    @Test(expected = NullPointerException.class)
    public void ーconvertIdメソッドー指定した名前が存在しない場合にエラーとなること()throws Exception{
        String name = "飯田Z子";
        String convertId = service.convertId(name);
        assertThat(convertId, is(null));
    }
    
    @Test //シフト振り分け用メソッド未完成
    public void ーshiftListメソッドーインスタンス作成後新しいNameListを取得できていること()throws Exception{
        List<NameList> listTest = service.nameListAll();
        List<NameList> resultList = service.shiftList(listTest);
        int matcher = 16 ;
        assertThat(resultList, hasSize(matcher));
    }
    @Test
    public void ーdaysメソッドー取得したDayListの日付件数が一致すること()throws Exception{
        List<DayList> dayTest = service.days();
        int monthDays = 30;
        assertThat(dayTest,hasSize(monthDays));
    }
    @Test
    public void ーmatchWorkIdメソッドー選択したdateと一致するworkIdを取得できていること()throws Exception{
        int selectDay = 1 ;
        String workId = service.matchWorkId(selectDay);
        String matcher = "0000";
        assertThat(workId, is(matcher));
    }
    @Test
    public void ーmatchWorkIdメソッドー存在しない日付を入力した場合にworkIDはNULLになりエラーとなること()throws Exception{
        int selectDay = 31 ;
        String workId = service.matchWorkId(selectDay);
        String matcher = null;
        assertThat(workId, is(matcher));
    }
    @Test
    public void ーshiftPatternメソッドー指定したnumberと一致するshiftPatternを取得できること()throws Exception{
        int number = 1 ;
        String shiftPattern = service.shiftPattern(number);
        String matcher = "4321";
        assertThat(shiftPattern, is(matcher)); 
    }
    @Test
    public void ーshiftPatternメソッドー存在しないnumberを入力した場合にshiftpatternはNULLになりエラーとなること()throws Exception{
        int number = 21 ;
        String shiftPattern = service.shiftPattern(number);
        String matcher = null;
        assertThat(shiftPattern, is(matcher)); 
    }
    @Test 
    public void updateMethodメソッドー()throws Exception{
        int startDate = 1 ;
        String code = "33334";

        service.updateWorkId(startDate, code);

        String dayOne =service.matchWorkId(1);
        String dayTwo = service.matchWorkId(2);
        String dayThree = service.matchWorkId(3);
        String dayFour = service.matchWorkId(4);
        String dayFive = service.matchWorkId(5);
        String changedCode = dayOne.substring(0,1) + 
                        dayTwo.substring(0,1) +
                        dayThree.substring(0,1) +
                        dayFour.substring(0,1) +
                        dayFive.substring(0,1);
        assertThat(code, is(changedCode));
    } 
    
}
*/

@RunWith(Theories.class)
@SpringBootTest
    public class AppServiceTest{
        @Autowired
        AppService service;

        @ClassRule
        public static final SpringClassRule SPRING_CLASS_RULE = new SpringClassRule();

        @Rule
        public final SpringMethodRule springMethodRule = new SpringMethodRule();

        /**
         * テストデータ
         * param 日付
         */
        @DataPoints
        public static DateFixture[] Param = {
            new DateFixture(1,"11433",new int[]{25,26},"1234"),//4月
            new DateFixture(1,"44222",new int[]{2,3,4,5,6},"4132"),//5月
            new DateFixture(1,"42222",new int[]{7,8,9,10,11,12,13,14,15,16},"1234"),//8月
            new DateFixture(4,"11143",new int[]{1,2,3},"4213"),//1月
        };
        
        @Theory
        public void 一斉休暇日を変更した後出勤日の自動計算ができていること(DateFixture p)throws Exception{
            
            for(int i = p.休暇日[0] ; i < p.休暇日[0]+p.休暇日.length ; i++){
                service.updateAllVacation(i);
            };
            service.updateWorkId(p.日付,p.出勤形態);

            //休暇日が無い20日を検証
            DayList workCode = service.selectDayList(20);
            List<DayList> uo = service.days();

            //休暇日初期化
            for(int i = p.休暇日[0] ; i < p.休暇日[0]+p.休暇日.length ; i++){
                service.deleteAllVacation(i);
            };
            //assumeThat(, actual, matcher);
            //assertThat(service.selectDayList(p.日付).getDate(), is(p.日付));
            assertThat(workCode.getWorkId(),is(p.期待値));
            
        }

        //@Ignore("its Fixture class")
        static class DateFixture{
            /** 日付
             *  1日〜30日(11月)
             */
            int 日付;
            /** 出勤形態
             *     1 = 1直
             *     2 = 2直
             *     3 = 3直
             *     4 = 休み
             */
            String 出勤形態; 

            int[] 休暇日; 

            String 期待値;

            DateFixture(int 日付,String 出勤形態,int[] 休暇日,String 期待値){
                this.日付 = 日付;
                this.出勤形態 = 出勤形態;
                this.休暇日 = 休暇日;
                this.期待値 = 期待値;
            }
        }
    }

