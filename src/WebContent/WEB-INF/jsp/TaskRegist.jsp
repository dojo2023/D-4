<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
	<title>タスク追加</title>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>
	<div class=wrapper>
		<!-- ヘッダー -->
		<header class=header>
			<h1>アプリ名</h1>
			<nav class="nav">
				<ul>
					<li><a href="/amateur/ScheduleServlet">1日のスケジュール</a></li>
					<li><a href="/amateur/CalendarServlet">カレンダー</a></li>
					<li id=add>追加</li>
					<li><a href="/amateur/AchieveServlet">達成度</a></li>
					<li><a href="/amateur/ExplanationServlet">アプリの使い方</a></li>
				</ul>
			</nav>
		</header>
		<!-- メイン -->
		<main class="main">
			<h1>タスク</h1>
			<!-- form -->
			<form id="dataForm" action="TaskRegistServlet" method="POST">
				<!-- +ボタンでコピーされるコピー元 -->
				<div id="container" style="display: none;">
					<input type="text" class="taskBox" name="task_0">
					<input type="datetime-local"class="timesBox" name="times_0">
					<input type="datetime-local"class="timeeBox" name="timee_0">
				</div>
				<!-- ディスプレイ上の一個目 -->
				<input type="text" id="task1" class="taskBox" name="task_1">
				<input type="datetime-local"class="timesBox" name="times_1">
				<input type="datetime-local"class="timeeBox" name="timee_1"><br>
				<!-- taskを追加するためのボタン -->
                <div id="plus">
				<button type="button" onclick="addTaskBox()">+</button>
				<input id="taskcount" type="hidden" value="" name="length">
                </div>
				<!-- 登録ボタン -->
                <div id="register">
				<input type="submit" value="登録">
                </div>
			</form>

		</main>
	</div>
	<script>
		function addTaskBox() {
			var container = document.getElementById("container").cloneNode(true);
			container.style.display = "block";
			console.log(container);//<div id="container" style="display: block;">
			// 追加するtaskBoxの名前を task_ + 今の個数にする
			let taskBoxName = "task_" + document.getElementsByClassName("taskBox").length;
			let timesBoxName = "times_" + document.getElementsByClassName("timesBox").length;
			let timeeBoxName = "timee_" + document.getElementsByClassName("timeeBox").length;
			console.log(taskBoxName);//task_2
			// 追加するtaskBoxを取得
			let taskbox = container.getElementsByClassName("taskBox")[0];
			taskbox.name = taskBoxName;
			console.log(taskbox.name);//task_2
			console.log(taskbox);//<input class="taskBox" type="text" name="task_2">
			console.log(container.getElementsByClassName("timesBox")[0]);
			console.log(container.getElementsByClassName("timesBox")[0].name = timesBoxName);
			container.getElementsByClassName("timesBox")[0].name = timesBoxName;
			container.getElementsByClassName("timeeBox")[0].name = timeeBoxName;
			//taskの個数を送信するために格納
			var taskboxCount = document.getElementsByName("taskBox").length;
			var taskcountInput = document.getElementById("taskcount");
			taskcountInput.value = taskboxCount;

			// タスクボックスを追加する位置を特定
			var task1 = document.getElementById("task1");
			// タスクボックスを追加
			task1.parentNode.insertBefore(container, null);//第二引数task1.nextSibling

			var deleteButton = document.createElement("button");
			deleteButton.innerText = "-";
			deleteButton.onclick = function () {
				var taskContainer = deleteButton.parentNode;
				taskContainer.parentNode.removeChild(taskContainer);
			}
			container.appendChild(deleteButton);

		}
	</script>
</body>

</html>