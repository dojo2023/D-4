package servlet;
import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LgDAO;
import dao.SgDAO;
import dao.TodotbDAO;
import model.Lg;
import model.Sg;
import model.Todo;
@WebServlet("/GoalRegistServlet.java")
public class GoalRegistServlet extends HttpServlet {
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
	    //1.パラメータを取得

	    String year = request.getParameter("year");
	    String month = request.getParameter("month");
	    String lg = request.getParameter("lgs[text]");
	    String sg = request.getParameter("sgs[text]");
	    String day_s = request.getParameter("sgs[start]");
	    String day_e = request.getParameter("sgs[end]");
	    String todo = request.getParameter("todos[text]");



	    //1.スコープからNUMBERを取得

	    int number = Integer.parseInt(request.getParameter("NUMBER"));

	    //2.number,year,month,lgs[text]をLGOALに登録

	    LgDAO lgDao = new LgDAO();
	    Lg lgs = new Lg(number, year, month, lg);

	    //day_s, day_e, sgs[text]をSGOALに登録

	    SgDAO sgDao = new SgDAO();
	    Sg sgs = new Sg(number, month, day_s, day_e, sg);

	    //todos[text]をTODOTBに登録

	    TodotbDAO todotbDao = new TodotbDAO();
	    Todo todos = new Todo(number, month, day_s, day_e, todo);




	    if (lgDao.updateLg(lgs) && sgDao.updateSg(sgs) && todotbDao.updateTodo(todos)) {
	        // 登録成功時の処理
	    } else {
	        // 登録失敗時の処理
	    }

	    // 必要な場合はレスポンスを送信
	    response.setContentType("text/html");
	    response.getWriter().println("Data received successfully!");
	  }
	}
