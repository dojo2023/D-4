package servlet;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TodotbDAO;
import model.AllA;

/**
 * Servlet implementation class CalendarServlet
 */
@WebServlet("/CalendarServlet")
public class CalendarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// セッションを取得
        HttpSession session = request.getSession(true);
        // monthCounterの値をセッションから取得
        Integer mc = (Integer)session.getAttribute("monthCounter");
        //monthCounterを初期値に戻す
		if( mc == null ) { //mcが存在しなかったときの処理
			mc = 0;
		}else {
			mc = 0;
		}
		//セッションスコープに保存
		session.setAttribute("monthCounter", mc);

		//表示したい月の年月を取得
		Calendar calendar = Calendar.getInstance();
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

		//ログインしている人の管理番号を取得
		//Integer number = (Integer) session.getAttribute("管理番号の入った情報の名前");
		//長期・短期目標、Todoと達成度を取得
		TodotbDAO tdao = new TodotbDAO();
		AllA alla = tdao.achieve(1000, displayDate);
		request.setAttribute("a",alla);

		// カレンダーへフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Calendar.jsp");
		dispatcher.forward(request, response);
	}

}
