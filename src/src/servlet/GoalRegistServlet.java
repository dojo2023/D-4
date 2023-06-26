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

import dao.LgDAO;
import dao.SgDAO;
import dao.TodotbDAO;
import model.AllA;
import model.Lg;
import model.Sg;
import model.Todo;

@WebServlet("/GoalRegistServlet")
public class GoalRegistServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		//初めにページ遷移したときの処理
		// セッションを取得
		HttpSession session = request.getSession(true);

		// monthCounterの値をセッションから取得
		Integer mc = (Integer) session.getAttribute("monthCounter");
		//monthCounterを初期値に戻す
		if (mc == null) { //mcが存在しなかったときの処理
			mc = 0;
		} else {
			mc = 0;
		}
		//セッションスコープに保存
		session.setAttribute("monthCounter", mc);
		//表示したい月の年月を取得
		Calendar calendar = Calendar.getInstance();
		int month = calendar.get(Calendar.MONTH) + 1;
		int year = calendar.get(Calendar.YEAR);
		String displayDate = year + "-" + month + "-01";

		request.setAttribute("displayMonth", month);
		request.setAttribute("displayYear", year);

		//ログインしている人の管理番号を取得
		//Integer id = (Integer) session.getAttribute("id");

		//↓これ以降に表示するために取得したい情報を書いてください↓


		TodotbDAO tdao = new TodotbDAO();
		AllA alla = tdao.achieve(1000, displayDate);
		request.setAttribute("a",alla);
/*
		//LGのデータを取得
		LgDAO lgDao = new LgDAO();
		List<Lg> lgList = lgDao.lg(number, displayDate);

		//スコープに格納
		request.setAttribute("lgList", lgList);

		//SGのデータを取得
		SgDAO sgDao = new SgDAO();
		List<Sg> sgList = sgDao.sg(number, displayDate);

		//スコープに格納
		request.setAttribute("sgList", sgList);

		//ToDoのデータを取得
		TodotbDAO todotbDao = new TodotbDAO();
		List<Todo> todoList = todotbDao.todo(number, displayDate);

		//スコープに格納
		request.setAttribute("todoList", todoList);
*/

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/GoalRegist.jsp");
		dispatcher.forward(request, response);


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		//送信したい月の年月を取得
		Calendar calendar = Calendar.getInstance();
		String month = String.valueOf(calendar.get(Calendar.MONTH) + 1);
		String year = String.valueOf(calendar.get(Calendar.YEAR));
		//長期目標登録のために送る月日を作成
		String Date = year + "-" + month + "-01";

		//スコープからNUMBERを取得
		//int number = Integer.parseInt(request.getParameter("NUMBER"));
		int number=1000;
		// フォームデータの受け取り
		// 長期目標
		String lg = request.getParameter("lg");

		// 短期目標１
		String sg1 = request.getParameter("sg1");
		String day_s_1 = request.getParameter("day_s_1");
		String day_e_1 = request.getParameter("day_e_1");
		String sgId1 = request.getParameter("sgId1");
		// 短期目標１のToDo
		String td1_1 = request.getParameter("td1_1");
		String tdId1_1 = request.getParameter("tdId1_1");
		String td1_2 = request.getParameter("td1_2");
		String tdId1_2 = request.getParameter("tdId1_2");
		String td1_3 = request.getParameter("td1_3");
		String tdId1_3 = request.getParameter("tdId1_3");
		String td1_4 = request.getParameter("td1_4");
		String tdId1_4 = request.getParameter("tdId1_4");
		String td1_5 = request.getParameter("td1_5");
		String tdId1_5 = request.getParameter("tdId1_5");

		//短期目標２
		String sg2 = request.getParameter("sg2");
		String day_s_2 = request.getParameter("day_s_2");
		String day_e_2 = request.getParameter("day_e_2");
		String sgId2 = request.getParameter("sgId2");
		//短期目標２のToDo
		String td2_1 = request.getParameter("td2_1");
		String td2_2 = request.getParameter("td2_2");
		String td2_3 = request.getParameter("td2_3");
		String td2_4 = request.getParameter("td2_4");
		String td2_5 = request.getParameter("td2_5");

		//短期目標３
		String sg3 = request.getParameter("sg3");
		String day_s_3 = request.getParameter("day_s_3");
		String day_e_3 = request.getParameter("day_e_3");
		//短期目標３のToDo
		String td3_1 = request.getParameter("td3_1");
		String td3_2 = request.getParameter("td3_2");
		String td3_3 = request.getParameter("td3_3");
		String td3_4 = request.getParameter("td3_4");
		String td3_5 = request.getParameter("td3_5");

		//短期目標４
		String sg4 = request.getParameter("sg4");
		String day_s_4 = request.getParameter("day_s_4");
		String day_e_4 = request.getParameter("day_e_4");
		//短期目標４のToDo
		String td4_1 = request.getParameter("td4_1");
		String td4_2 = request.getParameter("td4_2");
		String td4_3 = request.getParameter("td4_3");
		String td4_4 = request.getParameter("td4_4");
		String td4_5 = request.getParameter("td4_5");

		//短期目標５
		String sg5 = request.getParameter("sg5");
		String day_s_5 = request.getParameter("day_s_5");
		String day_e_5 = request.getParameter("day_e_5");
		//短期目標５のToDo
		String td5_1 = request.getParameter("td5_1");
		String td5_2 = request.getParameter("td5_2");
		String td5_3 = request.getParameter("td5_3");
		String td5_4 = request.getParameter("td5_4");
		String td5_5 = request.getParameter("td5_5");

		//nullチェック（lg sg td）
		// 受け取ったデータの表示
		//データの処理


		//長期目標
		if (lg != null && lg != "") {
			System.out.println("長期目標: " + lg);

			//number, year, month, lgをLGOALに登録

			LgDAO lgDao = new LgDAO();
			if(lgDao.updateLg(new Lg(number, Date, lg))) {
				System.out.println("成功");
			}

		}
		//短期目標１
		if (sgId1.equals("") || sgId1 == null) {
			System.out.println("短期目標１: " + sg1);
			System.out.println(day_s_1);
			System.out.println(day_e_1);

			SgDAO sgDao = new SgDAO();
			if(sgDao.updateSg(new Sg(number, Date, day_s_1, day_e_1, sg1))) {
				System.out.println("成功");
			}
		}else {
			SgDAO sgDao = new SgDAO();
			if(sgDao.updateSg(new Sg(Integer.parseInt(sgId1), day_s_1, day_e_1, sg1))) {
				System.out.println("成功");
			}
		}
		//短期目標１のToDo
		if (tdId1_1.equals("") || tdId1_1 == null) {
			System.out.println("短期目標１のToDo１: " + td1_1);

			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(number, Date, day_s_1, day_e_1, td1_1))) {
				System.out.println("成功");
			}
		}else {
			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(Integer.parseInt(tdId1_1), Integer.parseInt(sgId1), td1_1))) {

			}
		}
		if (tdId1_2.equals("") || tdId1_2 == null) {
			System.out.println("短期目標１のToDo２: " + td1_2);

			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(number, Date, day_s_1, day_e_1, td1_2))) {
				System.out.println("成功");
			}
		}else {
			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(Integer.parseInt(tdId1_2), Integer.parseInt(sgId1), td1_2))) {

			}
		}
		if (tdId1_3.equals("") || tdId1_3 == null) {
			System.out.println("短期目標１のToDo３: " + td1_3);

			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(number, Date, day_s_1, day_e_1, td1_3))) {
				System.out.println("成功");
			}
		}else {
			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(Integer.parseInt(tdId1_3), Integer.parseInt(sgId1), td1_3))) {

			}
		}
		if (tdId1_4.equals("") || tdId1_4 == null) {
			System.out.println("短期目標１のToDo４: " + td1_4);

			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(number, Date, day_s_1, day_e_1, td1_4))) {
				System.out.println("成功");
			}
		}else {
			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(Integer.parseInt(tdId1_4), Integer.parseInt(sgId1), td1_4))) {

			}
		}
		if (tdId1_5.equals("") || tdId1_5 == null) {
			System.out.println("短期目標１のToDo５: " + td1_5);

			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(number, Date, day_s_1, day_e_1, td1_5))) {
				System.out.println("成功");
			}
		}else {
			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(Integer.parseInt(tdId1_5), Integer.parseInt(sgId1), td1_5))) {

			}
		}

		//短期目標２
		if (sgId2.equals("") || sgId2 == null) {
			System.out.println("短期目標２: " + sg2);
			System.out.println(day_s_2);
			System.out.println(day_e_2);

			SgDAO sgDao = new SgDAO();
			if(sgDao.updateSg(new Sg(number, Date, day_s_2, day_e_2, sg2))) {
				System.out.println("成功");
			}
		}else {
			SgDAO sgDao = new SgDAO();
			if(sgDao.updateSg(new Sg(Integer.parseInt(sgId2), day_s_2, day_e_2, sg2))) {
				System.out.println("成功");
			}
		}
		//短期目標２のToDo
		if (td2_1 != null && td2_1 != "") {
			System.out.println("短期目標２のToDo1: " + td2_1);

			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(number, Date, day_s_2, day_e_2, td2_1))) {
				System.out.println("成功");
			}
		}
		if (td2_2 != null && td2_2 != "") {
			System.out.println("短期目標２のToDo2: " + td2_2);

			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(number, Date, day_s_2, day_e_2, td2_2))) {
				System.out.println("成功");
			}
		}
		if (td2_3 != null && td2_3 != "") {
			System.out.println("短期目標２のToDo3: " + td2_3);

			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(number, Date, day_s_2, day_e_2, td2_3))) {
				System.out.println("成功");
			}
		}
		if (td2_4 != null && td2_4 != "") {
			System.out.println("短期目標２のToDo4: " + td2_4);

			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(number, Date, day_s_2, day_e_2, td2_4))) {
				System.out.println("成功");
			}
		}
		if (td2_5 != null && td2_5 != "") {
			System.out.println("短期目標２のToDo5: " + td2_5);

			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(number, Date, day_s_2, day_e_2, td2_5))) {
				System.out.println("成功");
			}
		}
		//短期目標３
		if (sg3 != null && sg3 != "") {
			System.out.println("短期目標３: " + sg3);

			SgDAO sgDao = new SgDAO();
			if(sgDao.updateSg(new Sg(number, Date, day_s_3, day_e_3, sg3))) {
				System.out.println("成功");
			}

		}
		//短期目標３のToDo
		if (td3_1 != null && td3_1 != "") {
			System.out.println("短期目標３のToDo1: " + td3_1);

			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(number, Date, day_s_3, day_e_3, td3_1))) {
				System.out.println("成功");
			}
		}
		if (td3_2 != null && td3_2 != "") {
			System.out.println("短期目標３のToDo2: " + td3_2);

			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(number, Date, day_s_3, day_e_3, td3_2))) {
				System.out.println("成功");
			}
		}
		if (td3_3 != null && td3_3 != "") {
			System.out.println("短期目標３のToDo3: " + td3_3);

			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(number, Date, day_s_3, day_e_3, td3_3))) {
				System.out.println("成功");
			}
		}
		if (td3_4 != null && td3_4 != "") {
			System.out.println("短期目標３のToDo4: " + td3_4);

			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(number, Date, day_s_3, day_e_3, td3_4))) {
				System.out.println("成功");
			}
		}
		if (td3_5 != null && td3_5 != "") {
			System.out.println("短期目標３のToDo5: " + td3_5);

			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(number, Date, day_s_3, day_e_3, td3_5))) {
				System.out.println("成功");
			}
		}

		//短期目標４
		if (sg4 != null && sg4 != "") {
			System.out.println("短期目標４: " + sg4);

			SgDAO sgDao = new SgDAO();
			if(sgDao.updateSg(new Sg(number, Date, day_s_4, day_e_4, sg4))) {
				System.out.println("成功");
			}

		}
		//短期目標４のToDo
		if (td4_1 != null && td4_1 != "") {
			System.out.println("短期目標４のToDo1: " + td4_1);

			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(number, Date, day_s_4, day_e_4, td4_1))) {
				System.out.println("成功");
			}
		}
		if (td4_2 != null && td4_2 != "") {
			System.out.println("短期目標４のToDo2: " + td4_2);

			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(number, Date, day_s_4, day_e_4, td4_2))) {
				System.out.println("成功");
			}
		}
		if (td4_3 != null && td4_3 != "") {
			System.out.println("短期目標４のToDo3: " + td4_3);

			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(number, Date, day_s_4, day_e_4, td4_3))) {
				System.out.println("成功");
			}
		}
		if (td4_4 != null && td4_4 != "") {
			System.out.println("短期目標４のToDo4: " + td4_4);

			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(number, Date, day_s_4, day_e_4, td4_4))) {
				System.out.println("成功");
			}
		}
		if (td4_5 != null && td4_5 != "") {
			System.out.println("短期目標４のToDo5: " + td4_5);

			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(number, Date, day_s_4, day_e_4, td4_5))) {
				System.out.println("成功");
			}
		}

		//短期目標５
		if (sg5 != null && sg5 != "") {
			System.out.println("短期目標５: " + sg5);

			SgDAO sgDao = new SgDAO();
			if(sgDao.updateSg(new Sg(number, Date, day_s_5, day_e_5, sg5))) {
				System.out.println("成功");
			}

		}
		//短期目標５のToDo
		if (td5_1 != null && td5_1 != "") {
			System.out.println("短期目標５のToDo1: " + td5_1);

			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(number, Date, day_s_5, day_e_5, td5_1))) {
				System.out.println("成功");
			}
		}
		if (td5_2 != null && td5_2 != "") {
			System.out.println("短期目標５のToDo2: " + td5_2);

			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(number, Date, day_s_5, day_e_5, td5_2))) {
				System.out.println("成功");
			}
		}
		if (td5_3 != null && td5_3 != "") {
			System.out.println("短期目標５のToDo3: " + td5_3);

			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(number, Date, day_s_5, day_e_5, td5_3))) {
				System.out.println("成功");
			}
		}
		if (td5_4 != null && td5_4 != "") {
			System.out.println("短期目標５のToDo4: " + td5_4);

			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(number, Date, day_s_5, day_e_5, td5_4))) {
				System.out.println("成功");
			}
		}
		if (td5_5 != null && td5_5 != "") {
			System.out.println("短期目標５のToDo5: " + td5_5);

			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(number, Date, day_s_5, day_e_5, td5_5))) {
				System.out.println("成功");
			}
		}
		// 他の処理を追加することも可能
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Achieve.jsp");
		dispatcher.forward(request, response);
		// レスポンスの設定
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println("データの受け取りが完了しました");
	}

}
