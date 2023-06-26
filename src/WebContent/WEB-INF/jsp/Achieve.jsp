<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.AllA"%>
<%@ page import="dao.TodotbDAO"%>

<!DOCTYPE html>
<html lang = "ja">
<head>
<meta charset="UTF-8">
<title>達成度入力・表示</title>
<link rel="stylesheet" href="/amateur/css/common.css">
<link rel="stylesheet" href="/amateur/css/achieve.css">
</head>
<body>
<div class = wrapper>
<!-- ヘッダーここから -->
<header class = header>
<!-- <img src = ""> -->

<h1>あなただけの秘書</h1>
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
<a href = '/example/LastMonthServlet' class = "prev"></a>
</div>
<div class = monthcontent><h3><c:out value= "${displayYear}"/>年<c:out value= "${displayMonth}"/>月</h3></div>
<div class = "monthcontent">
<a href = '/example/NextMonthServlet' class = "next"></a>
</div>
</div>

<%
//まずリクエストスコープとセッションスコープからユーザーidと日付を取ってくる
AllA a = (AllA)request.getAttribute("a");
 %>

<form method="POST" action="/amateur/AchieveServlet" id = "formAchieve" >
<p id = "lg_a">長期目標：<%=a.getLg()%>　達成度：<%=a.getLgA()%>％
<!-- 長期目標達成ゲージを追加するためのdiv -->
<div id = "lg_gage"></div></p>
<hr>
<div class="sg">
<%for (int i=0;i<(a.getSgA()).size();i++){
	out.println("<p>短期目標"+(i+1)+"：" + (a.getSgA()).get(i).getSg() +
	"達成度：" + (a.getSgA()).get(i).getsAchieve()+ "％<div id = sg_gage></div></p>");

	for(int j=0;j<a.getSgA().get(i).getTodoA().size();j++) {
		out.println("<p>todo"+(j+1)+":" + a.getSgA().get(i).getTodoA().get(j).getTodo()
			 + "<input type=text name = ACHIEVE value = '" + a.getSgA().get(i).getTodoA().get(j).gettAchieve() + " 'size='1'>％</p>");
		}
} %>
</div>
<input type="submit" name="REGIST_A" value="確定">
</form>
<!-- メインここまで -->
</div>
<!--JavaScriptの記入欄-->
<!--  <script src = "achieve.js"></script>-->
<style>





  </style>
</head>
<body>
<div class="lgtext">
<p><%=a.getLg()%></p></div>
  <div class="lg <% if (a.getLgA() >= 80) { %>blue<% } else if (a.getLgA() >= 60) { %>green<% } else if (a.getLgA() >= 40) { %>yellow<% }
  else if(a.getLgA() >=20){%>orange<%}else { %>red<% } %>"></div>
<% for (int i = 0; i < a.getSgA().size(); i++) {
 String goalClass = "goal-" + i; // 短期目標ごとに一意のクラス名を生成

 %>



</div>
 <div class="goal-container <%= goalClass %>">
  <p>短期目標： <%= a.getSgA().get(i).getSg() %> </p>
  <div class="chart-container">
    <div class="bar <% if (a.getSgA().get(i).getsAchieve() >= 80) { %>blue<% } else if (a.getSgA().get(i).getsAchieve() >= 60) { %>green<% } else if (a.getSgA().get(i).getsAchieve() >= 40) { %>yellow<% } else if (a.getSgA().get(i).getsAchieve() >= 20) { %>orenge<% } else { %>red<% } %>" style="width: <%= a.getSgA().get(i).getsAchieve() %>%;"></div>
  </div>
  <% for (int j = 0; j < a.getSgA().get(i).getTodoA().size(); j++) { %>
     </div>
  <% } %>
<% } %>
<style>
    .bar {
        height: 20px;
    }
    <%=a.getLg()%>{
    width: <%= a.getLgA() %>%;
}
    <% for (int i = 0; i < a.getSgA().size(); i++) {
        String goalClass = "goal-" + i; // 短期目標ごとに一意のクラス名を生成
    %>
        .<%= goalClass %> {
            width: <%= a.getSgA().get(i).getsAchieve() %>%;
        }
    <% } %>

    /* 他のスタイルや要素に対するCSSスタイルの指定 */

</style>

  <script>
  function getColor(value) {
	  if (value >= 80) {
	    return 'blue';
	  } else if (value >= 60) {
	    return 'green';
	  } else if (value >= 40) {
	    return 'yellow';
	  } else if (value >= 20) {
	    return 'orenge';
	  } else if (value >= 1) {
	    return 'red';
	  } else  {
	    return ';
	  }
	}
  function getColor(value) {
	  if (value >= 80) {
	    return 'blue';
	  } else if (value >= 60) {
	    return 'green';
	  } else if (value >= 40) {
	    return 'yellow';
	  } else if (value >= 20) {
	    return 'orenge';
	  } else if (value >= 1) {
	    return 'red';
	  } else  {
	    return ';
	  }
	}

  </script>

<head>

</body>
</html>