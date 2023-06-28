/**
 *
 */
'use strict';

  document.getElementById("dataForm").addEventListener("submit", function(event) {
    var lgInput = document.getElementsByName("lg");
    var sgInput1 = document.getElementsByName("sg1");

    if (lgInput === "") {
      event.preventDefault(); // フォームの送信を中止

      alert("長期目標を記入してください"); // ポップアップメッセージを表示
    }

    if (sgInput1 === "" && !tdInput1_1 === "" ||
		sgInput1 === "" && !tdInput1_2 === "" ||
		sgInput1 === "" && !tdInput1_3 === "" ||
		sgInput1 === "" && !tdInput1_4 === "" ||
		sgInput1 === "" && !tdInput1_5 === "" ) {
      event.preventDefault(); // フォームの送信を中止

      alert("短期目標１を記入してください"); // ポップアップメッセージを表示
    }
  });