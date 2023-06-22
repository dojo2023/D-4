<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.AllA"%>

<!DOCTYPE html>
<html lang = "ja">
<head>
<meta charset="UTF-8">
<title>達成度入力・表示</title>
<link rel="stylesheet" href="/simpleBC/css/common.css">
<link rel="stylesheet" href="/simpleBC/css/achieve.css">
</head>
<body>
<div class = wrapper>
<!-- ヘッダーここから -->
<header class = header>
<!-- <img src = ""> -->
<h1>アプリ名</h1>
<nav class="nav">
                <ul>
                    <li><a href="/amateur/ScheduleServlet">1日のスケジュール</a></li>
                    <li><a href="/amateur/CalendarServlet">カレンダー</a></li>
                    <li class="dropdown">
                    <a href="#">追加</a><!-- #で遷移なしの表示する？ -->
                                    <div class="dropdown-content">
                                     <a href="/amateur/GoalRegistServlet">目標追加画面</a>
                                        <a href="/amateur/TaskRegistServlet">タスク追加画面</a>
                                    </div>
                                </li>
                    <li><a href="/amateur/AchieveServlet">達成度</a></li>
                    <li><a href="/amateur/ExplanationServlet">アプリの使い方</a></li>
                </ul>
            </nav>
</header>
<!-- ヘッダーここまで -->

<!-- メインここから -->
<!-- 月を表示するためのボタン設定 -->
<div class = "monthMove">
<div class = "monthcontent">
<a href = '/amateur/AchieveLastMonthServlet' class = "prev"></a>
</div>
<div class = monthcontent><h3><c:out value= "${displayYear}"/>年<c:out value= "${displayMonth}"/>月</h3></div>
<div class = "monthcontent">
<a href = '/amateur/AchieveNextMonthServlet' class = "next"></a>
</div>
</div>

<%
//まずリクエストスコープとセッションスコープからユーザーidと日付を取ってくる
AllA a = (AllA)request.getAttribute("a");
 %>

<form method="POST" action="/simpleBC/AchieveServlet" id = "formAchieve" >
<p id = "lg_a">長期目標：<%=a.getLg()%>　達成度：<%=a.getLgA()%>％
<!-- 長期目標達成ゲージを追加するためのdiv -->
<div id = "lg_gage"></div></p>

<%for (int i=0;i<(a.getSgA()).size();i++){
	out.println("<p>短期目標"+(i+1)+"：" + (a.getSgA()).get(i).getSg() +
	"達成度：" + (a.getSgA()).get(i).getsAchieve()+ "％<div id = sg_gage></div></p>");
	for(int j=0;j<a.getSgA().get(i).getTodoA().size();j++) {
		out.println("<p>todo"+(j+1)+":" + a.getSgA().get(i).getTodoA().get(j).getTodo()
			 + "<input type=text name = 'ACHIEVE" + i + "-" + j + "'  value = '" + a.getSgA().get(i).getTodoA().get(j).gettAchieve() +
			 "'>％<input type=hidden name = 'TODOID" + i + "-" + j + "'  value = '" + a.getSgA().get(i).getTodoA().get(j).getTodoId() + "'></p>");
		}
} %>

<input type="submit" name="REGIST_A" value="確定">
</form>
<!-- メインここまで -->
</div>
<!--JavaScriptの記入欄-->
<!--  <script src = "achieve.js"></script>-->
</body>
</html>