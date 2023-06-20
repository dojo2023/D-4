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
import javax.servlet.http.HttpSession;

import dao.LgDAO;
import dao.MemotbDAO;
import dao.SgDAO;
import dao.TodotbDAO;
import model.Sg;
import model.Todo;

/**
 * Servlet implementation class ScheduleServlet
 */
@WebServlet("/ScheduleLastDayServlet")
public class ScheduleLastDayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//セッションスコープの呼び出し
		HttpSession session = request.getSession();

		// ログインしていなかった場合、ログインページへフォワード
		//if (session.getAttribute("number") == null) {
			//response.sendRedirect("/amateur/LoginServlet");
			//return;
		//}
		//一日ごと変更させるために年月日の情報を取得する
        // monthCounterの値をセッションから取得
        Integer dc = (Integer) session.getAttribute("dayCounter");
        //monthCounterを初期値に戻す
		if( dc == null ) { //mcが存在しなかったときの処理
			dc = 0;
		}else {
			dc = 0;
		}
		//先日なので-1
		dc = dc - 1;
		//セッションスコープに保存
		session.setAttribute("monthCounter", dc);

		//表示したい月の年月日を取得
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, dc);
		int day = calendar.get(Calendar.DATE);
		int month = calendar.get(Calendar.MONTH) + 1;
		int year = calendar.get(Calendar.YEAR);
		//長期・短期目標、Todoを取得するための引数を作る
		String displayDate = year + "-" + month + "-01";
		//メモを取得するための引数を作る
		String memoDate = year + "-" + month + "-" + day;

		//リクエストスコープに保存
		request.setAttribute("displayday", day);
		request.setAttribute("displayMonth", month);
		request.setAttribute("displayYear", year);

		//セッションスコープからログインIDを取得
		int id = (Integer) session.getAttribute("id");
		// 長期目標を取得
		LgDAO bDao = new LgDAO();
		String lg = bDao.lg(id,displayDate);

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("lg", lg);

		//検索処理を行う
		SgDAO CDao = new SgDAO();
		List<Sg>sgList = CDao.sg(id,displayDate);
		//検索結果をリクエストスコープに格納する
		request.setAttribute("sgList", sgList);

		//検索処理を行う
		TodotbDAO DDao = new TodotbDAO();
		List<Todo>TodoList = DDao.todo(id,displayDate);
				//検索結果をリクエストスコープに格納する
		request.setAttribute("TodoList",TodoList);

		//検索処理を行う
		MemotbDAO EDao = new MemotbDAO();
		String MemoList = EDao.memo(id,memoDate);
		//検索結果をリクエストスコープに格納する
		request.setAttribute("MemoList",MemoList);

		// メニューページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Schedule.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		/*if (session.getAttribute("number") == null) {
			response.sendRedirect("/amateur/LoginServlet");
			return;
		}
		int number=(Integer)session.getAttribute("number");
		String day="";

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String memo = request.getParameter("memo");
		// 検索処理を行う
		MemotbDAO bDao = new MemotbDAO();
		if(bDao.updateMemo(new Memo(number,day,memo))) {
			// 検索結果をリクエストスコープに格納する
			request.setAttribute("memo", memo);

			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Scedule.jsp");
			dispatcher.forward(request, response);
		}*/



	  }
	}