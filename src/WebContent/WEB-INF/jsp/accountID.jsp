<!-- 2023-06-23 h13:30 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>ユーザー情報</title>
<link rel="icon" type="image/png" href="/amateur/img/fabicon.png">
<link rel ="stylesheet" href="/amateur/css/accountID.css">
<link rel="stylesheet" href="/amateur/css/common.css">
</head>

<body>
<div class = wrapper>
<img src="/amateur/img/logo.png" alt="Image" class="image"id="moving-image">
<div id="popup" class="popup">
<div class="popuptext">
    <h2>ご注意ください!!</h2>
    <p>IDはログイン時に必要になるデータになるので慎重に保管してください</p>
</div>
<button class="close-btn">閉じる</button>
</div>
<div class="account">
<h1>ユーザー情報</h1>

<h2>ユーザー名：<c:out value="${number.name}" /></h2>
<h2>ID:<c:out value="${number.number}" /></h2>
<br><br>
<p>IDはログイン時に必要になるので大切に保管してください</p>
<br>
<br><br>
<a href="/amateur/ScheduleServlet">1日のスケジュール</a>
<br><br><br><br><br>
<footer class="footer">
        &copy;Copyright plusDOJO(SE plus) amateur programmer. All rights reserved.
    </footer>
</div>

<script src = "/amateur/js/accountID.js"></script>
</div>
</body>
</html>