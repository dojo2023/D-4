<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>使い方説明</title>

<link rel="stylesheet" href="common.css">
<link rel="stylesheet" href="explanation.css">
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
            <text-area>タイトル１</text-area>
            <p id="description1" style="display: none;">一日のスケジュールを管理するページです。
                目標設定画面で設定して目標が一目で分かります。
                タスク追加画面で設定したToDoが表示され一目で分かります。
                タスクを記入すると時刻管理も一緒に表示されます。
                メモ欄には自由に記入して置くことができます。</p><br>

            <button id="myButton2" onclick="changeButton2()">▷</button>
            <text-area>タイトル２</text-area>
            <p id="description2" style="display: none;">説明２</p><br>

            <button id="myButton3" onclick="changeButton3()">▷</button>
            <text-area>タイトル３長さによってボタンの位置がずれるのは何？</text-area>
            <p id="description3" style="display: none;">説明３</p><br>
          </div>

          <footer>
            <p>&copy;Copyright plusDOJO(SE plus) amateur programmer. All rights reserved.</p>


        <script src="explanation.js"></script>
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