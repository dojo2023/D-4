<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
                    <li id = add>追加</li>
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
<a href = '/example/LastMonthServlet' class = "prev"></a>
</div>
<div class = monthcontent><h3><c:out value= "${displayYear}"/>年<c:out value= "${displayMonth}"/>月</h3></div>
<div class = "monthcontent">
<a href = '/example/NextMonthServlet' class = "next"></a>
</div>
</div>

<!-- 達成度を表示するためにはEL式じゃなくてjavaを直接埋め込む -->
<form method="POST" action="/amateur/AchieveServlet" id = "formAchieve" >
<p id = "lg_a">長期目標：<c:out value= "${lg}"/>
<!-- 長期目標達成ゲージを追加するためのdiv -->
<div id = "lg_gage"></div></p>

<%int i = 0;%>
<c:forEach  var = "s"  items="${sgList}" >
<p id = "sg_a">短期目標：<c:out value= "${s.sg}"/>
<!-- 短期目標達成ゲージを追加するためのdiv -->
<div id = "sg_gage"></div></p>
<c:forEach  var = "t"  items="${todoList}" >
<!-- for文を使ってformのnameの部分変えないとやばそう -->
<p id = "todo_a">Todo：<c:out value= "${t.todo}"/><input type="text" name="ACHIEVE<%out.print(i);%>" value = "${t.achieve}"></p>
<%i++;%>
</c:forEach>
</c:forEach>
<input type="submit" name="REGIST_A" value="確定">
</form>
<!-- メインここまで -->
</div>
<!--JavaScriptの記入欄-->
<!--  <script src = "achieve.js"></script>-->
</body>
</html>