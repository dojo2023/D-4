//2023-06-23 h13:30
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

import dao.DaysDAO;
import dao.IdpwDAO;
import model.LoginUser;
import model.Result;
/**
 * Servlet implementation class AccountServlet
 */
@WebServlet("/AccountServlet")
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Account.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得する
				request.setCharacterEncoding("UTF-8");
				String name = request.getParameter("NAME");
				String pw1 = request.getParameter("PW1");
				String pw2 = request.getParameter("PW2");
				if(pw1.equals(pw2)) {
					//パスワードが一致している場合
				// 新規登録を行う
				IdpwDAO iDao = new IdpwDAO();
				int number=iDao.account(name, pw1); // 新規登録成功
				DaysDAO dDao=new DaysDAO();
				Calendar calendar = Calendar.getInstance();
				calendar.add(Calendar.DATE, 0);
				int day = calendar.get(Calendar.DATE);
				int month = calendar.get(Calendar.MONTH) + 1;
				int year = calendar.get(Calendar.YEAR);
				//メモを取得するための引数を作る
				String memoDate = year + "-" + month + "-" + day;
				if(dDao.insert(number,memoDate)) {
				int days=dDao.days(number);
				// セッションスコープにIDを格納する
				HttpSession session = request.getSession();
				session.setAttribute("number", new LoginUser(number,name,days));
					// 結果ページにフォワードする
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/accountID.jsp");
					dispatcher.forward(request, response);
				}
				}else {//パスワードが間違っている場合
					request.setAttribute("result",
							new Result("", "パスワードが一致していません"));

					// 結果ページにフォワードする
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Account.jsp");
					dispatcher.forward(request, response);
				}
	}

}
