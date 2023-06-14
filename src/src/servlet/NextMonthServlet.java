package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CalendarCounter;

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
		//MonthCounterを呼び出す(初期値は0)
		CalendarCounter cc = new CalendarCounter();
		int mc = cc.getMonthCounter();
		//翌月なので+1
		mc = mc + 1;
		//CalendarCounterに値を返す
		cc.setMonthCounter(mc);

		// リクエストスコープに保存
	    request.setAttribute("monthCounter", mc);

		// カレンダーサーブレットへフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Calendar.jsp");
		dispatcher.forward(request, response);
	}

}
