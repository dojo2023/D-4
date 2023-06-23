package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemotbDAO;
import dao.TasktbDAO;
import dao.TodotbDAO;
import model.AllA;
import model.Memo;

/**
 * Servlet implementation class ScheduleServlet
 */
@WebServlet("/ScheduleNextDayServlet")
public class ScheduleNextDayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//セッションスコープの呼び出し
		HttpSession session = request.getSession();

		// ログインしていなかった場合、ログインページへフォワード
		/*if (session.getAttribute("number") == null) {
			response.sendRedirect("/amateur/LoginServlet");
			return;
		}*/
		//一日ごと変更させるために年月日の情報を取得する
        // dayCounterの値をセッションから取得
        Integer dc = (Integer) session.getAttribute("dayCounter");
		//翌日なので+1
		dc = dc + 1;

		//表示したい月の年月日を取得
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, dc);
		int day = calendar.get(Calendar.DATE);
		int month = calendar.get(Calendar.MONTH) + 1;
		int year = calendar.get(Calendar.YEAR);
		//長期・短期目標、Todoを取得するための引数を作る
		String displayDate = year + "-" + month + "-01";
		//メモとタスクを取得するための引数を作る
		String tmeDate = year + "-" + month + "-" + day;

		//リクエストスコープに保存
		request.setAttribute("displayday", day);
		request.setAttribute("displayMonth", month);
		request.setAttribute("displayYear", year);

		//セッションスコープに保存
		session.setAttribute("dayCounter", dc);

		//セッションスコープからログインIDを取得
				//int id = (Integer) session.getAttribute("id");

				//長期・短期目標、Todoと達成度を取得
				TodotbDAO tdao = new TodotbDAO();
				AllA alla = tdao.achieve(1000, displayDate);
				request.setAttribute("a",alla);

				//タスクを取得
				TasktbDAO tDao = new TasktbDAO();
				request.setAttribute("taskL",tDao.task(1000, tmeDate));

				//メモを取得
				MemotbDAO mDao = new MemotbDAO();
				String memo = mDao.memo(1000,tmeDate);
				request.setAttribute("memo",memo);

				//表示日だけに関わる短期目標とTodoを取り出すための処理
				//String型からDate型に変換するフォーマットを作成
				try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				int[] sgId = new int[alla.getSgA().size()];

				//表示月の短期目標の開始日と終了日、表示日の日付を比較
				for(int i = 0; i < (alla.getSgA()).size(); i++) {
					String start = alla.getSgA().get(i).getDay_s();
					String end = alla.getSgA().get(i).getDay_e();
					int s = sdf.parse(tmeDate).compareTo(sdf.parse(start));
					int e = sdf.parse(tmeDate).compareTo(sdf.parse(end));

					if(s >= 0 && e <= 0) {
							sgId[i] = alla.getSgA().get(i).getSgId();
						}else {
							sgId[i] = 0;
						}
					}
					//スコープに短期目標のIDが入った配列をセット
					request.setAttribute("sgId",sgId);

				}catch(ParseException err){
					err.printStackTrace();
				}

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


