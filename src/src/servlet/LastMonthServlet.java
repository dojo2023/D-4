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

/**
 * Servlet implementation class LastMonthServlet
 */
@WebServlet("/LastMonthServlet")
public class LastMonthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// セッションを取得
        HttpSession session = request.getSession(true);
        // monthCounterの値をセッションから取得
        Integer mc = (Integer) session.getAttribute("monthCounter");
		//先月なので-1
		mc = mc - 1;

		//表示したい月の年月を取得
		Calendar calendar = Calendar.getInstance();
	  	calendar.add(Calendar.MONTH, mc);
	  	int month = calendar.get(Calendar.MONTH) + 1;
	  	int year = calendar.get(Calendar.YEAR);

	  	//リクエストスコープに保存
	  	request.setAttribute("displayMonth", month);
	  	request.setAttribute("displayYear", year);

		// セッションスコープに保存
	    session.setAttribute("monthCounter", mc);

	    //ログインしている人の管理番号を取得
	  	//Integer number = (Integer) session.getAttribute("管理番号の入った情報の名前");
	  	//DAOを呼び出す
	  	//LgDao ldao = new LgDao();
	  	//長期目標を取得
	  	//String longGoal = ldao.lg(number, displayDate)//長期目標関係のデータを保持しているbeanのインスタンスを生成);
	  	//リクエストスコープに長期目標を保存
	  	//request.setAttribute("lg", longGoal);

		// カレンダーへフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Calendar.jsp");
		dispatcher.forward(request, response);
	}

}
