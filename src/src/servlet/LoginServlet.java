package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaysDAO;
import dao.IdpwDAO;
import model.Idpw;
import model.LoginUser;
import model.Result;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Login.jsp");
		dispatcher.forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得する
				request.setCharacterEncoding("UTF-8");
				String id = request.getParameter("NUMBER");
				String pw = request.getParameter("PW");

				int number=Integer.parseInt(id);


				// ログイン処理を行う
				IdpwDAO iDao = new IdpwDAO();
				if (iDao.isLoginOK(new Idpw(number, pw))) {	// ログイン成功
					String name=iDao.name(new Idpw(number, pw));
					DaysDAO dDao=new DaysDAO();
					int days=dDao.days(number);
					// セッションスコープにIDを格納する
					HttpSession session = request.getSession();
					session.setAttribute("number", new LoginUser(number,name,days));

					// ホームサーブレットにリダイレクトする
					response.sendRedirect("/amateur/ScheduleServlet");
				}
				else {									// ログイン失敗
					// リクエストスコープに、タイトル、メッセージ、戻り先を格納する
					request.setAttribute("result",
					new Result("ログイン失敗！", "IDまたはPWに間違いがあります。"));

					// 結果ページにフォワードする
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Login.jsp");
					dispatcher.forward(request, response);
	}

	}}
