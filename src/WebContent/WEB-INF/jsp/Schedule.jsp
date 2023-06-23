<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="model.AllA"%>
<%@ page import="model.Task"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<%
  AllA a = (AllA)request.getAttribute("a");
  int[] sgId = (int[])request.getAttribute("sgId");
  LocalDate currentDate = LocalDate.now();
%>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" type="image/png" href="/amateur/css/fabicon.png">
<link rel ="stylesheet" href="/amateur/css/schedule.css">
<link rel="stylesheet" href="/amateur/css/common.css">
  <div id="popup" class="popup">

    <p id="random-word"></p>
    <button class="close-btn">閉じる</button>

  <script>
  var words = ["おはようございます！今日も頼りにしています。", "朝から元気そうですね！素晴らしいスタートです。", "早く来てくれてありがとう！助かります。",
	  "いつも時間通りに来てくれて感謝しています。", "あなたがいると安心です。","朝一番にあなたの笑顔を見ると、一日が明るくなります。","チームの一員として頼もしい存在ですね。","出勤がスムーズにできるのは、あなたのおかげです。","仕事の始まりにあなたと一緒にいると、気持ちが引き締まります。","仕事の始まりにあなたと一緒にいると、気持ちが引き締まります。",
	  "朝から活気があふれる感じがします。ありがとう。","仕事への取り組み方が素晴らしいですね。","いつも真剣に取り組んでくれて感謝しています。","あなたの出勤がチームにとって大きな力になっています。","仕事に対する情熱が伝わってきます。尊敬します。","今日も素晴らしいパフォーマンスを期待しています。","あなたの仕事ぶりは、周りに良い影響を与えています。",
	  "チーム全体が活気づいてきます。ありがとう。","グループのリーダーとして頼もしいですね。","朝一番に会えて嬉しいです。一緒に頑張りましょう。","出勤が迅速で助かります。感謝しています。","あなたの存在がチームの雰囲気を明るくしています。","元気な声が聞こえると、気持ちも引き締まります。","今日も一緒に頑張っていきましょう！","朝から活気があふれる雰囲気を作ってくれてありがとう。",
	  "仕事への取り組み姿勢が見習いたいです。ありがとう。","あなたがいると、全体のモチベーションが上がります。","出勤が早いのは、本当に助かります。感謝しています","仕事への情熱が伝わってきます。尊敬します。","今日も一緒に頑張っていきましょう！","元気な挨拶が気持ちを引き締めます。ありがとう。","出勤が迅速で確実なので、安心して仕事ができます。","あなたの存在がチームの結束力を高めています。",
	  "朝の挨拶からパワーをもらえます。ありがとう。","仕事に対する姿勢が素晴らしいですね。感謝しています。","あなたの出勤がチームにとって大きな支えになっています。","あなたの出勤がチームにとって大きな支えになっています。","出勤がスムーズにできるのは、あなたの努力の賜物です。","今日も一緒に頑張っていきましょう！","今日も一緒に頑張っていきましょう！","出勤が早いのは、チームの信頼に繋がっています。感謝しています。",
	  "あなたの仕事ぶりは、周りに良い影響を与えています。","仕事への情熱が感じられます。尊敬します。","今日も一緒に頑張っていきましょう！","朝から明るい声が聞こえると、一日が楽しくなります。ありがとう。","出勤がスムーズなので、作業の流れもスムーズです。助かります。","あなたの存在がチームの活気を引き出しています。","出勤が早いのは、真剣な姿勢の証です。感謝しています。","仕事に対する姿勢が素晴らしいですね。尊敬します。","今日も一緒に頑張っていきましょう！",
	  "今すぐ会社を辞めて自由に生きよう！！！"];
  //50個

    /*window.addEventListener('DOMContentLoaded', (event) => {
      // ページ読み込み時にポップアップを表示
      const popup = document.querySelector('.popup');
      popup.classList.add('show');
      showRandomWordPopup();
    });
    function showRandomWordPopup() {
        var randomIndex = Math.floor(Math.random() * words.length);
        var randomWord = words[randomIndex];
        document.getElementById("random-word").textContent = randomWord;

      }*/
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
<title>1日のスケジュール</title>
<div class = wrapper>
<!-- ヘッダー -->
<header class = header>
<!-- <img src = ""> -->
<img src="/simpleBC/img/logo.png" alt="Image" class="image"id="moving-image">
<h1>あなただけの秘書</h1>

</header>
<div class = wrapper>
        <!-- ヘッダー -->
        <header class = header>
        <nav class="nav">
                        <ul>
                            <li><a href="/amateur/ScheduleServlet">1日のスケジュール</a></li>
                            <li><a href="/amateur/CalendarServlet">カレンダー</a></li>
                                <li class="dropdown">
                                <a href="#">追加</a>
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
    </div>
    <!-- 月を表示するためのボタン設定 -->
<div class = "monthMove">
<div class = "monthcontent">
<a href = '/amateur/ScheduleLastDayServlet' class = "prev"></a>
</div>
<div class = monthcontent><h3><c:out value= "${displayYear}"/>年<c:out value= "${displayMonth}"/>月<c:out value= "${displayday}"/>日</h3></div>
<div class = "monthcontent">
<a href = '/amateur/ScheduleNextDayServlet' class = "next"></a>
</div>
</div>
    <hr>

<p>${tmeDate}</p>
<div class="lg">
<c:forEach var="e" items="${taskList}" ><p><c:out value= "${e.task}"/></p></c:forEach>
<p>長期目標：<%=a.getLg()%></p>
<p><%=a.getLgA()%>％</p>
</div>

<div class="sg">
<p>短期目標</p>
<%for(int i = 0; i < sgId.length; i++){
	if(sgId[i] > 0){
		out.println("<p>" + a.getSgA().get(i).getSg() + "</p>" +
		"<p>" + a.getSgA().get(i).getsAchieve() + "％</p>");
	}
} %>
</div>

<div class="todo">
<p>Todoリスト</p>
<%for(int i = 0; i < sgId.length; i++){
	if(sgId[i] > 0){
		for(int j=0;j<a.getSgA().get(i).getTodoA().size();j++){
				out.println("<p>" + a.getSgA().get(i).getTodoA().get(j).getTodo()+ "</p>" +
				"<p>" + a.getSgA().get(i).getTodoA().get(j).gettAchieve()  + "％</p>");
		}
	}
} %>
</div>

<form method="POST" action="/amateur/ScheduleServlet" id = "formMemo" >
メモ<br>
<div class="form-container">
  <textarea id="input-text" name = "MEMO">${memo}</textarea>
  <input type="submit" name="REGIST_M" value="登録">
</div>

<script>
//メモのJavaScript
var inputText = document.getElementById("input-text");

inputText.addEventListener("input", function(event) {
	  inputText.style.height = "auto";
	  inputText.style.height = inputText.scrollHeight + "px";
	});
</script>

<div class="time">
<h3>時刻表</h3>
<table>
	    <thead>
	      <tr>
	        <th>時間</th>
	        <th>予定</th>
	      </tr>
	    </thead>
	    <tbody>
	      <!-- ここに時間ごとの行を追加します -->
	    </tbody>
</table>
<!-- タスクの中身を非表示で表示 -->
<div class = "taskContent">
<%//(L<Task>)request.getAttribute("taskL");%>
<p><%//t.get(0).getTask(); %></p>

</div>
	<script>
	//時刻表を表示させるためのjavascript
	  window.onload = function() {
	    var tableBody = document.querySelector('tbody');
	    for (var hour = 0; hour <= 23; hour++) {
	      var row = document.createElement('tr');
	      var timeCell = document.createElement('td');
	      timeCell.textContent = hour + ':00';
	      var eventCell = document.createElement('td');
	      // ここで各時間の予定を表示するための処理を追加します
	      //その時刻にタスクがあったらeventCellに内容を追加しなくちゃいけない
	      row.appendChild(timeCell);
	      row.appendChild(eventCell);
	      tableBody.appendChild(row);
	    }
	  };

	</script>
	</div>

	</div>
</body>

</html>
