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

import dao.TasktbDAO;
import model.LoginUser;
import model.Task;

/**
 * Servlet implementation class TaskRegistServlet
 */
@WebServlet("/TaskRegistServlet")
public class TaskRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//セッションスコープの呼び出し
		HttpSession session = request.getSession(true);

		// ログインしていなかった場合、ログインページへフォワード
		if (session.getAttribute("number") == null) {
				response.sendRedirect("/amateur/LoginServlet");
					return;
			}
		LoginUser user=(LoginUser)session.getAttribute("number");
		int number=user.getNumber();
		//一日ごと変更させるために年月日の情報を取得する
        Integer dc = (Integer) session.getAttribute("dayCounter");
        //dayCounterを初期値に戻す
		if( dc == null ) { //mcが存在しなかったときの処理
			dc = 0;
		}else {
			dc = 0;
		}
		//セッションスコープに保存
		session.setAttribute("dayCounter", dc);

		//表示したい月の年月日を取得
		Calendar calendar = Calendar.getInstance();
		int day = calendar.get(Calendar.DATE);
		int month = calendar.get(Calendar.MONTH) + 1;
		int year = calendar.get(Calendar.YEAR);
		//メモを取得するための引数を作る
		String tmeDate;

		if(month < 10) {
			tmeDate = year + "-0" + month + "-" + day;
		}else {
			tmeDate = year + "-" + month + "-" + day;
		}

		//taskを取得
		TasktbDAO bDao=new TasktbDAO();
		List<Task> task =bDao.task(number, tmeDate);
		for(int i=0;i<task.size();i++) {
			task.set(i,new Task(number,task.get(i).getHour_s().substring(11,16),task.get(i).getHour_e().substring(11,16),task.get(i).getTask()));
		}
		//リクエストスコープに保存
		request.setAttribute("task", task);
		request.setAttribute("displayday", day);
		request.setAttribute("displayMonth", month);
		request.setAttribute("displayYear", year);
		request.setAttribute("tmeDate", tmeDate);



		//タスク追加画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/TaskRegist.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
				HttpSession session = request.getSession();
				if (session.getAttribute("number") == null) {
					response.sendRedirect("/amateur/LoginServlet");
					return;
				}
				LoginUser user=(LoginUser)session.getAttribute("number");
				int number=user.getNumber();
				// リクエストパラメータを取得する
				request.setCharacterEncoding("UTF-8");
				//タスクの数を取得
				int num=Integer.parseInt(request.getParameter("length"));
				String year=request.getParameter("year");
				String month=request.getParameter("month");
				String day=request.getParameter("day");
				int j=Integer.parseInt(month);
				String tmeDate;

				if(j < 10) {
					tmeDate = year + "-0" + month + "-" + day+" ";
				}else {
					tmeDate = year + "-" + month + "-" + day+" ";
				}


				TasktbDAO bDao=new TasktbDAO();
				for(int i=0;i<num;i++) {
					bDao.updateTask(new Task(number,tmeDate+request.getParameter("times_"+(i+1)),tmeDate+request.getParameter("timee_"+(i+1)),request.getParameter("task_"+(i+1))));
				}
				if(!(request.getParameter("task0").equals(""))) {
				bDao.updateTask(new Task(number,tmeDate+request.getParameter("times0"),tmeDate+request.getParameter("timee0"),request.getParameter("task0")));
				}
				if(!(request.getParameter("task1").equals(""))) {
					bDao.updateTask(new Task(number,tmeDate+request.getParameter("times1"),tmeDate+request.getParameter("timee1"),request.getParameter("task1")));
					}
				if(!(request.getParameter("task2").equals(""))) {
					bDao.updateTask(new Task(number,tmeDate+request.getParameter("times2"),tmeDate+request.getParameter("timee2"),request.getParameter("task2")));
					}
				if(!(request.getParameter("task3").equals(""))) {
					bDao.updateTask(new Task(number,tmeDate+request.getParameter("times3"),tmeDate+request.getParameter("timee3"),request.getParameter("task3")));
					}
				if(!(request.getParameter("task4").equals(""))) {
					bDao.updateTask(new Task(number,tmeDate+request.getParameter("times4"),tmeDate+request.getParameter("timee4"),request.getParameter("task4")));
					}
				// 結果ページにフォワードする
				response.sendRedirect("/amateur/ScheduleServlet");
	}

}
