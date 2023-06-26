'use strict';

//ログイン時にポップアップを表示させる機能
var words = ["おはようございます！今日も頼りにしています。", "朝から元気そうですね！素晴らしいスタートです。", "早く来てくれてありがとう！助かります。",
	  "いつも時間通りに来てくれて感謝しています。", "あなたがいると安心です。","朝一番にあなたの笑顔を見ると、一日が明るくなります。","チームの一員として頼もしい存在ですね。","出勤がスムーズにできるのは、あなたのおかげです。","仕事の始まりにあなたと一緒にいると、気持ちが引き締まります。","仕事の始まりにあなたと一緒にいると、気持ちが引き締まります。",
	  "朝から活気があふれる感じがします。ありがとう。","仕事への取り組み方が素晴らしいですね。","いつも真剣に取り組んでくれて感謝しています。","あなたの出勤がチームにとって大きな力になっています。","仕事に対する情熱が伝わってきます。尊敬します。","今日も素晴らしいパフォーマンスを期待しています。","あなたの仕事ぶりは、周りに良い影響を与えています。",
	  "チーム全体が活気づいてきます。ありがとう。","グループのリーダーとして頼もしいですね。","朝一番に会えて嬉しいです。一緒に頑張りましょう。","出勤が迅速で助かります。感謝しています。","あなたの存在がチームの雰囲気を明るくしています。","元気な声が聞こえると、気持ちも引き締まります。","今日も一緒に頑張っていきましょう！","朝から活気があふれる雰囲気を作ってくれてありがとう。",
	  "仕事への取り組み姿勢が見習いたいです。ありがとう。","あなたがいると、全体のモチベーションが上がります。","出勤が早いのは、本当に助かります。感謝しています","仕事への情熱が伝わってきます。尊敬します。","今日も一緒に頑張っていきましょう！","元気な挨拶が気持ちを引き締めます。ありがとう。","出勤が迅速で確実なので、安心して仕事ができます。","あなたの存在がチームの結束力を高めています。",
	  "朝の挨拶からパワーをもらえます。ありがとう。","仕事に対する姿勢が素晴らしいですね。感謝しています。","あなたの出勤がチームにとって大きな支えになっています。","あなたの出勤がチームにとって大きな支えになっています。","出勤がスムーズにできるのは、あなたの努力の賜物です。","今日も一緒に頑張っていきましょう！","今日も一緒に頑張っていきましょう！","出勤が早いのは、チームの信頼に繋がっています。感謝しています。",
	  "あなたの仕事ぶりは、周りに良い影響を与えています。","仕事への情熱が感じられます。尊敬します。","今日も一緒に頑張っていきましょう！","朝から明るい声が聞こえると、一日が楽しくなります。ありがとう。","出勤がスムーズなので、作業の流れもスムーズです。助かります。","あなたの存在がチームの活気を引き出しています。","出勤が早いのは、真剣な姿勢の証です。感謝しています。","仕事に対する姿勢が素晴らしいですね。尊敬します。","今日も一緒に頑張っていきましょう！",
	  "今すぐ会社を辞めて自由に生きよう！！！"];
  //ランダムで50個

    window.addEventListener('DOMContentLoaded', (event) => {
      // ページ読み込み時にポップアップを表示
      if(!sessionStorage.getItem('display')){
      		sessionStorage.setItem('display', 'on');
      		const popup = document.querySelector('.popup');
      		popup.classList.add('show');
      		showRandomWordPopup();
      }
    });

    function showRandomWordPopup() {
        var randomIndex = Math.floor(Math.random() * words.length);
        var randomWord = words[randomIndex];
        document.getElementById("random-word").textContent = randomWord;
      }

    const popup = document.querySelector('.popup');
    const closeBtn = document.getElementById('close-btn');
    closeBtn.addEventListener('click', () => {
      popup.style.display = 'none'; // ポップアップを非表示にする
    });


//時刻表を表示させる処理
window.addEventListener('load', () =>{
	    	var tableBody = document.querySelector('tbody');
	    	//表示されている年月日を取得
	    	var year = document.getElementById("year").innerHTML;
	    	var month = document.getElementById("month").innerHTML;
	    	var day = document.getElementById("day").innerHTML;
	    	if(month < 10 && day < 10){
	    		var date = year + "-0" + month + "-0" + day;
	    	}else if(month < 10){
	    		var date = year + "-0" + month + "-" + day;
	    	}else if(day < 10){
	    		var date = year + "-" + month + "-0" + day;
	    	}else{
	    		var date = year + "-" + month + "-" + day;
	    	}
	    	//タスクの開始時間を取得
	    	var start = document.getElementsByClassName("start");
	    	var task = document.getElementsByClassName("task");

	    	//1時間ごとの時刻表を作る
	    	var i = 0;//配列のためのやつ
	    	for (var hour = 0; hour <= 23; hour++) {
	   		//一行作成
	      	var row = document.createElement('tr');
	      	//先に時間を作成
	   		if(hour < 10){
	   			var time = "0" + hour + ':00';
	   		}else{
	   			var time = hour + ':00';
	   		}
	      	//表を作成するための変数を作成
	      	var eventCell;
	      	var timeCell;
	      	//比較のための時刻を作成
	      	var timeC = time + ':00';
	      	var compareTime = date + " " + timeC
	      	//その時刻にタスクがあったらeventCellに内容を追加
	      	if(i < start.length){
			      	var a = 0; //その時間のタスクカウント
			      	while(i < start.length){ //時間が合っているかの判定。終わったらループ終了
			      		var taskTime = start[i].innerHTML
		 	    		if( taskTime == compareTime){
		 	    				eventCell = document.createElement('td');
		 	    				var taskContent = task[i].innerHTML;
			    	      		eventCell.textContent = taskContent;
			    	      		i++;
			    	      		a++;
			    	      		}else{
	    	      					break;
	    	      				}
	    	  		  };
			    	  //カウンターの判定
			    	  if(a >= 2){ //aが２以上だったら同時刻にタスクが2個以上あることになるのでセルを結合
			 					timeCell = document.createElement('th rowspan = \"'+ a + '\"');
			    	      		timeCell.textContent = time;
			    	  }else if(a == 1){
			    	      		timeCell = document.createElement('th');
			    	      		timeCell.textContent = time;
			    	  }else{
			    	  			timeCell = document.createElement('th');
			    	      		timeCell.textContent = time;
			    	      		eventCell = document.createElement('td');
			    	      		eventCell.textContent = "";
			    	  };

	    	}else{
	    		var timeCell = document.createElement('th');
	    	    timeCell.textContent = time;
	    	    eventCell = document.createElement('td');
	      		eventCell.textContent = "";
	      	}
	        row.appendChild(timeCell);
	      	row.appendChild(eventCell);
	      	tableBody.appendChild(row);
	      }
	  })

	  //メモのJavaScript
		var inputText = document.getElementById("input-text");

		inputText.addEventListener("input", function(event) {
	  	inputText.style.height = "auto";
	  	inputText.style.height = inputText.scrollHeight + "px";
		});

