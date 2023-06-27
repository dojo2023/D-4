package servlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TasktbDAO;
import model.LoginUser;
import model.Task;

/**
 * Servlet implementation class TaskLastMonthServlet
 */
@WebServlet("/TaskLastMonthServlet")
public class TaskLastDayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//セッションスコープの呼び出し
				HttpSession session = request.getSession();

				// ログインしていなかった場合、ログインページへフォワード
				if (session.getAttribute("number") == null) {
					response.sendRedirect("/amateur/LoginServlet");
					return;
				}
				LoginUser user=(LoginUser)session.getAttribute("number");
				int number=user.getNumber();
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
				//メモを取得するための引数を作る
				String memoDate = year + "-" + month + "-" + day;
				//taskを取得
				TasktbDAO bDao=new TasktbDAO();
				List<Task> task =bDao.task(number, memoDate);
				//リクエストスコープに保存
				request.setAttribute("task", task);
				request.setAttribute("displayday", day);
				request.setAttribute("displayMonth", month);
				request.setAttribute("displayYear", year);

				//タスク追加画面にフォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/TaskRegist.jsp");
				dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/bc/LoginServlet");
			return;
		}
		LoginUser user=(LoginUser)session.getAttribute("number");
		int number=user.getNumber();
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		//タスクの数を取得
		int num=Integer.parseInt(request.getParameter("length"));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");


		TasktbDAO bDao=new TasktbDAO();
		for(int i=0;i<num;i++) {
			bDao.updateTask(new Task(number,LocalDateTime.parse(request.getParameter("times_"+(i+1))).format(formatter),LocalDateTime.parse(request.getParameter("timee_"+(i+1))).format(formatter),request.getParameter("task_"+(i+1))));
		}
		if(!(request.getParameter("task0").equals(""))) {
		bDao.updateTask(new Task(number,LocalDateTime.parse(request.getParameter("times0")).format(formatter),LocalDateTime.parse(request.getParameter("timee0")).format(formatter),request.getParameter("task0")));
		}
		if(!(request.getParameter("task1").equals(""))) {
			bDao.updateTask(new Task(number,LocalDateTime.parse(request.getParameter("times1")).format(formatter),LocalDateTime.parse(request.getParameter("timee1")).format(formatter),request.getParameter("task1")));
			}
		if(!(request.getParameter("task2").equals(""))) {
			bDao.updateTask(new Task(number,LocalDateTime.parse(request.getParameter("times2")).format(formatter),LocalDateTime.parse(request.getParameter("timee2")).format(formatter),request.getParameter("task2")));
			}
		if(!(request.getParameter("task3").equals(""))) {
			bDao.updateTask(new Task(number,LocalDateTime.parse(request.getParameter("times3")).format(formatter),LocalDateTime.parse(request.getParameter("timee3")).format(formatter),request.getParameter("task3")));
			}
		if(!(request.getParameter("task4").equals(""))) {
			bDao.updateTask(new Task(number,LocalDateTime.parse(request.getParameter("times4")).format(formatter),LocalDateTime.parse(request.getParameter("timee4")).format(formatter),request.getParameter("task4")));
			}
		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("TaskRegistServlet");
		dispatcher.forward(request, response);
	}

}
