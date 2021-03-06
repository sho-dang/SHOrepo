 
# 休暇管理アプリケーション

こちらは月ごとの休暇者を管理するアプリケーションです。  
※4組3交替勤務専用

～ 4組3交替について ～

・4組3交替の勤務形態

  4組 = 4つのシフト勤務グループ  
  3交替 = 勤務形態  
  　1直(朝～夕方 勤務)  
  　2直(夕方～夜中 勤務)  
  　3直(夜中～朝 勤務)  
   
   交替勤務カレンダーサンプル  
   https://github.com/sho-dang/SHOrepo/wiki/%E4%BA%A4%E4%BB%A3%E5%8B%A4%E5%8B%99%E3%82%B7%E3%83%95%E3%83%88%E8%A1%A8%E3%82%B5%E3%83%B3%E3%83%97%E3%83%AB 
   
### アプリケーション使用時のシミュレーションです。ご参照ください。  
### https://github.com/sho-dang/SHOrepo/wiki
   
# 背景  
 
・交替勤務のシフトリーダー業務で、作業者の休暇日、残業日・早出日を管理していました。  
  毎月、Excelを用いて、上記の交替勤務カレンダーサンプルを元に、  
  管理表を作成していましたが、作成には20分ほど時間がかかります。   
  そのため、問題点の一つとして「作成時間」が挙げられます。
  
・Excelで作成した管理表は、変更・閲覧権限がシフトリーダー以上になっていたため、  
  作業者が勤怠情報を確認したいときは、その都度、シフトリーダーが管理表を開いて見せていました。  
  そのときにかかる時間と手間を削減できると考えました。  

# 目的

  ・ 管理表の作成時間削減
  　※Excelによる作成20分　→　5分に短縮が見込める

  ・ 職場ごとで個別に休暇管理を行える
  
  ・ 作業者が各自で休暇・残業・早出の予定を確認出来る

# 機能

  ・ 月ごとの休暇者を管理する

  ・ 休暇者に応じた早出・残業者を記録する

  ・ 4組3交替 管理表の自動生成

  ・ 勤務形態の自動色分け



# 前提条件

  ・ 4組3交替の勤務形態で休暇管理表を作成する

  ・ 5日間出勤したら2日間休み  
    ※ただし、1直勤務(朝～夕)から3直勤務(夜中～朝)へ切り替わりの際は、休みは1日となる
    
  ・ 月ごとに、一斉休暇日が存在する(工場全体が休み)

# 工夫した点

・DBがボトルネックにならないように、登録情報をコード化して、無駄な空のデータを作らないようにした。  
・switch文を利用して、シフトごとのデータを振り分け、色の振り分けする処理をした。  
・交替勤務カレンダーサンプルから、勤務形態（1直、2直、3直）切り替わりの規則性を見つけ出し、  
  DBのshiftpatternテーブルへデータを登録。そのデータを用いて自動計算を行っている。  
・バリデーションによる入力チェックを細かく設定した。  
・JUnit4でのテスト実装では、単体テストへ力を入れた。  
・Theoryテスト実装し、自動計算のメソッドで、複数の入力パターンを検証するテストをした。  
・Mockitoフレームワークを用いて画面表示、画面遷移のテストを実装した。  

# 課題

・月ごとにテーブルを作成する機能を追加する。  
・現状は、休暇者、残業者、早出者それぞれ１人づつしか登録できないため、複数人登録を可能にする。  
・ログイン機能追加  

# 改善点

・RDBを使っているが、テーブル同士で関連づいてないDB設計となった。  
・11月の月でしか管理ができない状態である。  
・4組3交替のみの想定のため、他の勤務形態でも管理できるようにしたい。  

