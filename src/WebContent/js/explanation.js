'use strict' ;

//ボタンの表示を横向きから下向きに変える 
    //後でJavaScriptに書き換える
    //試しに三つサンプルを書いてある。コピペで（^-^）
    //疲れてきたね、頑張ろbyかいせい
    function changeButton1() {
        var button = document.getElementById('myButton1');
        const description1 = document.getElementById('description1');
   
       if (button.innerHTML === '▷') {
           button.innerHTML = '▽';
       } else {
           button.innerHTML = '▷';
       }
       if (description1.style.display === 'none') {
           description1.style.display = 'block';
        } else {
           description1.style.display = 'none';
       }
       }
       function changeButton2() {
        var button = document.getElementById('myButton2');
        const description2 = document.getElementById('description2');
   
       if (button.innerHTML === '▷') {
           button.innerHTML = '▽';
       } else {
           button.innerHTML = '▷';
       }
       if (description2.style.display === 'none') {
           description2.style.display = 'block';
        } else {
           description2.style.display = 'none';
       }
       }
       function changeButton3() {
        var button = document.getElementById('myButton3');
        const description3 = document.getElementById('description3');
   
       if (button.innerHTML === '▷') {
           button.innerHTML = '▽';
       } else {
           button.innerHTML = '▷';
       }
       if (description3.style.display === 'none') {
           description3.style.display = 'block';
        } else {
           description3.style.display = 'none';
       }
   }