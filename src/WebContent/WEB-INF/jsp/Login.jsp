<!-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> -->

<!DOCTYPE html>
<html lang = "ja">
<head>
<meta charset="UTF-8">
<title>ログイン</title>
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
<!-- <img src = ""> ロゴ画像-->
<form method="POST" action="/amateur/LoginServlet" id = "formLogin">
    <table>
        <tr>
            <td>
            <label>ID<br>
            <input type="tel" name="NUMBER">
            </label>
            </td>
        </tr>
        <tr>
            <td>
            <label>パスワード<br>
            <input type="password" name="PW" id="password">
            </label>
            </td>
        </tr>
        <tr>
            <td colspan="2">
            <input type="submit" name="LOGIN" value="ログイン">
            <input type="reset" name="reset" value="リセット">
            </td>
        </tr>
    </table>
</form>
<!-- メインここまで -->
<!-- フッターここから -->
<!-- フッターここまで -->
</div>
<!--JavaScriptの記入欄-->
<script src = "login.js"></script>
</body>
</html>