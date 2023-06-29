<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>使い方説明</title>
<link rel="icon" type="image/png" href="/amateur/img/fabicon.png">
<link rel="stylesheet" href="/amateur/css/common.css">
<link rel="stylesheet" href="/amateur/css/explanation.css">
</head>
<body>
    <div class = wrapper>
        <header class = header>
    <img src="/amateur/img/logo.png" alt="Image" class="image"id="moving-image">

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

        <script src="/amateur/js/explanation.js"></script>
	<footer class="footer">
		 &copy;Copyright plusDOJO(SE plus) amateur programmer. All rights reserved.
		</footer>
</div>
</body>
</html>