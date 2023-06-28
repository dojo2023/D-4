<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="model.AllA"%>
<%@ page import="model.Task"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<%
  AllA a = (AllA)request.getAttribute("a");
  int[] sgId = (int[])request.getAttribute("sgId");
  LocalDate currentDate = LocalDate.now();
%>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" type="image/png" href="/amateur/img/fabicon.png">
<link rel ="stylesheet" href="/amateur/css/schedule.css">
<link rel="stylesheet" href="/amateur/css/common.css">
<title>1日のスケジュール</title>
</head>

<body>
<div class = "wrapper">
<!-- ポップアップに載せる文言 -->
<div id="popup" class="popup">
<span class = "popupHeader">
<span id="close-btn">×</span>
</span>
<div class="popupContent">
<!-- ここにユーザー名を表示させたい -->
	<p id = "userName">${number.name}さん</p>
	<p id = "loginDays">ログイン日数${number.days}日</p>
    <p id="random-word"></p>
</div>
</div>
<!-- ヘッダー -->
<!-- <img src = ""> -->
 <header class = "header">
<img src="/amateur/img/logo.png" alt="Image" class="image"id="moving-image">

        <nav class="nav">
                        <ul>
                            <li><a href="/amateur/ScheduleServlet">1日のスケジュール</a></li>
                            <li><a href="/amateur/CalendarServlet">カレンダー</a></li>
                                <li class="dropdown">
                                <a href="#">追加▽</a>
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
    <!-- 月を表示するためのボタン設定 -->
<div class = "monthMove">
<div class = "monthcontent">
<a href = '/amateur/ScheduleLastDayServlet' class = "prev"></a>
</div>
<div class = monthcontent><h3>
	<span id = "year"><c:out value= "${displayYear}"/></span>年
	<span id = "month"><c:out value= "${displayMonth}"/></span>月
	<span id = "day"><c:out value= "${displayday}"/></span>日
</h3></div>
<div class = "monthcontent">
<a href = '/amateur/ScheduleNextDayServlet' class = "next"></a>
</div>
</div>

<div class = "position">
<div class = "goals">
<div class="lg">
<p class = "lg_goalContent">長期目標：<span  class = "gc">
<%if (a.getLg() == null){
	out.print("");
}else{
	out.print(a.getLg());
}%>
</span>
</p>
<p>達成度<span  class = "achieve">
<%if (a.getLgA() != 1000){
	out.print(a.getLgA());
}else{
	out.print("0");
}%>
</span>％</p>
</div>

<div class="sg">
<p class = "goalContent">短期目標</p>
<%for(int i = 0; i < sgId.length; i++){
	if(sgId[i] > 0){
		out.println("<p class = \"gc\">" + a.getSgA().get(i).getSg() + "</p>" +
		"<p>達成度<span  class = \"achieve\">" + a.getSgA().get(i).getsAchieve() + "</span>％</p>");
	}
} %>
</div>

<div class="todo">
<p class = "todoContent">Todoリスト</p>
<%for(int i = 0; i < sgId.length; i++){
	if(sgId[i] > 0){
		for(int j=0;j<a.getSgA().get(i).getTodoA().size();j++){
				out.println("<p class = \"gc\">" + a.getSgA().get(i).getTodoA().get(j).getTodo()+ "</p>" +
				"<p>達成度<span  class = \"achieve\">" + a.getSgA().get(i).getTodoA().get(j).gettAchieve()  + "</span>％</p>");
		}
	}
} %>
</div>

<form method="POST" action="/amateur/ScheduleServlet" id = "formMemo" >
<p class = "memo">メモ</p>
<div class="form-container">
  <textarea id="input-text" name = "MEMO">${memo}</textarea>
  <input type="submit" name="REGIST_M" value="登録" class ="button">
</div>
</form>
</div>

<!-- タスク表示用の時刻表 -->
<div class="timeSchedule">
<h3 class = "scheTitle">本日の予定</h3>
<div class="schedule">
<table>
	    <thead class = "thTitle">
	      <tr>
	        <th>時間</th>
	        <th>予定</th>
	      </tr>
	    </thead>

	    <tbody>
	      <!-- ここに時間ごとの行を追加します -->
	    </tbody>
</table>
</div>
</div>
</div>

<!-- タスクの中身を非表示で表示 -->
<div class = "taskContent">
<% List<Task> t = (List<Task>)request.getAttribute("task");
	for(int i = 0; i < t.size(); i++){
			out.println("<div class = \"task\">" + t.get(i).getTask() + "</div>");
			out.println("<div class = \"start\">" + t.get(i).getHour_s() + "</div>");
			out.println("<div class = \"end\">"+ t.get(i).getHour_e() + "</div>");
		}
%>
</div>

	<footer class="footer">
        &copy;Copyright plusDOJO(SE plus) amateur programmer. All rights reserved.
    </footer>

    <script src = "/amateur/js/schedule.js"></script>


</div>
</body>

</html>
