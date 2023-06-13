<!-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> -->

<!DOCTYPE html>
<html lang = "ja">
<head>
<meta charset="UTF-8">
<title>達成度入力・表示</title>
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
                    <li id = "add">追加</li>
                    <li><a href="/amateur/AchieveServlet">達成度</a></li>
                    <li><a href="/amateur/ExplanationServlet">アプリの使い方</a></li>
                    <li id = "logout"><a href="/amateur/LogoutServlet">ログアウト</a></li>
                </ul>
            </nav>
</header>
<!-- ヘッダーここまで -->
<!-- メインここから -->
<p><button id = "month_l" type = "button" onclick="location.href='/amateur/AchieveServlet'">先月</button>
6月
<button id = "month_n" type = "button" onclick="location.href='/amateur/AchieveServlet'">翌月</button></p>
    <form method="POST" action="/amateur/AchieveServlet" id = "formAchieve" >
    <p id = "lg_a">長期目標：${e.}
    <!-- 長期目標達成ゲージを追加するためのdiv -->
    <div id = "lg_gage"></div></p>
    <!--<c:forEach var="e" items="${月の目標が入った配列名}" >-->
    <p id = "sg_a">短期目標：${e.}
    <!-- 短期目標達成ゲージを追加するためのdiv -->
    <div id = "sg_gage"></div></p>
    <p id = "todo_a">Todo：${e.}<input type="text" name="ACHIEVE" value = "${e.}">％</p>
    <!--</c:forEach>-->
    <input type="submit" name="REGIST_A" value="確定">
    </form>
<!-- メインここまで -->
<!-- フッターここから -->
<!-- フッターここまで -->
</div>
<!--JavaScriptの記入欄-->
<script src = "achieve.js"></script>
</body>
</html>