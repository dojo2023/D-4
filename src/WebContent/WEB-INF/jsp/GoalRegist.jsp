<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.AllA"%>
<%@ page import="dao.TodotbDAO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>目標追加</title>
<link rel="icon" type="image/png" href="/amateur/img/fabicon.png">
<link rel="stylesheet" href="/amateur/css/common.css">
<link rel="stylesheet" href="/amateur/css/goal_regist.css">
</head>

<body>
	<div class="wrapper">
		<!-- ヘッダー -->
		<header class="header">
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
		<!-- メイン -->
		<main class="main">
			<form id="dataForm" action="/amateur/GoalRegistServlet" method="POST">
				<!-- 現在の年月を表示 -->
				<div class="monthMove">
					<div class="monthcontent">
						<a href='/amateur/GoalLastMonthServlet' class="prev"></a>
					</div>
					<div class=monthcontent>
						<h3>
							<c:out  value="${displayYear}" />
							年
							<input type="hidden" name="year" value="${displayYear}">
							<c:out  value="${displayMonth}" />
							月
							<input type="hidden" name="month" value="${displayMonth}">
						</h3>
					</div>
					<div class="monthcontent">
						<a href='/amateur/GoalNextMonthServlet' class="next"></a>
					</div>
				</div>


<%
//まずリクエストスコープとセッションスコープからユーザーidと日付を取ってくる
AllA a = (AllA)request.getAttribute("a");
 %>
<div class = "goalcontent">
				<!-- 長期目標 -->
				<div class="long">
				<label>長期目標</label><%out.println ("<input id= lgInput type= text name= lg value='"+a.getLg()+"'>");%><br>
				</div>

				<div class="short">
				<!-- 短期目標１ -->
					<div class="first">

				<label>短期目標１</label><br><input id='sgInput1' class = 'sg' type='text' name='sg1' value='<%if(a.getSgA().size()>0){out.print(a.getSgA().get(0).getSg());}%>'><br>
				<input type='date' id='sgStart' name='day_s_1' placeholder='開始'min= '${displayDate}' value='<%if(a.getSgA().size()>0){out.print(a.getSgA().get(0).getDay_s());}%>'>
				<input type='date' id='sgEnd' name='day_e_1' placeholder='終了'value='<%if(a.getSgA().size()>0){out.print(a.getSgA().get(0).getDay_e());}%>'><br>

				<input type="hidden" name="sgId1" value='<%if(a.getSgA().get(0).getSgId()!=0){out.print(a.getSgA().get(0).getSgId());}%>'>

				<!-- 短期目標１のToDoグループ -->
				<input id='tdInput1_1' class = 'todo' type='text' name='td1_1' placeholder='todo' value='<%if(a.getSgA().get(0).getTodoA().size()>0){out.print( a.getSgA().get(0).getTodoA().get(0).getTodo());}%>'><br>
				<input type="hidden" name="tdId1_1" value='<%if(a.getSgA().get(0).getSgId()!=0&&a.getSgA().get(0).getTodoA().get(0).getTodoId()!=0){out.print(a.getSgA().get(0).getTodoA().get(0).getTodoId());} %>'>

				<input id='tdInput1_2' class = 'todo' type='text' name='td1_2' placeholder='todo' value='<%if(a.getSgA().get(0).getTodoA().size()>1){out.print( a.getSgA().get(0).getTodoA().get(1).getTodo());}%>'><br>
				<input type="hidden" name="tdId1_2" value='<%if(a.getSgA().size()>0&&a.getSgA().get(0).getTodoA().size()>1){out.print(a.getSgA().get(0).getTodoA().get(1).getTodoId());} %>'>

				<input id='tdInput1_3' class = 'todo' type='text' name='td1_3' placeholder='todo' value='<%if(a.getSgA().get(0).getTodoA().size()>2){out.print( a.getSgA().get(0).getTodoA().get(2).getTodo());}%>'><br>
				<input type="hidden" name="tdId1_3" value='<%if(a.getSgA().size()>0&&a.getSgA().get(0).getTodoA().size()>2){out.print(a.getSgA().get(0).getTodoA().get(2).getTodoId());} %>'>

				<input id='tdInput1_4' class = 'todo' type='text' name='td1_4' placeholder='todo' value='<%if(a.getSgA().get(0).getTodoA().size()>3){out.print( a.getSgA().get(0).getTodoA().get(3).getTodo());}%>'><br>
				<input type="hidden" name="tdId1_4" value='<%if(a.getSgA().size()>0&&a.getSgA().get(0).getTodoA().size()>3){out.print(a.getSgA().get(0).getTodoA().get(3).getTodoId());} %>'>

				<input id='tdInput1_5' class = 'todo' type='text' name='td1_5' placeholder='todo' value='<%if(a.getSgA().get(0).getTodoA().size()>4){out.print( a.getSgA().get(0).getTodoA().get(4).getTodo());}%>'><br>
				<input type="hidden" name="tdId1_5" value='<%if(a.getSgA().size()>0&&a.getSgA().get(0).getTodoA().size()>4){out.print(a.getSgA().get(0).getTodoA().get(4).getTodoId());} %>'>
</div>

				<!-- 短期目標２ -->
				<div class="second">
				<label>短期目標２</label><br><input id='sgInput2' class = 'sg' type='text' name='sg2' value='<%if(a.getSgA().size()>1){out.print(a.getSgA().get(1).getSg());}%>'><br>
				<input type='date' id='sgStart' name='day_s_2' placeholder='開始'value='<%if(a.getSgA().size()>1){out.print(a.getSgA().get(1).getDay_s());}%>'>
				<input type='date' id='sgEnd' name='day_e_2' placeholder='終了'value='<%if(a.getSgA().size()>1){out.print(a.getSgA().get(1).getDay_e());}%>'><br>

				<input type="hidden" name="sgId2" value='<%if(a.getSgA().size()>1){out.print(a.getSgA().get(1).getSgId());}%>'>

				<!-- 短期目標２のToDoグループ -->
				<input id='tdInput2_1' class = 'todo' type='text' name='td2_1' placeholder='todo' value='<%if(a.getSgA().size()>1&&a.getSgA().get(1).getTodoA().size()>0){out.print( a.getSgA().get(1).getTodoA().get(0).getTodo());}%>'><br>
				<input type="hidden" name="tdId2_1" value='<%if(a.getSgA().size()>1&&a.getSgA().get(1).getTodoA().size()>0){out.print(a.getSgA().get(1).getTodoA().get(0).getTodoId());} %>'>

				<input id='tdInput2_2' class = 'todo' type='text' name='td2_2' placeholder='todo' value='<%if(a.getSgA().size()>1&&a.getSgA().get(1).getTodoA().size()>1){out.print( a.getSgA().get(1).getTodoA().get(1).getTodo());}%>'><br>
				<input type="hidden" name="tdId2_2" value='<%if(a.getSgA().size()>1&&a.getSgA().get(1).getTodoA().size()>1){out.print(a.getSgA().get(1).getTodoA().get(1).getTodoId());} %>'>

				<input id='tdInput2_3' class = 'todo' type='text' name='td2_3' placeholder='todo' value='<%if(a.getSgA().size()>1&&a.getSgA().get(1).getTodoA().size()>2){out.print( a.getSgA().get(1).getTodoA().get(2).getTodo());}%>'><br>
				<input type="hidden" name="tdId2_3" value='<%if(a.getSgA().size()>1&&a.getSgA().get(1).getTodoA().size()>2){out.print(a.getSgA().get(1).getTodoA().get(2).getTodoId());} %>'>

				<input id='tdInput2_4' class = 'todo' type='text' name='td2_4' placeholder='todo' value='<%if(a.getSgA().size()>1&&a.getSgA().get(1).getTodoA().size()>3){out.print( a.getSgA().get(1).getTodoA().get(3).getTodo());}%>'><br>
				<input type="hidden" name="tdId2_4" value='<%if(a.getSgA().size()>1&&a.getSgA().get(1).getTodoA().size()>3){out.print(a.getSgA().get(1).getTodoA().get(3).getTodoId());} %>'>

				<input id='tdInput2_5' class = 'todo' type='text' name='td2_5' placeholder='todo' value='<%if(a.getSgA().size()>1&&a.getSgA().get(1).getTodoA().size()>4){out.print( a.getSgA().get(1).getTodoA().get(4).getTodo());}%>'><br>
				<input type="hidden" name="tdId2_5" value='<%if(a.getSgA().size()>1&&a.getSgA().get(1).getTodoA().size()>4){out.print(a.getSgA().get(1).getTodoA().get(4).getTodoId());} %>'>
</div>
				<!-- 短期目標３ -->
				<div class="third">
				<label>短期目標３</label><br><input id='sgInput3' class = 'sg' type='text' name='sg3' value='<%if(a.getSgA().size()>2){out.print(a.getSgA().get(2).getSg());}%>'><br>
				<input type='date' id='sgStart' name='day_s_3' placeholder='開始'value='<%if(a.getSgA().size()>2){out.print(a.getSgA().get(2).getDay_s());}%>'>
				<input type='date' id='sgEnd' name='day_e_3' placeholder='終了'value='<%if(a.getSgA().size()>2){out.print(a.getSgA().get(2).getDay_e());}%>'><br>

				<input type="hidden" name="sgId3" value='<%if(a.getSgA().size()>2){out.print(a.getSgA().get(2).getSgId());}%>'>

				<!-- 短期目標３のToDoグループ -->
				<input id='tdInput3_1' class = 'todo' type='text' name='td3_1' placeholder='todo' value='<%if(a.getSgA().size()>2&&a.getSgA().get(2).getTodoA().size()>0){out.print( a.getSgA().get(2).getTodoA().get(0).getTodo());}%>'><br>
				<input type="hidden" name="tdId3_1" value='<%if(a.getSgA().size()>2&&a.getSgA().get(2).getTodoA().size()>0){out.print(a.getSgA().get(2).getTodoA().get(0).getTodoId());} %>'>

				<input id='tdInput3_2' class = 'todo' type='text' name='td3_2' placeholder='todo' value='<%if(a.getSgA().size()>2&&a.getSgA().get(2).getTodoA().size()>1){out.print( a.getSgA().get(2).getTodoA().get(1).getTodo());}%>'><br>
				<input type="hidden" name="tdId3_2" value='<%if(a.getSgA().size()>2&&a.getSgA().get(2).getTodoA().size()>1){out.print(a.getSgA().get(2).getTodoA().get(1).getTodoId());} %>'>

				<input id='tdInput3_3' class = 'todo' type='text' name='td3_3' placeholder='todo' value='<%if(a.getSgA().size()>2&&a.getSgA().get(2).getTodoA().size()>2){out.print( a.getSgA().get(2).getTodoA().get(2).getTodo());}%>'><br>
				<input type="hidden" name="tdId3_3" value='<%if(a.getSgA().size()>2&&a.getSgA().get(2).getTodoA().size()>2){out.print(a.getSgA().get(2).getTodoA().get(2).getTodoId());} %>'>

				<input id='tdInput3_4' class = 'todo' type='text' name='td3_4' placeholder='todo' value='<%if(a.getSgA().size()>2&&a.getSgA().get(2).getTodoA().size()>3){out.print( a.getSgA().get(2).getTodoA().get(3).getTodo());}%>'><br>
				<input type="hidden" name="tdId3_4" value='<%if(a.getSgA().size()>2&&a.getSgA().get(2).getTodoA().size()>3){out.print(a.getSgA().get(2).getTodoA().get(3).getTodoId());} %>'>

				<input id='tdInput3_5' class = 'todo' type='text' name='td3_5' placeholder='todo' value='<%if(a.getSgA().size()>2&&a.getSgA().get(2).getTodoA().size()>4){out.print( a.getSgA().get(2).getTodoA().get(4).getTodo());}%>'><br>
				<input type="hidden" name="tdId3_5" value='<%if(a.getSgA().size()>2&&a.getSgA().get(2).getTodoA().size()>4){out.print(a.getSgA().get(2).getTodoA().get(4).getTodoId());} %>'>
</div>
				<!-- 短期目標４ -->
				<div class="fourth">
				<label>短期目標４</label><br><input id='sgInput4' class = 'sg' type='text' name='sg4' value='<%if(a.getSgA().size()>3){out.print(a.getSgA().get(3).getSg());}%>'><br>
				<input type='date' id='sgStart' name='day_s_4' placeholder='開始'value='<%if(a.getSgA().size()>3){out.print(a.getSgA().get(3).getDay_s());}%>'>
				<input type='date' id='sgEnd' name='day_e_4' placeholder='終了'value='<%if(a.getSgA().size()>3){out.print(a.getSgA().get(3).getDay_e());}%>'><br>

				<input type="hidden" name="sgId4" value='<%if(a.getSgA().size()>3){out.print(a.getSgA().get(3).getSgId());}%>'>

				<!-- 短期目標４のToDoグループ -->
				<input id='tdInput4_1' class = 'todo' type='text' name='td4_1' placeholder='todo' value='<%if(a.getSgA().size()>3&&a.getSgA().get(3).getTodoA().size()>0){out.print( a.getSgA().get(3).getTodoA().get(0).getTodo());}%>'><br>
				<input type="hidden" name="tdId4_1" value='<%if(a.getSgA().size()>3&&a.getSgA().get(3).getTodoA().size()>0){out.print(a.getSgA().get(3).getTodoA().get(0).getTodoId());} %>'>

				<input id='tdInput4_2' class = 'todo' type='text' name='td4_2' placeholder='todo' value='<%if(a.getSgA().size()>3&&a.getSgA().get(3).getTodoA().size()>1){out.print( a.getSgA().get(3).getTodoA().get(1).getTodo());}%>'><br>
				<input type="hidden" name="tdId4_2" value='<%if(a.getSgA().size()>3&&a.getSgA().get(3).getTodoA().size()>1){out.print(a.getSgA().get(3).getTodoA().get(1).getTodoId());} %>'>

				<input id='tdInput4_3' class = 'todo' type='text' name='td4_3' placeholder='todo' value='<%if(a.getSgA().size()>3&&a.getSgA().get(3).getTodoA().size()>2){out.print( a.getSgA().get(3).getTodoA().get(2).getTodo());}%>'><br>
				<input type="hidden" name="tdId4_3" value='<%if(a.getSgA().size()>3&&a.getSgA().get(3).getTodoA().size()>2){out.print(a.getSgA().get(3).getTodoA().get(2).getTodoId());} %>'>

				<input id='tdInput4_4' class = 'todo' type='text' name='td4_4' placeholder='todo' value='<%if(a.getSgA().size()>3&&a.getSgA().get(3).getTodoA().size()>3){out.print( a.getSgA().get(3).getTodoA().get(3).getTodo());}%>'><br>
				<input type="hidden" name="tdId4_4" value='<%if(a.getSgA().size()>3&&a.getSgA().get(3).getTodoA().size()>3){out.print(a.getSgA().get(3).getTodoA().get(3).getTodoId());} %>'>

				<input id='tdInput4_5' class = 'todo' type='text' name='td4_5' placeholder='todo' value='<%if(a.getSgA().size()>3&&a.getSgA().get(3).getTodoA().size()>4){out.print( a.getSgA().get(3).getTodoA().get(4).getTodo());}%>'><br>
				<input type="hidden" name="tdId4_5" value='<%if(a.getSgA().size()>3&&a.getSgA().get(3).getTodoA().size()>4){out.print(a.getSgA().get(3).getTodoA().get(4).getTodoId());} %>'>
</div>
				<!-- 短期目標５ -->
				<div class="fifth">
				<label>短期目標５</label><br><input id='sgInput5' class = 'sg' type='text' name='sg5' value='<%if(a.getSgA().size()>4){out.print(a.getSgA().get(4).getSg());}%>'><br>
				<input type='date' id='sgStart' name='day_s_5' placeholder='開始'value='<%if(a.getSgA().size()>4){out.print(a.getSgA().get(4).getDay_s());}%>'>
				<input type='date' id='sgEnd' name='day_e_5' placeholder='終了'value='<%if(a.getSgA().size()>4){out.print(a.getSgA().get(4).getDay_e());}%>'><br>

				<input type="hidden" name="sgId5" value='<%if(a.getSgA().size()>4){out.print(a.getSgA().get(4).getSgId());}%>'>

				<!-- 短期目標５のToDoグループ -->
				<input id='tdInput5_1' class = 'todo' type='text' name='td5_1' placeholder='todo' value='<%if(a.getSgA().size()>4&&a.getSgA().get(4).getTodoA().size()>0){out.print( a.getSgA().get(4).getTodoA().get(0).getTodo());}%>'><br>
				<input type="hidden" name="tdId5_" value='<%if(a.getSgA().size()>4&&a.getSgA().get(4).getTodoA().size()>0){out.print(a.getSgA().get(4).getTodoA().get(0).getTodoId());} %>'>

				<input id='tdInput5_2' class = 'todo' type='text' name='td5_2' placeholder='todo' value='<%if(a.getSgA().size()>4&&a.getSgA().get(4).getTodoA().size()>1){out.print( a.getSgA().get(4).getTodoA().get(1).getTodo());}%>'><br>
				<input type="hidden" name="tdId5_" value='<%if(a.getSgA().size()>4&&a.getSgA().get(4).getTodoA().size()>1){out.print(a.getSgA().get(4).getTodoA().get(1).getTodoId());} %>'>

				<input id='tdInput5_3' class = 'todo' type='text' name='td5_3' placeholder='todo' value='<%if(a.getSgA().size()>4&&a.getSgA().get(4).getTodoA().size()>2){out.print( a.getSgA().get(4).getTodoA().get(2).getTodo());}%>'><br>
				<input type="hidden" name="tdId5_" value='<%if(a.getSgA().size()>4&&a.getSgA().get(4).getTodoA().size()>2){out.print(a.getSgA().get(4).getTodoA().get(2).getTodoId());} %>'>

				<input id='tdInput5_4' class = 'todo' type='text' name='td5_4' placeholder='todo' value='<%if(a.getSgA().size()>4&&a.getSgA().get(4).getTodoA().size()>3){out.print( a.getSgA().get(4).getTodoA().get(3).getTodo());}%>'><br>
				<input type="hidden" name="tdId5_" value='<%if(a.getSgA().size()>4&&a.getSgA().get(4).getTodoA().size()>3){out.print(a.getSgA().get(4).getTodoA().get(3).getTodoId());} %>'>

				<input id='tdInput5_5' class = 'todo' type='text' name='td5_5' placeholder='todo' value='<%if(a.getSgA().size()>4&&a.getSgA().get(4).getTodoA().size()>4){out.print( a.getSgA().get(4).getTodoA().get(4).getTodo());}%>'><br>
				<input type="hidden" name="tdId5_" value='<%if(a.getSgA().size()>4&&a.getSgA().get(4).getTodoA().size()>4){out.print(a.getSgA().get(4).getTodoA().get(4).getTodoId());} %>'>
</div>
</div>
</div>
				<input type="submit" value="登録" id = "regist">
			</form>
		</main>
		<!-- フッター -->
		<footer class="footer">
		 &copy;Copyright plusDOJO(SE plus) amateur programmer. All rights reserved.
		</footer>
	</div>
</body>
</html>