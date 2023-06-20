package servlet;

import java.io.IOException;
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
import model.Memo;
import model.Sg;
import model.Todo;

/**
 * Servlet implementation class ScheduleServlet
 */
@WebServlet("/ScheduleServlet")
public class ScheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if (session.getAttribute("number") == null) {
			response.sendRedirect("/amateur/LoginServlet");
			return;
		}

		//名刺全部取得する
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		 int number=0;
		 String month="";
		 int achieve=0;
		 String day="";

		// 検索処理を行う
		LgDAO bDao = new LgDAO();
		String lg = bDao.lg(number,month);

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("lg", lg);

		//検索処理を行う
		SgDAO CDao = new SgDAO();
		List<Sg>sgList = CDao.sg(number,month);
		//検索結果をリクエストスコープに格納する
		request.setAttribute("sgList", sgList);

		//検索処理を行う
		TodotbDAO DDao = new TodotbDAO();
		List<Todo>TodoList = DDao.todo(number,month);
				//検索結果をリクエストスコープに格納する
		request.setAttribute("TodoList",TodoList);

		//検索処理を行う
		MemotbDAO EDao = new MemotbDAO();
		String MemoList = EDao.memo(number,day);
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
		if (session.getAttribute("number") == null) {
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
		}



	}
	}


