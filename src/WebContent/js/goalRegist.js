/**
 *
 */
'use strict';

  document.getElementById("dataForm").addEventListener("submit", function(event) {
    var lgInput = document.getElementsByName("lg");
    var sgInput = document.getElementsByName("sg");

    if (lgInput.equals("")) {
      event.preventDefault(); // フォームの送信を中止

      alert("長期目標を記入してください"); // ポップアップメッセージを表示
    }

    if (sgInput1.equals("") && !tdInput1_1.equals("") ||
		sgInput1.equals("") && !tdInput1_2.equals("") ||
		sgInput1.equals("") && !tdInput1_3.equals("") ||
		sgInput1.equals("") && !tdInput1_4.equals("") ||
		sgInput1.equals("") && !tdInput1_5.equals("") ) {
      event.preventDefault(); // フォームの送信を中止

      alert("短期目標１を記入してください"); // ポップアップメッセージを表示
    }
  });