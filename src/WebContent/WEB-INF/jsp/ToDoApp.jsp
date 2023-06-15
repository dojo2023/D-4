<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>目標アプリ</title>
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

    .detail-list {
      margin-left: 15px;
    }
  </style>
</head>
<body>
  <h1>目標アプリ</h1>

  <input type="text" id="todoInput" placeholder="目標を入力してください">
  <button onclick="addTodo()">追加</button>

  <ul id="todoList"></ul>

  <div id="modal" class="modal">
    <div class="modal-content">
      <span class="close" onclick="closeModal()">&times;</span>
      <h2>詳細を追加</h2>
      <textarea id="detailInput" placeholder="詳細行動を入力してください"></textarea>
      <button onclick="saveDetail()">保存</button>
    </div>
  </div>
  <button onclick="sendDataToServlet()">データを送信</button>

  <script>
    // ToDoアイテムを格納する配列
    let todos = [];

    // 現在のToDoアイテムのID
    let currentTodoId = null;

    // ToDoアイテムを追加する関数
    function addTodo() {
      const input = document.getElementById("todoInput");
      const todoText = input.value.trim();

      if (todoText !== "") {
        const todo = {
          id: Date.now(),
          text: todoText,
          completed: false,
          details: []
        };

        todos.push(todo);
        input.value = "";

        renderTodoList();
      }
    }

    // ToDoアイテムを削除する関数
    function deleteTodoItem(todoId) {
      todos = todos.filter(todo => todo.id !== todoId);
      renderTodoList();
    }

    // ToDoアイテムの完了状態をトグルする関数
    function toggleTodoStatus(todoId) {
      todos = todos.map(todo => {
        if (todo.id === todoId) {
          return {
            ...todo,
            completed: !todo.completed
          };
        }
        return todo;
      });

      renderTodoList();
    }

    // モーダルウィンドウを表示する関数
    function openModal(todoId) {
      const modal = document.getElementById("modal");
      modal.style.display = "block";
      currentTodoId = todoId;
    }

    // モーダルウィンドウを閉じる関数
    function closeModal() {
      const modal = document.getElementById("modal");
      modal.style.display = "none";
      currentTodoId = null;
    }

    // 詳細行動を保存する関数
    function saveDetail() {
      const detailInput = document.getElementById("detailInput");
      const detailText = detailInput.value.trim();

      if (detailText !== "" && currentTodoId !== null) {
        const todo = todos.find(todo => todo.id === currentTodoId);
        todo.details.push({
          id: Date.now(),
          text: detailText,
          completed: false
        });
        detailInput.value = "";

        closeModal();
        renderTodoList();
      }
    }

    // 詳細行動を削除する関数
    function deleteDetail(todoId, detailId) {
      const todo = todos.find(todo => todo.id === todoId);
      todo.details = todo.details.filter(detail => detail.id !== detailId);
      renderTodoList();
    }

    // ToDoリストを描画する関数
    function renderTodoList() {
      const todoList = document.getElementById("todoList");
      todoList.innerHTML = "";

      todos.forEach(todo => {
        const listItem = document.createElement("li");

        const checkbox = document.createElement("input");
        checkbox.type = "checkbox";
        checkbox.checked = todo.completed;
        checkbox.addEventListener("change", () => toggleTodoStatus(todo.id));
        listItem.appendChild(checkbox);

        const todoText = document.createTextNode(todo.text);
        listItem.appendChild(todoText);

        const addButton = document.createElement("button");
        addButton.innerText = "詳細を追加";
        addButton.addEventListener("click", () => openModal(todo.id));
        listItem.appendChild(addButton);

        if (todo.completed) {
          const deleteButton = document.createElement("button");
          deleteButton.innerText = "削除";
          deleteButton.addEventListener("click", () => deleteTodoItem(todo.id));
          listItem.appendChild(deleteButton);
        }

        const detailList = document.createElement("ul");
        detailList.classList.add("detail-list");
        todo.details.forEach(detail => {
          const detailItem = document.createElement("li");

          const detailCheckbox = document.createElement("input");
          detailCheckbox.type = "checkbox";
          detailCheckbox.checked = detail.completed;
          detailCheckbox.addEventListener("change", () => toggleDetailStatus(todo.id, detail.id));
          detailItem.appendChild(detailCheckbox);

          const detailText = document.createTextNode(detail.text);
          detailItem.appendChild(detailText);

          if (detail.completed) {
            const detailDeleteButton = document.createElement("button");
            detailDeleteButton.innerText = "削除";
            detailDeleteButton.addEventListener("click", () => deleteDetail(todo.id, detail.id));
            detailItem.appendChild(detailDeleteButton);
          }

          detailList.appendChild(detailItem);
        });

        listItem.appendChild(detailList);

        todoList.appendChild(listItem);
      });
    }

    // 詳細行動の完了状態をトグルする関数
    function toggleDetailStatus(todoId, detailId) {
      todos = todos.map(todo => {
        if (todo.id === todoId) {
          const details = todo.details.map(detail => {
            if (detail.id === detailId) {
              return {
                ...detail,
                completed: !detail.completed
              };
            }
            return detail;
          });

          return {
            ...todo,
            details: details
          };
        }
        return todo;
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

    	  // JSON形式でデータを送信
    	  xhr.send(JSON.stringify(todos));
    	}


  </script>
</body>
</html>
