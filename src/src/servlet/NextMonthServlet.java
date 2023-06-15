package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        HttpSession session = request.getSession(true);
        // monthCounterの値をセッションから取得
        Integer mc = (Integer) session.getAttribute("monthCounter");
		//翌月なので+1
		mc = mc + 1;
		// リクエストスコープに保存
	    session.setAttribute("monthCounter", mc);

		// カレンダーサーブレットへフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Calendar.jsp");
		dispatcher.forward(request, response);
	}

}
