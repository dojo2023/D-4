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

import dao.LgDAO;

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
        Integer mc = (Integer) session.getAttribute("monthCounter");
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
		String displayDate = year + "-" + month + "-01";

		request.setAttribute("displayMonth", month);
		request.setAttribute("displayYear", year);

		//ログインしている人の管理番号を取得
		//Integer number = (Integer) session.getAttribute("管理番号の入った情報の名前");
		//DAOを呼び出す
		LgDAO ldao = new LgDAO();
		//長期目標を取得
		String lg = ldao.lg(1000, displayDate);//長期目標関係のデータを保持しているbeanのインスタンスを生成);
		//リクエストスコープに長期目標を保存
		request.setAttribute("long",lg);

		// カレンダーへフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Calendar.jsp");
		dispatcher.forward(request, response);
	}

}
