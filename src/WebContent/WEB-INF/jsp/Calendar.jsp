<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="model.AllA"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カレンダー</title>
<!-- スタイルシートの挿入リンク -->
<link rel="icon" type="image/png" href="/amateur/img/fabicon.png">
<link rel="stylesheet" href="/amateur/css/common.css">
<link rel="stylesheet" href="/amateur/css/calendar.css">
</head>

<body>
<div class = "wrapper">
<img src = "" alt="ロゴ画像">
<h1>アプリ名</h1>

<!-- ヘッダー -->
<header class = "header">
<img src="/amateur/img/logo.png" alt="Image" class="image"id="moving-image">
<h1>あなただけの秘書</h1>
<nav class="nav">
                <ul>
                    <li><a href="/amateur/ScheduleServlet">1日のスケジュール</a></li>
                    <li><a href="/amateur/CalendarServlet">カレンダー</a></li>
                    <li class="dropdown">
                    <a href="#">追加▽</a><!-- #で遷移なしの表示する？ -->
                                    <div class="dropdown-content">
                                     <a href="/amateur/GoalRegistServlet">目標追加画面</a>
                                        <a href="/amateur/TaskRegistServlet">タスク追加画面</a>
                                    </div>
                                </li>
                    <li><a href="/amateur/AchieveServlet">達成度</a></li>
                    <li><a href="/amateur/ExplanationServlet">アプリの使い方</a></li>
                	<li id = "logout"><a href="/amateur/LogoutServlet">ログアウト</a></li>
                </ul>
            </nav>
</header>

<%
  AllA al = (AllA)request.getAttribute("a");
%>
<h2>長期目標 :
<%if (al.getLg() == null){
	out.print("");
}else{
	out.print(al.getLg());
}%>
</h2>
<h3>達成度 :
<%if (al.getLgA() != 1000){
	out.print(al.getLgA());
}else{
	out.print("0");
}%>％</h3>
<!-- 見えない短期目標を設定 -->
<div class = "sgContent">
<%for (int i=0;i < (al.getSgA()).size();i++){
	String sg = (al.getSgA()).get(i).getSg();
	if(sg.equals("")){
		break;
	}else{
		out.println("<span class = \"sgContent\">" + (al.getSgA()).get(i).getSg() + "</span>");
		out.println("<span class = \"achieve\">" + (al.getSgA()).get(i).getsAchieve() + "</span>");
		out.println("<span class = \"start\">" + al.getSgA().get(i).getDay_s() + "</span>");
		out.println("<span class = \"end\">" + al.getSgA().get(i).getDay_e() + "</span>");
	}
}%>
</div>
<div class = "monthMove">
<div class = "monthcontent">
<a href = '/amateur/LastMonthServlet' class = "prev"></a>
</div>
<div class = monthcontent><h3>
	<span id = "year"><c:out value= "${displayYear}"/></span>年
	<span id = "month"><c:out value= "${displayMonth}"/></span>月
</h3></div>
<div class = "monthcontent">
<a href = '/amateur/NextMonthServlet' class = "next"></a>
</div>
</div>

<table  class="calendar" id = "cal">
			<thead>
                <tr> <th class = Sunday>日</th> <th>月</th> <th>火</th> <th>水</th>
                		<th>木</th> <th>金</th> <th class = Saturday>土</th>
                </tr>
            </thead>
            <%-- カレンダーの日付を表示する部分 --%>
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
			            out.print("<td class = extraDays>" +(daysInMonth_l-i) + "</td>");
			      }
			   }
		 }

	    for(int j=1;j<=daysInMonth;j++){
	        if((j+daysInPreviousMonth)%7==0){
	            out.print("<td class = Saturday>" +j + "</td>");
	            out.print("</tr>");
	        }else if((j+daysInPreviousMonth)%7==1){
	            out.print("<tr>");
	            out.print("<td class = Sunday>" +j + "</td>");
	    	}else{
	            out.print("<td>" + j + "</td>");
	        }
	        if(j==daysInMonth && (j+daysInPreviousMonth)%7!=0){
	            for(int k=7-((j+daysInPreviousMonth)%7);k>0;k--){
	                out.print("<td class = extraDays>" +a+ "</td>");
	                a++;
	            }
	            out.print("</tr>");
	        }
	    }
	    out.print("<div class = \"calculation\"><span id = \"PreviousDays\">" + daysInPreviousMonth + "</span>");
	    out.print("<span id = \"monthDays\">" + daysInMonth + "</span></div>");
          %>
        </table>

        <!-- 隠しフォームを作る -->
        <form  method="GET" action="/amateur/ScheduleServlet" id = "scheMove">
        <input type = hidden name = "YEAR" value = "">
        <input type = hidden name = "MONTH" value = "">
        <input type = hidden name = "DAY" value = "">
        </form>

<footer>
<p>&copy;Copyright plusDOJO(SE plus) amateur programmer. All rights reserved.</p>
</footer>

</div>

<script src = "/amateur/js/calendar.js"></script>

</body>
</html>