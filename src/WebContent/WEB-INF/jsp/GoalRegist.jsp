<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<head>
<meta charset="UTF-8">
<title>目標追加</title>

<link rel="stylesheet" href="/simpleBC/SimpleBC_css/common.css">
<link rel="stylesheet" href="/simpleBC/SimpleBC_css/goal_regist.css">
</head>

<body>
	<div class="wrapper">
		<!-- ヘッダー -->
		<header class="header">
			<img src="" alt="ロゴ画像">
			<h1>アプリ名</h1>
			<nav class="nav">
				<ul>
					<li><a href="/amateur/ScheduleServlet">1日のスケジュール</a></li>
					<li><a href="/amateur/CalendarServlet">カレンダー</a></li>
					<li id=add><a href="/amateur/GoalRegistServlet">追加</a></li>
					<li><a href="/amateur/AchieveServlet">達成度</a></li>
					<li><a href="/amateur/ExplanationServlet">アプリの使い方</a></li>
				</ul>
			</nav>
		</header>
		<!-- メイン -->
		<main class="main">
			<form id="dataForm" action="GoalRegistServlet" method="POST">
				<!-- 現在の年月を表示 -->
				<div class="monthMove">
					<div class="monthcontent">
						<!-- //の中に動かしたいプロジェクト名を入れてください -->
						<a href='/simpleBC/GoalLastMonthServlet' class="prev"></a>
					</div>
					<div class=monthcontent>
						<h3>
							<c:out value="${displayYear}" />
							年
							<c:out value="${displayMonth}" />
							月
						</h3>
					</div>
					<div class="monthcontent">
						<a href='/simpleBC/GoalNextMonthServlet' class="next"></a>
					</div>
				</div>

				<h1>目標追加</h1>
				<!-- 長期目標 -->
				<label>長期目標</label> <input id="lgInput" type="text" name="lg"><br>
				<!-- 短期目標１ -->
				<label>短期目標１</label> <input id="sgInput1" type="text" name="sg1"><input
					type="date" id="sgStart" name="day_s_1" placeholder="開始"> <input
					type="date" id="sgEnd" name="day_e_1" placeholder="終了"><br>
				<!-- 短期目標１のToDoグループ -->
				<input id="tdInput1_1" type="text" name="td1_1" placeholder="todo"><br>
				<input id="tdInput1_2" type="text" name="td1_2" placeholder="todo"><br>
				<input id="tdInput1_3" type="text" name="td1_3" placeholder="todo"><br>
				<input id="tdInput1_4" type="text" name="td1_4" placeholder="todo"><br>
				<input id="tdInput1_5" type="text" name="td1_5" placeholder="todo"><br>
				<!-- 短期目標２ -->
				<label>短期目標２</label> <input id="sgInput2" type="text" name="sg2"><input
					type="date" id="sgStart" name="day_s_2" placeholder="開始"> <input
					type="date" id="sgEnd" name="day_e_2" placeholder="終了"><br>
				<!-- 短期目標２のToDoグループ -->
				<input id="tdInput2_1" type="text" name="td2_1" placeholder="todo"><br>
				<input id="tdInput2_2" type="text" name="td2_2" placeholder="todo"><br>
				<input id="tdInput2_3" type="text" name="td2_3" placeholder="todo"><br>
				<input id="tdInput2_4" type="text" name="td2_4" placeholder="todo"><br>
				<input id="tdInput2_5" type="text" name="td2_5" placeholder="todo"><br>
				<!-- 短期目標３ -->
				<label>短期目標３</label> <input id="sgInput3" type="text" name="sg3"><input
					type="date" id="sgStart" name="day_s_3" placeholder="開始"> <input
					type="date" id="sgEnd" name="day_e_3" placeholder="終了"><br>
				<!-- 短期目標３のToDoグループ -->
				<input id="tdInput3_1" type="text" name="td3_1" placeholder="todo"><br>
				<input id="tdInput3_2" type="text" name="td3_2" placeholder="todo"><br>
				<input id="tdInput3_3" type="text" name="td3_3" placeholder="todo"><br>
				<input id="tdInput3_4" type="text" name="td3_4" placeholder="todo"><br>
				<input id="tdInput3_5" type="text" name="td3_5" placeholder="todo"><br>
				<!-- 短期目標４ -->
				<label>短期目標４</label> <input id="sgInput4" type="text" name="sg4"><input
					type="date" id="sgStart" name="day_s_4" placeholder="開始"> <input
					type="date" id="sgEnd" name="day_e_4" placeholder="終了"><br>
				<!-- 短期目標４のToDoグループ -->
				<input id="tdInput4_1" type="text" name="td4_1" placeholder="todo"><br>
				<input id="tdInput4_2" type="text" name="td4_2" placeholder="todo"><br>
				<input id="tdInput4_3" type="text" name="td4_3" placeholder="todo"><br>
				<input id="tdInput4_4" type="text" name="td4_4" placeholder="todo"><br>
				<input id="tdInput4_5" type="text" name="td4_5" placeholder="todo"><br>
				<!-- 短期目標５ -->
				<label>短期目標５</label> <input id="sgInput5" type="text" name="sg5"><input
					type="date" id="sgStart" name="day_s_5" placeholder="開始"> <input
					type="date" id="sgEnd" name="day_e_5" placeholder="終了"><br>
				<!-- 短期目標５のToDoグループ -->
				<input id="tdInput5_1" type="text" name="td5_1" placeholder="todo"><br>
				<input id="tdInput5_2" type="text" name="td5_2" placeholder="todo"><br>
				<input id="tdInput5_3" type="text" name="td5_3" placeholder="todo"><br>
				<input id="tdInput5_4" type="text" name="td5_4" placeholder="todo"><br>
				<input id="tdInput5_5" type="text" name="td5_5" placeholder="todo"><br>

				<input type="submit" value="登録">
			</form>
		</main>
		<!-- フッター -->
		<footer class="footer"> </footer>
	</div>
</body>