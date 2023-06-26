'use strict';

//カレンダーのidを取得
var calendar = document.getElementById("cal");
//カレンダーに載っている前月の日数
var PreviousDays = document.getElementById("PreviousDays");
//表示月のすべての日数
var monthDays = document.getElementById("monthDays");

//カレンダーのtdにidの割り振りと、クリックされたときに処理が発生する設定を付与
//最初の週は余分な日以外の部分にidを設定する。曜日の列にはid付与しない
for(var p = PreviousDays.innerHTML; p < 7; p++){
	calendar.rows[1].cells[p].id = "1-" + p;
	calendar.rows[1].cells[p].onclick = moveSchedule; //画面遷移する関数
}
var rowsCount = Math.trunc((PreviousDays.innerHTML + monthDays.innerHTML + 7) / 7);
var nextDays = (PreviousDays.innerHTML + monthDays.innerHTML) % 7;
//最終週以外（来月のカレンダーが入ってない場合はすべて）にidを付与
for(var i = 2; i < rowsCount; i++){
//calendar.rows[i].cells.lengthはi番目の縦1列のセル数
	for(var y = 0; y < 7; y++){
		calendar.rows[i].cells[y].id = i + "-" + y;
		calendar.rows[i].cells[y].onclick = moveSchedule; //画面遷移する関数
	}
}
if(nextDays != 0){
	for(var y = 0; y < (7 - nextDays); y++){
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
