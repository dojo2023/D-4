<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>使い方説明</title> ​
<link rel="stylesheet" href="explanation.css">
</head>
<body>
	<h1 class="logo">
		<img src="" alt="【ロゴ】">アプリ名
	</h1>
	<!-- ロゴ画像とアプリ名 -->
	​
	<div class=wrapper>
		<!-- ヘッダー -->
		<header class=header>

			<nav class="nav">
				<ul>
					<li><a href="/amateur/ScheduleServlet">1日のスケジュール</a></li>
					<li><a href="/amateur/CalendarServlet">カレンダー</a></li>
					<li id=add>追加</li>
					<li><a href="/amateur/AchieveServlet">達成度</a></li>
					<li><a href="/amateur/ExplanationServlet">アプリの使い方</a></li>
					<li id="logout"><a href="/amateur/LogoutServlet">ログアウト</a></li>
				</ul>
			</nav>
		</header>
		<main>
			<div class="container">
				<h2>アプリの使い方</h2>

				<button id="myButton1" onclick="changeButton1()">▷</button>
				タイトル１
				<p id="description1" style="display: none;">説明1</p>
				<br> ​
				<button id="myButton2" onclick="changeButton2()">▷</button>
				タイトル２
				<p id="description2" style="display: none;">説明２</p>
				<br> ​
				<button id="myButton3" onclick="changeButton3()">▷</button>
				タイトル３
				<p id="description3" style="display: none;">説明３</p>
				<br>
			</div>
		</main>
</body>
<footer class="footer">
	<p>&copy; Amateur-Programmers</p>
</footer>
</html>