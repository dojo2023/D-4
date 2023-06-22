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
 * Servlet implementation class AchieveNextMonthServlet
 */
@WebServlet("/AchieveNextMonthServlet")
public class AchieveNextMonthServlet extends HttpServlet {
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
		// セッションを取得
        HttpSession session = request.getSession(true);
        // monthCounterの値をセッションから取得
        Integer mc = (Integer) session.getAttribute("monthCounter");
        //翌月なので+1
        mc = mc + 1;

      	//表示したい月の年月を取得
      	Calendar calendar = Calendar.getInstance();
      	calendar.add(Calendar.MONTH, mc);
      	int month = calendar.get(Calendar.MONTH) + 1;
      	int year = calendar.get(Calendar.YEAR);
		String displayDate = year + "-" + month + "-01";

		session.setAttribute("displayDate", displayDate);
		request.setAttribute("displayMonth", month);
		request.setAttribute("displayYear", year);

		//ログインしている人の管理番号を取得
		//Integer number = (Integer) session.getAttribute("管理番号の入った情報の名前");
		//TodoDAOを呼び出してすべての達成度を取得する
		TodotbDAO tdao = new TodotbDAO();
		AllA alla = tdao.achieve(1000, displayDate);
		request.setAttribute("a",alla);

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

		//達成度データをDAOに送る
		//セッションスコープからTodothDAO呼び出しに必要な情報を取得
		HttpSession session = request.getSession(true);
		//Integer id = (Integer)session.getAttribute("id");
		String displayDate = (String)session.getAttribute("displayDate");

		//TodoIDをどうにかして取得する
		TodotbDAO tdao = new TodotbDAO();
		AllA alla = tdao.achieve(1000, displayDate);
		int a = alla.getSgA().size();

		//Todoの達成度を更新
		int achieve;
		int todo;
		int i = 0;
		//ACHIEVEの値を配列に入れる
		while(i < a) {
			int b = alla.getSgA().get(i).getTodoA().size();
			int j = 0;
			while(j < b) {
					achieve = Integer.parseInt(request.getParameter("ACHIEVE" + i + "-" + j));
					todo =Integer.parseInt(request.getParameter("TODOID" + i + "-" + j));
					if(tdao.update(todo,achieve) == false) {
						response.setContentType("text/html");
						response.setCharacterEncoding("UTF-8");
						response.getWriter().println("データの受け取りに失敗しました");
						break;
						}
					j++;
				}
			i++;
		}


		// レスポンスの設定
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println("データの受け取りが完了しました");
		response.getWriter().println("<a href = /simpleBC/AchieveServlet >達成度に戻る</a>");

		//達成度入力ページへフォワード
		//RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Achieve.jsp");
		//dispatcher.forward(request, response);

	}

}