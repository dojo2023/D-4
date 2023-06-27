'use strict';


  document.getElementById("formLogin").addEventListener("submit", function(event) {
    var idInput = document.getElementsByName("NUMBER")[0];
    var passwordInput = document.getElementsByName("PW")[0];

    if (idInput.value === "" || passwordInput.value === "") {
      event.preventDefault(); // フォームの送信を中止

      alert("IDとパスワードが空欄ではログインできません"); // ポップアップメッセージを表示
    }
  });

var passwordInput = document.getElementById('password');
var showPasswordCheckbox = document.getElementById('showPassword');

showPasswordCheckbox.addEventListener('change', function() {
  if (showPasswordCheckbox.checked) {
    passwordInput.type = 'text'; // パスワードを表示
  } else {
    passwordInput.type = 'password'; // パスワードを非表示
  }
});
