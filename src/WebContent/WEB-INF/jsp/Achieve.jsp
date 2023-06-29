<!-- 2023-06-27 16h -->
<!-- 2023-06-28 10h -->
<!-- 2023-06-28 14h -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.AllA"%>
<%@ page import="dao.TodotbDAO"%>

<!DOCTYPE html>
<html lang = "ja">
<head>
<meta charset="UTF-8">
<title>達成度入力・表示</title>
<link rel="icon" type="image/png" href="/amateur/img/fabicon.png">
<link rel="stylesheet" href="/amateur/css/common.css">
<link rel="stylesheet" href="/amateur/css/achieve.css">
</head>
<body>
<div class = wrapper>
<!-- ヘッダーここから -->
<header class = header>
<img src="/amateur/img/logo.png" alt="Image" class="image"id="moving-image">
<nav class="nav">
                <ul>
                    <li><a href="/amateur/ScheduleServlet">1日のスケジュール</a></li>
                            <li><a href="/amateur/CalendarServlet">カレンダー</a></li>
                                <li class="dropdown">
                                <a href="#">追加▽</a>
                                    <div class="dropdown-content">
                                        <a href="/amateur/GoalRegistServlet">目標追加画面</a>
                                        <a href="/amateur/TaskRegistServlet">タスク追加画面</a>
                                    </div>
                                </li>
                            <li><a href="/amateur/AchieveServlet">達成度</a></li>
                         <li class="current"><a href="/amateur/ExplanationServlet">アプリの使い方</a></li>
                     <li id = "logout"><a href="/amateur/LogoutServlet">ログアウト</a></li>
                </ul>
            </nav>
</header>
<!-- ヘッダーここまで -->

<!-- メインここから -->
<!-- 月を表示するためのボタン設定 -->
<div class = "monthMove">
<div class = "monthcontent">
<a href = '/amateur/AchieveLastMonthServlet' class = "prev"></a>
</div>
<div class = monthcontent><h3><c:out value= "${displayYear}"/>年<c:out value= "${displayMonth}"/>月</h3></div>
<div class = "monthcontent">
<a href = '/amateur/AchieveNextMonthServlet' class = "next"></a>
</div>
</div>

<%
//まずリクエストスコープとセッションスコープからユーザーidと日付を取ってくる
AllA a = (AllA)request.getAttribute("a");
 %>

<form method="POST" action="/amateur/AchieveServlet" id = "formAchieve" >
<p id = "lg_a">長期目標：<%=a.getLg()%>　達成度：<%=a.getLgA()%>％</p>
<!-- 長期目標達成ゲージを追加するためのdiv -->
<div id="life-frame">
    <div id="lg_gage"></div>
    <div id="life-mark"></div>
</div>

<div class="content">
<%for (int i=0;i<(a.getSgA()).size();i++){
	out.println("<p class=\"sg\">短期目標"+(i+1)+"：" + (a.getSgA()).get(i).getSg() +
	"達成度：" + (a.getSgA()).get(i).getsAchieve()+ "％<div id=\"life-frame\"><div id=\"sg_gage"+i+"\"></div><div id=\"life-mark\"></div></div></p>");

	for(int j=0;j<a.getSgA().get(i).getTodoA().size();j++) {
		out.println("<ul><li class=\"todo\">todo"+(j+1)+":" + a.getSgA().get(i).getTodoA().get(j).getTodo()
			 + "<input type=text name = 'ACHIEVE" + i + "-" + j + "'  value = '" + a.getSgA().get(i).getTodoA().get(j).gettAchieve() +
			 "' class = \"achieve\">％<input type=hidden name = 'TODOID" + i + "-" + j + "'  value = '" + a.getSgA().get(i).getTodoA().get(j).getTodoId() + "'></li></ul>");
		}
} %>
</div>
<input type="submit" name="REGIST_A" value="確定">
</form>

<!-- メインここまで -->
<footer class="footer">
        &copy;Copyright plusDOJO(SE plus) amateur programmer. All rights reserved.
    </footer>
</div>
<!--JavaScriptの記入欄src = "/bc/js/achieve.js"-->
<script>
const lifeBar = document.getElementById('lg_gage');
const pointBar = document.getElementById('life-mark');
lifeBar.style.width = <%=a.getLgA()%> + "%";
if(<%=a.getLgA()%><20){
	lifeBar.style.backgroundColor="red";
	pointBar.style.backgroundColor="red";
	pointBar.style.boxShadow="0 0 5px 3px red,0 0 7px 7px red";
}else if(20<=<%=a.getLgA()%>&&<%=a.getLgA()%><40){
	lifeBar.style.backgroundColor="orange";
	pointBar.style.backgroundColor="orange";
	pointBar.style.boxShadow="0 0 5px 3px orange,0 0 7px 7px orange";
}else if(40<=<%=a.getLgA()%>&&<%=a.getLgA()%><60){
	lifeBar.style.backgroundColor="yellow";
	pointBar.style.backgroundColor="yellow";
	pointBar.style.boxShadow="0 0 5px 3px yellow,0 0 7px 7px yellow";
}else if(60<=<%=a.getLgA()%>&&<%=a.getLgA()%><80){
	lifeBar.style.backgroundColor="green";
	pointBar.style.backgroundColor="green";
	pointBar.style.boxShadow="0 0 5px 3px green,0 0 7px 7px green";
}else if(80<=<%=a.getLgA()%>&&<%=a.getLgA()%><100){
	lifeBar.style.backgroundColor="blue";
	pointBar.style.backgroundColor="blue";
	pointBar.style.boxShadow="0 0 5px 3px blue,0 0 7px 7px blue";
}else{
	lifeBar.style.background="linear-gradient(to right,#e60000,#f39800,#fff100,#009944,#0068b7,#1d2088,#920783,#e60000) 0 / 200%";
	pointBar.style.backgroundColor="yellow";
	pointBar.style.boxShadow="0 0 5px 3px linear-gradient(to right,#C70000,#D28300,#DFD000,#00873C,#005AA0,#181878,#800073),0 0 7px 7px linear-gradient(to right,#C70000,#D28300,#DFD000,#00873C,#005AA0,#181878,#800073)";
}

const ary=[];
if(<%=a.getSgA().size()%>>0){
	ary[0] = document.getElementById('sg_gage'+0);
	ary[0].style.width = <%if(a.getSgA().size()>0){out.print((a.getSgA()).get(0).getsAchieve());}%>+ "%";
}
if(<%=a.getSgA().size()%>>1){
	ary[1] = document.getElementById('sg_gage'+1);
	ary[1].style.width = <%if(a.getSgA().size()>1){out.print((a.getSgA()).get(1).getsAchieve());}%>+ "%";
}
if(<%=a.getSgA().size()%>>2){
	ary[2] = document.getElementById('sg_gage'+2);
	ary[2].style.width = <%if(a.getSgA().size()>2){out.print((a.getSgA()).get(2).getsAchieve());}%>+ "%";
}
if(<%=a.getSgA().size()%>>3){
	ary[3] = document.getElementById('sg_gage'+3);
	ary[3].style.width = <%if(a.getSgA().size()>3){out.print((a.getSgA()).get(3).getsAchieve());}%>+ "%";
}
if(<%=a.getSgA().size()%>>4){
	ary[4] = document.getElementById('sg_gage'+4);
	ary[4].style.width = <%if(a.getSgA().size()>4){out.print((a.getSgA()).get(4).getsAchieve());}%>+ "%";
}
</script>

</body>
</html>