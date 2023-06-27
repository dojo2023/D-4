'use strict';
  document.getElementById('formAccount').onsubmit = function(event) {
    var username = document.getElementsByName('NAME')[0].value;
    var password = document.getElementById('password').value;
    var passwordCon = document.getElementById('password_con').value;

    if (username.trim() === '' || password.trim() === '' || passwordCon.trim() === '') {
      event.preventDefault(); // フォームの送信を防止

      alert('「ユーザー名」「パスワード」「 パスワード確認用」が空欄では登録できません');
    }
  };
  var passwordInput = document.getElementById('password');
var showPasswordCheckbox = document.getElementById('showPassword');

showPasswordCheckbox.addEventListener('change', function() {
  if (showPasswordCheckbox.checked) {
    passwordInput.type = 'text'; // パスワードを表示
  } else {
    passwordInput.type = 'password'; // パスワードを非表示
  }
});
var passwordConInput = document.getElementById('password_con');
var showPasswordConCheckbox = document.getElementById('showPasswordCon');

showPasswordConCheckbox.addEventListener('change', function() {
  if (showPasswordConCheckbox.checked) {
    passwordConInput.type = 'text'; // パスワードを表示
  } else {
    passwordConInput.type = 'password'; // パスワードを非表示
  }
});