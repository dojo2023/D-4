<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.time.LocalDate" %>

<%
  LocalDate currentDate = LocalDate.now();
%>

<html>
<meta charset="UTF-8">
<link rel ="stylesheet"href="/simpleBC/css/Scedule.css">
<head>
  <style>
    .popup {
      position: fixed;
      top: 50%;
      left: 50%;
      transform: translate(-50%, -50%);
      background-color: #555;
      color: #fff;
      width: 200px;
      padding: 20px;
      text-align: center;
      border-radius: 6px;
      visibility: hidden;
      opacity: 0;
      transition: visibility 0s, opacity 0.3s;
    }

    .popup.show {
      visibility: visible;
      opacity: 1;

    }
  </style>
  <div id="popup" class="popup">

    <p>今日も１日頑張りましょう！</p>
    <button class="close-btn">閉じる</button>

  <script>
    window.addEventListener('DOMContentLoaded', (event) => {
      // ページ読み込み時にポップアップを表示
      const popup = document.querySelector('.popup');
      popup.classList.add('show');
    });
  </script>
</head>
<body>

  <script>
  const popup = document.querySelector('.popup');
  const closeBtn = document.querySelector('.close-btn');
  closeBtn.addEventListener('click', () => {
    popup.style.display = 'none'; // ポップアップを非表示にする
  });
</script>
</div>
<title>1日のスケジュール</title>
<div class = wrapper>
<!-- ヘッダー -->
<header class = header>
<!-- <img src = ""> -->
<h1>ロゴあなただけの秘書</h1>
</header>
<div class = wrapper>
        <!-- ヘッダー -->
        <header class = header>
        <nav class="nav">
                        <ul>
                            <li><a href="/amateur/ScheduleServlet">1日のスケジュール</a></li>
                            <li><a href="/amateur/CalendarServlet">カレンダー</a></li>
                                <li class="dropdown">
                                <a href="#">追加</a>
                                    <div class="dropdown-content">
                                        <a href="/amateur/GoalRegistServlet">目標追加画面</a>
                                        <a href="/amateur/TaskRegistServlet">タスク追加画面</a>
                                    </div>
                                </li>
                            <li><a href="/amateur/AchieveServlet">達成度</a></li>
                            <li class="current"><a href="/amateur/ExplanationServlet">アプリの使い方</a></li>
                            <li id = "logout"><a href="/amateur/LogoutServlet">ログアウト</a></li>
                        </ul>
                    </nav>
        </header>
    </div>
    <hr>
<div class="lg">
長期目標<br>
%
</div>
<div class="sg">
短期目標<br>
%
</div>
<div class="todo">
Todoリスト<br>
%<br>
%<br>
%<br>
</div>
メモ<br>
<div class="form-container">
  <textarea id="input-text"></textarea>
</div>
<script>
var inputText = document.getElementById("input-text");

inputText.addEventListener("input", function(event) {
	  inputText.style.height = "auto";
	  inputText.style.height = inputText.scrollHeight + "px";
	});
</script>
<a href="">登録</a>
<div class="carender">
	    <h2 id="current-date"></h2>
	    <button id="prev-day-btn">◁</button>
	    <button id="next-day-btn">▷</button>
	  <script src="date-switch.js"></script>
	  <script>
	//現在の日付を取得
	  let currentDate = new Date();

	  // 日付を表示する要素の取得
	  const currentDateElement = document.getElementById('current-date');

	  // 日付を表示する関数
	  function displayDate() {
	    const options = { weekday: 'long',  month: 'long', day: 'numeric' };
	    currentDateElement.textContent = currentDate.toLocaleDateString(undefined, options);
	  }

	  // 前日に切り替える関数
	  function switchToPreviousDay() {
	    currentDate.setDate(currentDate.getDate() - 1);
	    displayDate();
	  }

	  // 翌日に切り替える関数
	  function switchToNextDay() {
	    currentDate.setDate(currentDate.getDate() + 1);
	    displayDate();
	  }

	  // ボタンのクリックイベントリスナーの登録
	  document.getElementById('prev-day-btn').addEventListener('click', switchToPreviousDay);
	  document.getElementById('next-day-btn').addEventListener('click', switchToNextDay);

	  // 初期の日付表示
	  displayDate();
	  </script>
	  <style>
	    table {
	      border-collapse: collapse;
	    }
	    th,td {
	      border: 1px solid black;
	      padding: 5px;
	    }
	  </style>
	  </div>
	  <div class="time">
	  <h3>時刻表</h3>
	  <table>
	    <thead>
	      <tr>
	        <th>時間</th>
	        <th>予定</th>
	      </tr>
	    </thead>
	    <tbody>
	      <!-- ここに時間ごとの行を追加します -->
	    </tbody>
</table>
	<script>
	  window.onload = function() {
	    var tableBody = document.querySelector('tbody');
	    for (var hour = 0; hour <= 23; hour++) {
	      var row = document.createElement('tr');
	      var timeCell = document.createElement('td');
	      timeCell.textContent = hour + ':00';
	      var eventCell = document.createElement('td');
	      // ここで各時間の予定を表示するための処理を追加します
	      row.appendChild(timeCell);
	      row.appendChild(eventCell);
	      tableBody.appendChild(row);
	    }
	  };

	</script>
	</div>

	</div>
</body>

</html>
