package servlet;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TodotbDAO;
import model.AllA;
import model.LoginUser;

/**
 * Servlet implementation class NextMonthServlet
 */
@WebServlet("/NextMonthServlet")
public class NextMonthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// セッションを取得
        HHttpSession session = request.getSession(true);
		if (session.getAttribute("number") == null) {
			response.sendRedirect("/amateur/LoginServlet");
			return;
		}
        // monthCounterの値をセッションから取得
        Integer mc = (Integer) session.getAttribute("monthCounter");
		//翌月なので+1
		mc = mc + 1;

	    //表示したい月の年月を取得
	  	Calendar calendar = Calendar.getInstance();
	  	calendar.add(Calendar.MONTH, mc);
	  	int month = calendar.get(Calendar.MONTH) + 1;
	  	int year = calendar.get(Calendar.YEAR);
	  	String displayDate;
		if(month < 10) {
			displayDate = year + "-0" + month + "-01";
		}else {
			displayDate = year + "-" + month + "-01";
		}

	  	request.setAttribute("displayMonth", month);
	  	request.setAttribute("displayYear", year);

	    // セッションスコープに保存
	    session.setAttribute("monthCounter", mc);

	  	//ログインしている人の管理番号を取得
	    LoginUser user=(LoginUser)session.getAttribute("number");
		int number=user.getNumber();

		//長期・短期目標、Todoと達成度を取得
	    TodotbDAO tdao = new TodotbDAO();
	    AllA alla = tdao.achieve(number, displayDate);
	    request.setAttribute("a",alla);

		// カレンダーサーブレットへフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Calendar.jsp");
		dispatcher.forward(request, response);
	}

}
