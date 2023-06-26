<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>使い方説明</title>

<link rel="stylesheet" href="/amateur/css/common.css">
<link rel="stylesheet" href="/amateur/css/explanation.css">
</head>
<body>
    <main>
    <div class = wrapper>
        <header class = header>
    <h1 class="logo"><img src="" alt="【ロゴ】">アプリ名アプリ名アプリ名</h1>

        <nav class="nav">
                        <ul>
                            <li><a href="/amateur/ScheduleServlet">1日のスケジュール</a></li>
                            <li><a href="/amateur/CalendarServlet">カレンダー</a></li>
                                <li class="dropdown">
                                <a href="#">追加▽</a><!-- #で遷移なしの表示する？ -->
                                    <div class="dropdown-content">
                                        <a href="/amateur/GoalRegistServlet">目標追加画面</a>
                                        <a href="/amateur/TaskRegistServlet">タスク追加画面</a>
                                    </div>
                                </li>

                            <li><a href="/amateur/AchieveServlet">達成度</a></li>
                            <li class="current"><a href="/amateur/ExplanationServlet">アプリの使い方</a></li>
                            <!-- currentで選択ページの下に色線がつくから各ページ変える -->
                            <li id = "logout"><a href="/amateur/LogoutServlet">ログアウト</a></li>
                        </ul>
                    </nav>
        </header>
    </div>


        <div class="container">
            <h2>アプリの使い方</h2>

             <button id="myButton1" onclick="changeButton1()">▷</button>
            <text-area>スケジュールページ</text-area>
            <p id="description1" style="display: none;">一日のスケジュールを管理するページです。<br>
                目標設定画面で設定して目標が一目で分かります。<br>
                タスク追加画面で設定したToDoが表示され一目で分かります。<br>
                タスクを記入すると時刻管理も一緒に表示されます。<br>
                メモ欄には自由に記入して置くことができます。</p><br>

            <button id="myButton2" onclick="changeButton2()">▷</button>
            <text-area>カレンダーページ</text-area>
            <p id="description2" style="display: none;">月ごとに予定を管理できるページです。<br>
                予定を入れたい日にちを選択すると入力画面に行きます。<br>
                目標追加画面で設定した短期目標を確認することができます。</p><br>

            <button id="myButton3" onclick="changeButton3()">▷</button>
            <text-area>目標追加ページ</text-area>
            <p id="description3" style="display: none;">長期目標、短期目標、ToDoを設定できます。<br>
                入力したい日付を合わせて下さい。<br>
                長期目標を入力してください。長期間表示されます。<br>
                短期目標を入力してください。<br>
                ToDoリストを短期目標に合わせて入力してください。</p><br>

                 <button id="myButton4" onclick="changeButton4()">▷</button>
            <text-area>タスク追加ページ</text-area>
            <p id="description4" style="display: none;">日々のタスクを設定できます。<br>
                入力したい日付を合わせて下さい。<br>
                タスクを入力してください。<br>
                行う時間を設定してください。 </p><br>
          </div>

          <footer>
            <p>&copy;Copyright plusDOJO(SE plus) amateur programmer. All rights reserved.</p>


        <script src="/amateur/js/explanation.js"></script>
    <!--<script>
    //ボタンの表示を横向きから下向きに変える
    //後でJavaScriptに書き換える
    //試しに三つサンプルを書いてある。コピペで（^-^）
    //疲れてきたね、頑張ろbyかいせい
    function changeButton1() {
     var button = document.getElementById('myButton1');
     const description1 = document.getElementById('description1');

    if (button.innerHTML === '▷') {
        button.innerHTML = '▽';
    } else {
        button.innerHTML = '▷';
    }
    if (description1.style.display === 'none') {
        description1.style.display = 'block';
     } else {
        description1.style.display = 'none';
    }
    }
    function changeButton2() {
     var button = document.getElementById('myButton2');
     const description2 = document.getElementById('description2');

    if (button.innerHTML === '▷') {
        button.innerHTML = '▽';
    } else {
        button.innerHTML = '▷';
    }
    if (description2.style.display === 'none') {
        description2.style.display = 'block';
     } else {
        description2.style.display = 'none';
    }
    }
    function changeButton3() {
     var button = document.getElementById('myButton3');
     const description3 = document.getElementById('description3');

    if (button.innerHTML === '▷') {
        button.innerHTML = '▽';
    } else {
        button.innerHTML = '▷';
    }
    if (description3.style.display === 'none') {
        description3.style.display = 'block';
     } else {
        description3.style.display = 'none';
    }
}



  </script>-->
</footer>
  </main>
</body>
</html>