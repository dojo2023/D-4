<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>ホームページ</title>

    <!-- リンクスペース -->
    <link rel="stylesheet" href="home.css">

</head>

<body>
<main>
    <h1 class="logo"><img src="" alt="【ロゴ】">あなただけの秘書</h1>
    <!-- ロゴ画像とアプリ名 -->
    <nav><!-- アプリ名の横にボタン配置 -->
        <ul>
            <button class="btn" onclick="/amateur/LoginServlet">ログイン</button>
            <button class="btn" onclick="/amateur/AccountServlet">新規登録</button>
        </ul>
    </nav>
    <hr>
    <!-- 宣伝のＰＲ部分 -->
    <div class="side">
        <div class="first">
            <h2>日々の業務を一括管理<br>ええええ</h2>
            <p> ToDoとタスク、日々の目標を設定可能<br>
                スケジュールを一目で確認できる</p>
        </div>
        <!-- 画像3枚予定、宣伝の横に配置 -->

        <div class="sampleimages">
            <img src="" alt="内容画像1" class="img_01"> <!--width="300" height="200"-->
            <img src="" alt="内容画像2" class="img_02">
            <img src="" alt="内容画像3" class="img_03">
        </div>
    </div>
    <div class="second">
        <h3>仕様説明</h3>
        <h4>スケジュールページ</h4>
        <p>一日のスケジュールを把握</p>
        <h4>カレンダーページ</h4>
        <p>月単位で予定を把握</p>
        <h4>目標設定</h4>
        <p>目標を設定できる</p>
        <h4>ToDoやタスク設定</h4>
        <p>ToDoとタスクを分けて管理</p>
    </div>
    <h3>動画</h3>



    <div class="new">
        <button class="btn" onclick="/amateur/AccountServlet">新規登録</button>

        <script src="home.js"></script>
    </div>
</main>
</body>

</html>