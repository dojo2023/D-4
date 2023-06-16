<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>目標追加</title>
  <style>
    ul {
      list-style-type: none;
      padding: 0;
    }

    li {
      margin-bottom: 5px;
    }

    .modal {
      display: none;
      position: fixed;
      z-index: 1;
      left: 0;
      top: 0;
      width: 100%;
      height: 100%;
      overflow: auto;
      background-color: rgba(0, 0, 0, 0.4);
    }

    .modal-content {
      background-color: #fefefe;
      margin: 10% auto;
      padding: 20px;
      border: 1px solid #888;
      width: 80%;
    }

    .close {
      color: #aaa;
      float: right;
      font-size: 28px;
      font-weight: bold;
      cursor: pointer;
    }

    .close:hover,
    .close:focus {
      color: black;
      text-decoration: none;
      cursor: pointer;
    }

    .todo-list {
      margin-left: 15px;
    }
  </style>
</head>
<body>
  <h1>目標追加</h1>

  <!-- 年月を表示 -->
  <div id="date-display"></div>
  <!-- 年月を遷移するボタン -->
  <button onclick="previousMonth()">Previous Month</button>
  <button onclick="nextMonth()">Next Month</button><br>
  <!-- 長期目標を追加  -->
  <input type="text" id=lgInput placeholder="長期目標"><br>
  <button onclick="addLg()">追加</button><br>
	<ul id="lgList"></ul> <!-- 長期目標の表示場所 -->

  <input type="text" id="sgInput" placeholder="短期目標"><input type="date" id="sgStart" placeholder="開始">
  <input type="date" id="sgEnd" placeholder="終了"><br>
  <button onclick="addSg()">追加</button>

  <ul id="sgList"></ul>

  <div id="modal" class="modal">
    <div class="modal-content">
      <span class="close" onclick="closeModal()">&times;</span>
      <h2>ToDoを追加</h2>
      <textarea id="todoInput" placeholder="ToDoを入力してください"></textarea>
      <button onclick="saveTodo()">保存</button>
    </div>
  </div>
  <button onclick="sendDataToServlet()">データを送信</button>

  <script>
  //現在の年月を獲得する
  var currentDate = new Date();
  var currentYear = currentDate.getFullYear(); // 現在の年を取得
  var currentMonth = currentDate.getMonth(); // 現在の月を取得（0=1月, 1=2月, ...）<br>

  updateDisplay();
  //年月を移動する関数
  //先月
    function previousMonth() {
    if (currentMonth === 0) {
      currentYear--;
      currentMonth = 11; // 12月に移動
    } else {
      currentMonth--;
    }

    updateDisplay();
  }
  //次月
  function nextMonth() {
    if (currentMonth === 11) {
      currentYear++;
      currentMonth = 0; // 1月に移動
    } else {
      currentMonth++;
    }

    updateDisplay();
  }

  //現在の年月を表示する関数
    function updateDisplay() {
    var displayElement = document.getElementById("date-display");
    var monthName = getMonthName(currentMonth);

    displayElement.textContent = monthName + " " + currentYear;
  }

  //年月の名前を取得する関数
    function getMonthName(month) {
    var monthNames = [
      "January", "February", "March", "April", "May", "June",
      "July", "August", "September", "October", "November", "December"
    ];

    return monthNames[month];
  }


  	//Lgアイテムを格納する配列
  	let lgs = [];

  	//Lgアイテムを追加する関数
  	function addLg(){
  		const lgInput = document.getElementById("lgInput");
  		const lgText = lgInput.value.trim();

  		if(lgText !== ""){
  			//既存の目標を削除

  			lgs = [];

  			const lg = {
  					id: Date.now(),
  					text: lgText,
  			};
  			lgs.push(lg);
  			 renderLgList(); // 長期目標リストを再描画
  		    lgInput.value = ""; // 入力欄をクリア
  		}
  	}

  	//Lgを描画する関数
  function renderLgList() {
  const lgList = document.getElementById("lgList");
  lgList.innerHTML = "";

  lgs.forEach(lg => {
    const listItem = document.createElement("li");
    listItem.textContent = lg.text;
    lgList.appendChild(listItem);
  });
}

    // sgアイテムを格納する配列
    let sgs = [];

    // 現在のToDoアイテムのID
    let currentSgId = null;

    // sgアイテムを追加する関数
    function addSg() {
      const input = document.getElementById("sgInput");
      const start= document.getElementById("sgStart");
      const end = document.getElementById("sgEnd");
      const sgText = input.value.trim();

      if (sgText !== "" && start.value !== "" && end.value !==""){
        const sg = {
          id: Date.now(),
          text: sgText,
          completed: false,
          //短期目標の期間
          start: start.value,
          end: end.value,
          todos: []
        };

        sgs.push(sg);
        input.value = "";

        renderSgList();
      }
    }

    // sgアイテムを削除する関数
    function deleteSgItem(sgId) {
      sgs = sgs.filter(sg => sg.id !== sgId);
      renderSgList();
    }

    // ToDoアイテムの完了状態をトグルする関数
    function toggleSgStatus(sgId) {
      sgs = sgs.map(sg => {
        if (sg.id === sgId) {
          return {
            ...sg,
            completed: !sg.completed
          };
        }
        return sg;
      });

      renderSgList();
    }

    // モーダルウィンドウを表示する関数
    function openModal(sgId) {
      const modal = document.getElementById("modal");
      modal.style.display = "block";
      currentSgId = sgId;
    }

    // モーダルウィンドウを閉じる関数
    function closeModal() {
      const modal = document.getElementById("modal");
      modal.style.display = "none";
      currentSgId = null;
    }

    // 詳細行動を保存する関数
    function saveTodo() {
      const todoInput = document.getElementById("todoInput");
      const todoText = todoInput.value.trim();

      if (todoText !== "" && currentSgId !== null) {
        const sg = sgs.find(sg => sg.id === currentSgId);
        sg.todos.push({
          id: Date.now(),
          text: todoText,
          completed: false
        });
        todoInput.value = "";

        closeModal();
        renderSgList();
      }
    }

    // 詳細行動を削除する関数
    function deleteTodo(sgId, todoId) {
      const sg = sgs.find(sg => sg.id === sgId);
      sg.todos = sg.todos.filter(todo => todo.id !== todoId);
      renderSgList();
    }

    // ToDoリストを描画する関数
    function renderSgList() {
      const sgList = document.getElementById("sgList");
      sgList.innerHTML = "";

      sgs.forEach(sg => {
        const listItem = document.createElement("li");

        const checkbox = document.createElement("input");
        checkbox.type = "checkbox";
        checkbox.checked = sg.completed;
        checkbox.addEventListener("change", () => toggleSgStatus(sg.id));
        listItem.appendChild(checkbox);

        const sgText = document.createTextNode(sg.text + " (" + sg.start + " - " + sg.end + ")");
        listItem.appendChild(sgText);

        const addButton = document.createElement("button");
        addButton.innerText = "ToDoを追加";
        addButton.addEventListener("click", () => openModal(sg.id));
        listItem.appendChild(addButton);

        if (sg.completed) {
          const deleteButton = document.createElement("button");
          deleteButton.innerText = "削除";
          deleteButton.addEventListener("click", () => deleteSgItem(sg.id));
          listItem.appendChild(deleteButton);
        }

        const todoList = document.createElement("ul");
        todoList.classList.add("todo-list");
        sg.todos.forEach(todo => {
          const todoItem = document.createElement("li");

          const todoCheckbox = document.createElement("input");
          todoCheckbox.type = "checkbox";
          todoCheckbox.checked = todo.completed;
          todoCheckbox.addEventListener("change", () => toggleTodoStatus(sg.id, todo.id));
          todoItem.appendChild(todoCheckbox);

          const todoText = document.createTextNode(todo.text);
          todoItem.appendChild(todoText);

          if (todo.completed) {
            const todoDeleteButton = document.createElement("button");
            todoDeleteButton.innerText = "削除";
            todoDeleteButton.addEventListener("click", () => deleteTodo(sg.id, todo.id));
            todoItem.appendChild(todoDeleteButton);
          }

          todoList.appendChild(todoItem);
        });

        listItem.appendChild(todoList);

        sgList.appendChild(listItem);
      });
    }

    // 詳細行動の完了状態をトグルする関数
    function toggleTodoStatus(sgId, todoId) {
      sgs = sgs.map(sg => {
        if (sg.id === sgId) {
          const todos = sg.todos.map(todo => {
            if (todo.id === todoId) {
              return {
                ...todo,
                completed: !todo.completed
              };
            }
            return todo;
          });

          return {
            ...sg,
            todos: todos
          };
        }
        return sg;
      });

      renderTodoList();
    }

    function sendDataToServlet() {
    	  const xhr = new XMLHttpRequest();
    	  xhr.open("POST", "YourServlet", true);
    	  xhr.setRequestHeader("Content-Type", "application/json");

    	  // レスポンス受信時の処理
    	  xhr.onreadystatechange = function() {
    	    if (xhr.readyState === XMLHttpRequest.DONE) {
    	      if (xhr.status === 200) {
    	        console.log("Data sent successfully!");
    	      } else {
    	        console.error("Failed to send data.");
    	      }
    	    }
    	  };


    	  // 送信するデータを作成
    	  const data = {
    	    sgs: sgs,
    	    lgs: lgs,
    	    year: currentYear,
    	    month: currentMonth
    	  };

    	  // JSON形式でデータを送信
    	  xhr.send(JSON.stringify(data));
    	}


  </script>
</body>
</html>
