<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カレンダー</title>
<!-- スタイルシートの挿入リンク -->
<link href="calendar.css" rel="stylesheet">
</head>
<body>
<div class = wrapper>
<!-- ヘッダー -->
<header class = header>
<img src = "" alt="ロゴ画像">
<h1>アプリ名</h1>
<nav class="nav">
                <ul>
                    <li><a href="/amateur/ScheduleServlet">1日のスケジュール</a></li>
                    <li><a href="/amateur/CalendarServlet">カレンダー</a></li>
                    <li id = add><a href="/amateur/GoalRegistServlet">追加</a></li>
                    <li><a href="/amateur/AchieveServlet">達成度</a></li>
                    <li><a href="/amateur/ExplanationServlet">アプリの使い方</a></li>
                </ul>
            </nav>
</header>
</div>
<h2>長期目標 : ${lg.longGoal}</h2><!-- 設定された長期目標を表示する。データベースLGOALから取得 -->
<h3>達成度 : ％<!-- 達成度を表示する --></h3>

<table>
<tr>
<td colspan="3">
<button id="prev" onclick="location.href = '/example/LastMonthServlet'">先月</button>
<%
	Integer month = (Integer)request.getAttribute("displayMonth");
	Integer year = (Integer)request.getAttribute("displayYear");
	out.print("<p>" + year + "年" + month + "月</p>");
%>
<button id="next" onclick="location.href= '/example/NextMonthServlet'">翌月</button>
</td>
</tr>
</table>
</div>
<div id="calendar">
<br>カレンダー表示</div>
<table>
            <thead>
                <tr> <th>日</th> <th>月</th> <th>火</th> <th>水</th> <th>木</th> <th>金</th> <th>土</th>
                </tr>
            </thead>
            <tbody> <%-- カレンダーの日付を表示する部分 --%>
            <%
            //MonthCounterの情報をスコープから取り出す
			Integer mc = (Integer)session.getAttribute("monthCounter");
			//カレンダーのインスタンスを2個生成
			Calendar calendar1 = Calendar.getInstance();
			Calendar calendar2 = Calendar.getInstance();
			//calendar1を表示したいカレンダーの月にセット
            calendar1.add(Calendar.MONTH, mc);
            //月の最終日を取得
            int daysInMonth = calendar1.getActualMaximum(Calendar.DAY_OF_MONTH);//30
            //〇月１日にセットしなおす
            calendar1.set(Calendar.DAY_OF_MONTH, 1);
            // カレンダーの表示月の最初の曜日を取得
            int firstDayOfWeek = calendar1.get(Calendar.DAY_OF_WEEK);//5
            // カレンダーの表示月の前月の日数を計算
            int daysInPreviousMonth = firstDayOfWeek - 1;//4
			//表示したい月の先月のカレンダーをcalendar2にセット
            int lastMonth = mc - 1;
            calendar2.add(Calendar.MONTH, lastMonth);
            //先月の最終日を取得
            int daysInMonth_l = calendar2.getActualMaximum(Calendar.DAY_OF_MONTH);//31

            // カレンダーの表示月の日付を生成して表示
         int a=1;
		 if(daysInPreviousMonth!=0){
			for(int i=daysInPreviousMonth; i>=0; i--){
			      if(i==daysInPreviousMonth){
			            out.print("<tr>");
			      }else{
			            out.print("<td>" +(daysInMonth_l-i) + "</td>");
			      }
			   }
		 }

	    for(int j=1;j<=daysInMonth;j++){
	        if((j+daysInPreviousMonth)%7==0){
	            out.print("<td>" +j + "</td>");
	            out.print("</tr>");
	        }else if((j+daysInPreviousMonth)%7==1){
	            out.print("<tr>");
	            out.print("<td>" +j + "</td>");
	        }else{
	            out.print("<td>" +j + "</td>");
	        }
	        if(j==daysInMonth && (j+daysInPreviousMonth)%7!=0){
	            for(int k=7-((j+daysInPreviousMonth)%7);k>0;k--){
	                out.print("<td>" +a+ "</td>");
	                a++;
	            }
	            out.print("</tr>");
	        }
	    }
          %>
            </tbody>
        </table>
</div>
</body>
</html>