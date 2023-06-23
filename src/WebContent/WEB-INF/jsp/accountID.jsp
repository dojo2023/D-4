<!-- 2023-06-23 h13:30 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<style>
    .popup {
      border: 3px solid black;
      position: fixed;
      top: 50%;
      left: 50%;
      transform: translate(-50%, -50%);
      background-color: yellow;
      color: black;
      width: 300px;
      padding: 20px;
      text-align: center;
      border-radius: 6px;
      visibility: hidden;
      opacity: 1;
      transition: visibility 0s, opacity 0.3s;
    }

    .popup.show {
      visibility: visible;
      opacity: 1;
    }
  </style>
  <style>
    .popuptext{
        color:red;
    }
    .Scedule{
        text-align: center;
    }
    html{
        background-color:whitesmoke;
    }
  </style>
  <title>ユーザー情報</title>
  <div id="popup" class="popup">
<div class="popuptext">
    <h2>ご注意ください!!</h2>

</div>
    <p>IDはログイン時に必要になるデータになるので慎重に保管してください</p>
    <button class="close-btn">閉じる</button>

  <script>
    window.addEventListener('DOMContentLoaded', (event) => {
      // ページ読み込み時にポップアップを表示
      const popup = document.querySelector('.popup');
      popup.classList.add('show');
    });
  </script>
</head>
<body>

  <script>
  const popup = document.querySelector('.popup');
  const closeBtn = document.querySelector('.close-btn');
  closeBtn.addEventListener('click', () => {
    popup.style.display = 'none'; // ポップアップを非表示にする
  });
</script>
</div>
<div class="Scedule">
<h1>ユーザー情報</h1>
<hr>
<h2>ユーザー名：<c:out value="${number.name}" /></h2>
<h2>ID:<c:out value="${number.number}" /></h2>
<br><br>
<p>IDはログイン時に必要になるので大切に保管してください</p>
</body>
<br>
<br><br>
<br><br><br><br><br>
<a href="/amateur/ScheduleServlet">1日のスケジュール</a>
</div>
</html>