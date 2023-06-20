<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>タスク追加</title>

<link rel="stylesheet" href="/タスク.css">
</head>
<body>
<h1>タスク追加</h1>

<div class = "monthMove">
    <div class = "monthcontent">
    <a href = '/example/LastMonthServlet' class = "prev"></a>
    </div>
    <%
        Integer day = (Integer)request.getAttribute("displayDay");
        Integer month = (Integer)request.getAttribute("displayMonth");
        Integer year = (Integer)request.getAttribute("displayYear");
        out.print("<div class = monthcontent><h3>" + year + "年" + month + "月" + day + "日</h3></div>");
    %>
    <div class = "monthcontent">
    <a href = '/example/NextMonthServlet' class = "next"></a>
    </div>
    </div>

    <form action="" method="post">
        <input type="text" id="taskInput" name="task" placeholder="タスク">
        <label for="startTime">開始時間:</label>
            <!--<input type="time" id="startTime" name="startTime">-->
        <input type="number" id="startHour" name="startHour" min="0" max="23">時

        <label for="endTime">終了時間:</label>
            <!--<input type="time" id="endTime" name="endTime">-->
        <input type="number" id="endHour" name="endHour" min="0" max="23" readonly>時<br>
            <!-- 初めの時間を設定した後に一時間後に終わりが設定される処理↑ -->
        <input type="button" onclick="addTask()">
        <input type="submit" value="登録">
    </form>

    <script>
        // 開始時間のフィールド
        var startHourField = document.getElementById("startHour");
        // 終了時間のフィールド
        var endHourField = document.getElementById("endHour");

        // 開始時間のフィールドが変更されたときに終了時間を計算する関数
        startHourField.addEventListener("change", function() {
            var startHour = parseInt(startHourField.value, 10);
            var endHour = (startHour + 1) % 24; // 開始時間から1時間後の終了時間を計算（24時を超えた場合は0時に戻る）

            // 終了時間のフィールドに計算結果を設定
            endHourField.value = endHour;
        });
    </script>


    <!--<form>
        <label for="hour">時刻:</label>
        <input type="number" id="hour" name="hour" min="0" max="23">時
        // 時間で判別しているのか数字で判別しているのか？
        // <input type="number" id="minute" name="minute" min="0" max="59">分　　//分を表示するやつ
        <input type="text" id="sgInput" placeholder="タスク">
    </form>-->

   <!--　//パワープレイ
     <form action="Schedule.html" method="post">
        <label for="hours">0時~1時</label><br>
        <label for="schedule">タスク追加:</label>
        <input type="text" id="schedule" name="schedule"><br>

        <label for="hours">1時~2時</label><br>
        <label for="schedule">タスク追加:</label>
        <input type="text" id="schedule" name="schedule"><br>

        <label for="hours">2時~3時</label><br>
        <label for="schedule">タスク追加:</label>
        <input type="text" id="schedule" name="schedule"><br>

        <label for="hours">3時~4時</label><br>
        <label for="schedule">タスク追加:</label>
        <input type="text" id="schedule" name="schedule"><br>

        <label for="hours">4時~5時</label><br>
        <label for="schedule">タスク追加:</label>
        <input type="text" id="schedule" name="schedule"><br>

        <label for="hours">5時~6時</label><br>
        <label for="schedule">タスク追加:</label>
        <input type="text" id="schedule" name="schedule"><br>

        <label for="hours">6時~7時</label><br>
        <label for="schedule">タスク追加:</label>
        <input type="text" id="schedule" name="schedule"><br>

        <label for="hours">7時~8時</label><br>
        <label for="schedule">タスク追加:</label>
        <input type="text" id="schedule" name="schedule"><br>

        <label for="hours">8時~9時</label><br>
        <label for="schedule">タスク追加:</label>
        <input type="text" id="schedule" name="schedule"><br>

        <label for="hours">9時~10時</label><br>
        <label for="schedule">タスク追加:</label>
        <input type="text" id="schedule" name="schedule"><br>

        <label for="hours">10時~11時</label><br>
        <label for="schedule">タスク追加:</label>
        <input type="text" id="schedule" name="schedule"><br>

        <label for="hours">11時~12時</label><br>
        <label for="schedule">タスク追加:</label>
        <input type="text" id="schedule" name="schedule"><br>

        <label for="hours">12時~13時</label><br>
        <label for="schedule">タスク追加:</label>
        <input type="text" id="schedule" name="schedule"><br>

        <label for="hours">13時~14時</label><br>
        <label for="schedule">タスク追加:</label>
        <input type="text" id="schedule" name="schedule"><br>

        <label for="hours">14時~15時</label><br>
        <label for="schedule">タスク追加:</label>
        <input type="text" id="schedule" name="schedule"><br>

        <label for="hours">15時~16時</label><br>
        <label for="schedule">タスク追加:</label>
        <input type="text" id="schedule" name="schedule"><br>

        <label for="hours">16時~17時</label><br>
        <label for="schedule">タスク追加:</label>
        <input type="text" id="schedule" name="schedule"><br>

        <label for="hours">17時~18時</label><br>
        <label for="schedule">タスク追加:</label>
        <input type="text" id="schedule" name="schedule"><br>

        <label for="hours">18時~19時</label><br>
        <label for="schedule">タスク追加:</label>
        <input type="text" id="schedule" name="schedule"><br>

        <label for="hours">19時~20時</label><br>
        <label for="schedule">タスク追加:</label>
        <input type="text" id="schedule" name="schedule"><br>

        <label for="hours">20時~21時</label><br>
        <label for="schedule">タスク追加:</label>
        <input type="text" id="schedule" name="schedule"><br>

        <label for="hours">21時~22時</label><br>
        <label for="schedule">タスク追加:</label>
        <input type="text" id="schedule" name="schedule"><br>

        <label for="hours">22時~23時</label><br>
        <label for="schedule">タスク追加:</label>
        <input type="text" id="schedule" name="schedule"><br>

        <label for="hours">23時~24時</label><br>
        <label for="schedule">タスク追加:</label>
        <input type="text" id="schedule" name="schedule"><br>

        //<input type="submit" value="送信"><br>-->


</body>
</html>