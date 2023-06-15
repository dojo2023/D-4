package servlet;
import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/YourServlet")
public class YourServlet extends HttpServlet {
	  protected void doPost(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {
//文字化けを防ぐために必ず入れるメソッド
		  request.setCharacterEncoding("UTF-8");

	    StringBuilder jsonPayload = new StringBuilder();
	    BufferedReader reader = request.getReader();

	    // 受け取ったJSONデータを文字列として結合
	    String line;
	    while ((line = reader.readLine()) != null) {
	      jsonPayload.append(line);
	    }

	    // JSONデータの処理
	    // ...
	    System.out.println("Received JSON data:");
	    System.out.println(jsonPayload.toString());
	    // 必要な場合はレスポンスを送信
	    response.setContentType("text/html");
	    response.getWriter().println("Data received successfully!");
	  }
	}
