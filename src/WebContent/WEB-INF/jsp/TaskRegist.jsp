<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar" %>
<%@ page import="model.Task"%>
<%@page import="java.util.List" %>
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
		    <!-- 月を表示するためのボタン設定 -->
<div class = "monthMove">
<div class = "monthcontent">
<a href = '/amatuer/TaskLastDayServlet' class = "prev"></a>
</div>
<div class = monthcontent><h3>
	<span id = "year"><c:out value= "${displayYear}"/></span>年
	<span id = "month"><c:out value= "${displayMonth}"/></span>月
	<span id = "day"><c:out value= "${displayday}"/></span>日
</h3></div>
<div class = "monthcontent">
<a href = '/amatuer/TaskNextDayServlet' class = "next"></a>
</div>
</div>
			<h1>タスク</h1>
			<!-- form -->
			<%
//まずリクエストスコープとセッションスコープからtaskを取ってくる
List<Task> a = (List<Task>)request.getAttribute("task");
 %>
			<form id="dataForm" action="TaskRegistServlet" method="POST">
				<%for(int i=0;i<a.size();i++){
				out.print("<input type=\"text\" name=\"task_"+(i+1)+"\" value=\""+a.get(i).getTask()+"\">");
				out.print("<input type=\"datetime-local\" step=\"1800\" name=\"times_"+(i+1)+"\" value=\""+a.get(i).getHour_s()+"\">");
				out.print("<input type=\"datetime-local\" step=\"1800\" name=\"timee_"+(i+1)+"\" value=\""+a.get(i).getHour_e()+"\"><br>");
				}
				%>
					<input type="text" class="taskBox" name="task0">
					<input type="datetime-local"class="timesBox" name="times0"step="1800">
					<input type="datetime-local"class="timeeBox" name="timee0"step="1800"><br>
				<!-- ディスプレイ上の一個目 -->
				<div id="container1" style="display: none;">
					<input type="text" class="taskBox" name="task1">
					<input type="datetime-local"class="timesBox" name="times1" step="1800">
					<input type="datetime-local"class="timeeBox" name="timee1" step="1800"><br>
				</div>
				<div id="container2" style="display: none;">
					<input type="text" class="taskBox" name="task2">
					<input type="datetime-local"class="timesBox" name="times2"step="1800">
					<input type="datetime-local"class="timeeBox" name="timee2"step="1800"><br>
				</div>
				<div id="container3" style="display: none;">
					<input type="text" class="taskBox" name="task3">
					<input type="datetime-local"class="timesBox" name="times3"step="1800">
					<input type="datetime-local"class="timeeBox" name="timee3"step="1800"><br>
				</div>
				<div id="container4" style="display: none;">
					<input type="text" class="taskBox" name="task4">
					<input type="datetime-local"class="timesBox" name="times4"step="1800">
					<input type="datetime-local"class="timeeBox" name="timee4"step="1800"><br>
				</div>
				<!-- taskを追加するためのボタン -->
				<button type="button" onclick="addTaskBox()">新規</button>
				<div id="del" style="display: none;">
				<button type="button" onclick="delTaskBox()">-</button>
				</div>
				<input id="taskcount" type="hidden" value="" name="length">
				<!-- 登録ボタン -->
                <div id="register">
				<input type="submit" value="登録">
                </div>
			</form>

		</main>
	</div>
<script>
		var i=0;
		function addTaskBox() {
			 if(i<4){
				 i++;
				 var elementPage1 = document.getElementById( "container"+i );
				 elementPage1.style.display = 'block';
			 }
			 if(i>0){
				 var elementPage2 = document.getElementById( "del" );
				 elementPage2.style.display = 'block';
			 }
		}
		function delTaskBox(){
			 if(i>0){
				 var elementPage3 = document.getElementById( "container"+i );
				 elementPage3.style.display = 'none';
					i--;
				}
			 if(i<1){
				 var elementPage2 = document.getElementById( "del" );
				 elementPage2.style.display = 'none';
			 }
		}
	</script>
</body>

</html>