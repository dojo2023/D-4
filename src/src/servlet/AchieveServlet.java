package servlet;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LgDao;
import dao.SgDAO;
import dao.TodotbDAO;
import model.Sg;
import model.Todo;

/**
 * Servlet implementation class AchieveServlet
 */
@WebServlet("/AchieveServlet")
public class AchieveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ログインされていなかったときの処理
		/*HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/amateur/LoginServlet");
			return;
		}*/

		//長期目標、短期目標、Todo、達成度のデータを取得する
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
		LgDao ldao = new LgDao();
		//長期目標を取得
		String lg = ldao.lg(1000, displayDate);
		//リクエストスコープに長期目標を保存
		request.setAttribute("lg",lg);

		//短期目標を取得する
		SgDAO sdao = new SgDAO();
		List<Sg> sgList = sdao.sg(1000, displayDate);
		request.setAttribute("sgList",sgList);

		//Todoを取得する
		TodotbDAO tdao = new TodotbDAO();
		List<Todo> todoList = tdao.todo(1000, displayDate);
		request.setAttribute("todoList",todoList);

		//達成度入力ページへフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Achieve.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ログインされていなかったときの処理
		/*HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/amateur/LoginServlet");
			return;
		}*/


		//Todoと達成度をデータベースに送信する処理
		//Todoの数だけサーブレットの処理を増やさなくてはいけない


		//達成度入力ページへフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Achieve.jsp");
		dispatcher.forward(request, response);

	}

}
