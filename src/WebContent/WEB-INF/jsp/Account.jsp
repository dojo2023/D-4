<!-- 2023-06-23 h13:30 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang = "ja">
<head>
<meta charset="UTF-8">
<title>ログイン</title>
<link rel="stylesheet" href="/amateur/css/common.css">
<link rel="stylesheet" href="/amateur/css/account.css">
</head>
<body>
<div class = wrapper>
<!-- ヘッダーここから -->
<header class = header>
<!-- <img src = ""> -->
<h1>アプリ名</h1>
</header>
<!-- ヘッダーここまで -->
<!-- メインここから -->
<!-- <img src = ""> ロゴ画像-->
<form method="POST" action="/amateur/AccountServlet" id = "formAccount">
	<p><c:out value="${result.message}" /></p>
    <table>
        <tr>
            <td>
            <label>ユーザー名<br>
            <input type="text" name="NAME">
            </label>
            </td>
        </tr>
        <tr>
            <td>
            <label>パスワード<br>
            <input type="password" name="PW1" id="password">
            </label>
            </td>
        </tr>
        <tr>
            <td>
            <label>パスワード確認用<br>
            <input type="password" name="PW2" id="password_con">
            </label>
            </td>
        </tr>
        <tr>
            <td colspan="2">
            <input type="submit" name="LOGIN" value="新規登録">
            <input type="reset" name="reset" value="リセット">
            </td>
        </tr>
    </table>
</form>
<!-- メインここまで -->
<!-- フッターここから -->

<footer>
    <p>&copy;Copyright plusDOJO(SE plus) amateur programmer. All rights reserved.</p>
</footer>
<!-- フッターここまで -->
</div>
</body>
</html>