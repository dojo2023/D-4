'use strict';

//カレンダーのidを取得
var calendar = document.getElementById("cal");
//カレンダーに載っている前月の日数
var PreviousDays = document.getElementById("PreviousDays");
var mathPrevious = Number(PreviousDays.innerHTML);
//表示月のすべての日数
var monthDays = document.getElementById("monthDays");
var mathMonth = Number(monthDays.innerHTML);

//カレンダーのtdにidの割り振りと、クリックされたときに処理が発生する設定を付与
//最初の週は余分な日以外の部分にidを設定する。曜日の列にはid付与しない
for(var p = PreviousDays.innerHTML; p < 7; p++){
	calendar.rows[1].cells[p].id = "1-" + p;
	calendar.rows[1].cells[p].onclick = moveSchedule; //画面遷移する関数
}
var rowsCount = Math.trunc((mathPrevious + mathMonth + 7) / 7);
var nextDays =  (mathPrevious + mathMonth) % 7;

//最終週以外（来月のカレンダーが入ってない場合はすべて）にidを付与
for(var i = 2; i < rowsCount; i++){
//calendar.rows[i].cells.lengthはi番目の縦1列のセル数
	for(var y = 0; y < 7; y++){
		calendar.rows[i].cells[y].id = i + "-" + y;
		calendar.rows[i].cells[y].onclick = moveSchedule; //画面遷移する関数
	}
}
if(nextDays != 0){
	for(var y = 0; y < nextDays; y++){
		calendar.rows[rowsCount].cells[y].id = rowsCount + "-" + y;
		calendar.rows[rowsCount].cells[y].onclick = moveSchedule; //画面遷移する関数
	}
}

//クリックされた要素をGETに送る処理
function moveSchedule(e) {
	var selectDay = document.getElementById(e.target.id);
    selectDay.style.backgroundColor = "#ddffbc";

    //隠しフォームにvalue値を設定する
    var form = document.getElementById("scheMove");
	var year = document.getElementById('year');
	var month = document.getElementById('month');

	var yearForm = form["YEAR"];
	var monthForm = form["MONTH"];
	var dayForm = form["DAY"];

	yearForm.value = year.innerHTML;
	monthForm.value = month.innerHTML;
	dayForm.value = selectDay.innerHTML;

	//データを送信
	form.submit();
}

//短期目標をバーでカレンダーに表示させる機能
//ついでに長期目標の色付けもする
/*
document.addEventListener('DOMContentLoaded', function(){
		//長期目標の達成度を取得して数値変換
		var lgAchieve = document.getElementsByClassName("lgAchieve");
		var lg_achieve = Number(lgAchieve);

		//短期目標のスタートとラストの日付を取ってくる。ついでに達成度も
		var start = document.getElementsByClassName("start");
		var end = document.getElementsByClassName("end");
		var achieve = document.getElementsByClassName("achieve");

		//中身から日付だけを切り出して数値変換したものを配列に入れる
		let s_starts = [];
		let s_ends = [];
		let s_achieves = [];

			for(i = 0; i < start.length; i++){
				var s = start[i].innerHTML;
				var e = end[i].innerHTML;
				var a = achieve[i].innerHTML;
				//要素を切り出して数値変換
				var s_start = Number(s.substr(8));
				var s_end = Number(e.substr(8));
				var s_achieve = Number(a);
				//配列のi番目に入れる
				s_starts[i] = s_start;
				s_ends[i] = s_end;
				s_achieves[i] = s_achieve;
			}
		//日付の計算から、カレンダーの日付と一致するidを割り出して配列に入れる
		//例：前月のカレンダーに表示された日数 + スタートの日付 / 7 のあまり
		//4 + 1 = 5 5÷7のあまりは5 横の位置が知りたいため-1して4
		//ただし、割り切れてしまったら横の位置の値は6固定
		//縦列の求め方：商 + 1がそのまま縦列の位置になる
		//ただし、割り切れてしまった場合は-1

		for(i = 0; i < s_starts.length; i++){
				//まずスタートの日付のidを割り出す
				var s_beside = (mathPrevious + s_starts[i]) % 7;
				var s_vertical = Math.trunc((mathPrevious + s_starts[i]) / 7 );
				if(s_beside === 0){
						s_beside += 1;
						s_vertical -= 1;
				}
				//終わりの日付のidを割り出す
				var e_beside = (mathPrevious + s_ends[i]) % 7;
				var e_vertical = Math.trunc((mathPrevious + s_ends[i]) / 7 );
				if(e_beside === 0){
						e_beside += 1;
						e_vertical -= 1;
				}
				//最初と最後のidを取得してそこからそこまでの各セルに同一のクラスを割り振る
				//始めと終わりが同列だった場合
				var a = 1;
				if(s_vertical === e_vertical){
					for(i = s_beside; i <= e_beside; i++){
						var id = s_vertical + '-' + i;
						s_period = document.getElementById(id);
						s_period.classList.add("period" + a);
						a++;
					}
				}else{ //始めと終わりの列が異なる場合
						//とりあえず一列目のidを付与
						for(y = s_beside; y < 7; y++){
							var id =  s_vertical + '-' + y;
							s_period = document.getElementById(id);
							s_period.classList.add("period" + a);
					}
					//縦列の引き算の結果で条件分岐
					if(e_vertical - s_vertical === 1){
						for(y = 0; y <= e_beside; y++){
							var id =  e_vertical + '-' + y;
							s_period = document.getElementById(id);
							s_period.classList.add("period" + a);
						}
					}else if(){

					}
				}

		}

});
*/


//クラスの背景色を操作
//これでできるのでは
