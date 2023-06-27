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
		String tdId2_1 = request.getParameter("tdId2_1");
		String td2_2 = request.getParameter("td2_2");
		String tdId2_2 = request.getParameter("tdId2_2");
		String td2_3 = request.getParameter("td2_3");
		String tdId2_3 = request.getParameter("tdId2_3");
		String td2_4 = request.getParameter("td2_4");
		String tdId2_4 = request.getParameter("tdId2_4");
		String td2_5 = request.getParameter("td2_5");
		String tdId2_5 = request.getParameter("tdId2_5");

		//短期目標３
		String sg3 = request.getParameter("sg3");
		String day_s_3 = request.getParameter("day_s_3");
		String day_e_3 = request.getParameter("day_e_3");
		String sgId3 = request.getParameter("sgId3");
		//短期目標３のToDo
		String td3_1 = request.getParameter("td3_1");
		String tdId3_1 = request.getParameter("tdId3_1");
		String td3_2 = request.getParameter("td3_2");
		String tdId3_2 = request.getParameter("tdId3_2");
		String td3_3 = request.getParameter("td3_3");
		String tdId3_3 = request.getParameter("tdId3_3");
		String td3_4 = request.getParameter("td3_4");
		String tdId3_4 = request.getParameter("tdId3_4");
		String td3_5 = request.getParameter("td3_5");
		String tdId3_5 = request.getParameter("tdId3_5");

		//短期目標４
		String sg4 = request.getParameter("sg4");
		String day_s_4 = request.getParameter("day_s_4");
		String day_e_4 = request.getParameter("day_e_4");
		String sgId4 = request.getParameter("sgId4");
		//短期目標４のToDo
		String td4_1 = request.getParameter("td4_1");
		String tdId4_1 = request.getParameter("tdId4_1");
		String td4_2 = request.getParameter("td4_2");
		String tdId4_2 = request.getParameter("tdId4_2");
		String td4_3 = request.getParameter("td4_3");
		String tdId4_3 = request.getParameter("tdId4_3");
		String td4_4 = request.getParameter("td4_4");
		String tdId4_4 = request.getParameter("tdId4_4");
		String td4_5 = request.getParameter("td4_5");
		String tdId4_5 = request.getParameter("tdId4_5");

		//短期目標５
		String sg5 = request.getParameter("sg5");
		String day_s_5 = request.getParameter("day_s_5");
		String day_e_5 = request.getParameter("day_e_5");
		String sgId5 = request.getParameter("sgId5");
		//短期目標５のToDo
		String td5_1 = request.getParameter("td5_1");
		String tdId5_1 = request.getParameter("tdId5_1");
		String td5_2 = request.getParameter("td5_2");
		String tdId5_2 = request.getParameter("tdId5_2");
		String td5_3 = request.getParameter("td5_3");
		String tdId5_3 = request.getParameter("tdId5_3");
		String td5_4 = request.getParameter("td5_4");
		String tdId5_4 = request.getParameter("tdId5_4");
		String td5_5 = request.getParameter("td5_5");
		String tdId5_5 = request.getParameter("tdId5_5");

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
			if(!td1_1.equals("")) {
			System.out.println("短期目標１のToDo１: " + td1_1);

			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(number, Date, day_s_1, day_e_1, td1_1))) {
				System.out.println("成功");
			}
			}
		}else {
			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(Integer.parseInt(tdId1_1), Integer.parseInt(sgId1), td1_1))) {

			}
		}

		if (tdId1_2.equals("") || tdId1_2 == null) {
			if(!td1_2.equals("")) {
			System.out.println("短期目標１のToDo２: " + td1_2);

			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(number, Date, day_s_1, day_e_1, td1_2))) {
				System.out.println("成功");
			}
			}
		}else {
			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(Integer.parseInt(tdId1_2), Integer.parseInt(sgId1), td1_2))) {

			}
		}

		if (tdId1_3.equals("") || tdId1_3 == null) {
			if(!td1_3.equals("")) {
			System.out.println("短期目標１のToDo３: " + td1_3);

			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(number, Date, day_s_1, day_e_1, td1_3))) {
				System.out.println("成功");
			}
			}
		}else {
			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(Integer.parseInt(tdId1_3), Integer.parseInt(sgId1), td1_3))) {

			}
		}
		if (tdId1_4.equals("") || tdId1_4 == null) {
			if(!td1_4.equals("")) {
			System.out.println("短期目標１のToDo４: " + td1_4);

			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(number, Date, day_s_1, day_e_1, td1_4))) {
				System.out.println("成功");
			}
			}
		}else {
			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(Integer.parseInt(tdId1_4), Integer.parseInt(sgId1), td1_4))) {

			}
		}
		if (tdId1_5.equals("") || tdId1_5 == null) {
			if(!td1_5.equals("")) {
			System.out.println("短期目標１のToDo５: " + td1_5);

			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(number, Date, day_s_1, day_e_1, td1_5))) {
				System.out.println("成功");
			}
			}
		}else {
			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(Integer.parseInt(tdId1_5), Integer.parseInt(sgId1), td1_5))) {

			}
		}

		//短期目標２
		if (sgId2.equals("") || sgId2 == null) {
			if(!sg2.equals("")) {
			System.out.println("短期目標２: " + sg2);
			System.out.println(day_s_2);
			System.out.println(day_e_2);

			SgDAO sgDao = new SgDAO();
			if(sgDao.updateSg(new Sg(number, Date, day_s_2, day_e_2, sg2))) {
				System.out.println("成功");
			}
			}
		}else {
			SgDAO sgDao = new SgDAO();
			if(sgDao.updateSg(new Sg(Integer.parseInt(sgId2), day_s_2, day_e_2, sg2))) {
				System.out.println("成功");
			}
		}
		//短期目標２のToDo
		if (tdId2_1.equals("") || tdId2_1 == null) {
			if(!td2_1.equals("")) {
			System.out.println("短期目標２のToDo１: " + td2_1);

			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(number, Date, day_s_2, day_e_2, td2_1))) {
				System.out.println("成功");
			}
			}
		}else {
			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(Integer.parseInt(tdId2_1), Integer.parseInt(sgId2), td2_1))) {

			}
		}

		if (tdId2_2.equals("") || tdId2_2 == null) {
			if(!td2_2.equals("")) {
			System.out.println("短期目標２のToDo２: " + td2_2);

			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(number, Date, day_s_2, day_e_2, td2_2))) {
				System.out.println("成功");
			}
			}
		}else {
			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(Integer.parseInt(tdId2_2), Integer.parseInt(sgId2), td2_2))) {

			}
		}

		if (tdId2_3.equals("") || tdId2_3 == null) {
			if(!td2_3.equals("")) {
			System.out.println("短期目標２のToDo３: " + td2_3);

			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(number, Date, day_s_2, day_e_2, td2_3))) {
				System.out.println("成功");
			}
			}
		}else {
			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(Integer.parseInt(tdId2_3), Integer.parseInt(sgId2), td2_3))) {

			}
		}
		if (tdId2_4.equals("") || tdId2_4 == null) {
			if(!td2_4.equals("")) {
			System.out.println("短期目標２のToDo４: " + td2_4);

			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(number, Date, day_s_2, day_e_2, td2_4))) {
				System.out.println("成功");
			}
			}
		}else {
			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(Integer.parseInt(tdId2_4), Integer.parseInt(sgId2), td2_4))) {

			}
		}
		if (tdId2_5.equals("") || tdId2_5 == null) {
			if(!td2_5.equals("")) {
			System.out.println("短期目標２のToDo５: " + td2_5);

			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(number, Date, day_s_2, day_e_2, td2_5))) {
				System.out.println("成功");
			}
			}
		}else {
			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(Integer.parseInt(tdId2_5), Integer.parseInt(sgId2), td2_5))) {

			}
		}
		//短期目標３
		if (sgId3.equals("") || sgId3 == null) {
			if(!sg3.equals("")) {
			System.out.println("短期目標３: " + sg3);
			System.out.println(day_s_3);
			System.out.println(day_e_3);

			SgDAO sgDao = new SgDAO();
			if(sgDao.updateSg(new Sg(number, Date, day_s_3, day_e_3, sg3))) {
				System.out.println("成功");
			}
			}
		}else {
			SgDAO sgDao = new SgDAO();
			if(sgDao.updateSg(new Sg(Integer.parseInt(sgId3), day_s_3, day_e_3, sg3))) {
				System.out.println("成功");
			}
		}
		//短期目標３のToDo
		if (tdId3_1.equals("") || tdId3_1 == null) {
			if(!td3_1.equals("")) {
			System.out.println("短期目標３のToDo１: " + td3_1);

			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(number, Date, day_s_3, day_e_3, td3_1))) {
				System.out.println("成功");
			}
			}
		}else {
			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(Integer.parseInt(tdId3_1), Integer.parseInt(sgId3), td3_1))) {

			}
		}

		if (tdId3_2.equals("") || tdId3_2 == null) {
			if(!td3_2.equals("")) {
			System.out.println("短期目標３のToDo２: " + td3_2);

			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(number, Date, day_s_3, day_e_3, td3_2))) {
				System.out.println("成功");
			}
			}
		}else {
			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(Integer.parseInt(tdId3_2), Integer.parseInt(sgId3), td3_2))) {

			}
		}

		if (tdId3_3.equals("") || tdId3_3 == null) {
			if(!td3_3.equals("")) {
			System.out.println("短期目標３のToDo３: " + td3_3);

			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(number, Date, day_s_3, day_e_3, td3_3))) {
				System.out.println("成功");
			}
			}
		}else {
			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(Integer.parseInt(tdId3_3), Integer.parseInt(sgId3), td3_3))) {

			}
		}
		if (tdId3_4.equals("") || tdId3_4 == null) {
			if(!td3_4.equals("")) {
			System.out.println("短期目標３のToDo４: " + td3_4);

			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(number, Date, day_s_3, day_e_3, td3_4))) {
				System.out.println("成功");
			}
			}
		}else {
			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(Integer.parseInt(tdId3_4), Integer.parseInt(sgId3), td3_4))) {

			}
		}
		if (tdId3_5.equals("") || tdId3_5 == null) {
			if(!td3_5.equals("")) {
			System.out.println("短期目標３のToDo５: " + td3_5);

			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(number, Date, day_s_3, day_e_3, td3_5))) {
				System.out.println("成功");
			}
			}
		}else {
			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(Integer.parseInt(tdId3_5), Integer.parseInt(sgId3), td3_5))) {

			}
		}

		//短期目標４
		if (sgId4.equals("") || sgId4 == null) {
			if(!sg4.equals("")) {
			System.out.println("短期目標４: " + sg4);
			System.out.println(day_s_4);
			System.out.println(day_e_4);

			SgDAO sgDao = new SgDAO();
			if(sgDao.updateSg(new Sg(number, Date, day_s_4, day_e_4, sg4))) {
				System.out.println("成功");
			}
			}
		}else {
			SgDAO sgDao = new SgDAO();
			if(sgDao.updateSg(new Sg(Integer.parseInt(sgId4), day_s_4, day_e_4, sg4))) {
				System.out.println("成功");
			}
		}
		//短期目標４のToDo
		if (tdId4_1.equals("") || tdId4_1 == null) {
			if(!td4_1.equals("")) {
			System.out.println("短期目標４のToDo１: " + td4_1);

			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(number, Date, day_s_4, day_e_4, td4_4))) {
				System.out.println("成功");
			}
			}
		}else {
			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(Integer.parseInt(tdId4_1), Integer.parseInt(sgId4), td4_1))) {

			}
		}

		if (tdId4_2.equals("") || tdId4_2 == null) {
			if(!td4_2.equals("")) {
			System.out.println("短期目標４のToDo２: " + td4_2);

			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(number, Date, day_s_4, day_e_4, td4_2))) {
				System.out.println("成功");
			}
			}
		}else {
			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(Integer.parseInt(tdId4_2), Integer.parseInt(sgId4), td4_2))) {

			}
		}

		if (tdId4_3.equals("") || tdId4_3 == null) {
			if(!td4_3.equals("")) {
			System.out.println("短期目標４のToDo３: " + td4_3);

			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(number, Date, day_s_4, day_e_4, td4_3))) {
				System.out.println("成功");
			}
			}
		}else {
			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(Integer.parseInt(tdId4_3), Integer.parseInt(sgId4), td4_3))) {

			}
		}
		if (tdId4_4.equals("") || tdId4_4 == null) {
			if(!td4_4.equals("")) {
			System.out.println("短期目標４のToDo４: " + td4_4);

			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(number, Date, day_s_4, day_e_4, td4_4))) {
				System.out.println("成功");
			}
			}
		}else {
			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(Integer.parseInt(tdId4_4), Integer.parseInt(sgId4), td4_4))) {

			}
		}
		if (tdId4_5.equals("") || tdId4_5 == null) {
			if(!td4_5.equals("")) {
			System.out.println("短期目標４のToDo５: " + td4_5);

			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(number, Date, day_s_4, day_e_4, td4_5))) {
				System.out.println("成功");
			}
			}
		}else {
			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(Integer.parseInt(tdId4_5), Integer.parseInt(sgId4), td4_5))) {

			}
		}


		//短期目標５
		if (sgId5.equals("") || sgId5 == null) {
			if(!sg5.equals("")) {
			System.out.println("短期目標５: " + sg5);
			System.out.println(day_s_5);
			System.out.println(day_e_5);

			SgDAO sgDao = new SgDAO();
			if(sgDao.updateSg(new Sg(number, Date, day_s_5, day_e_5, sg5))) {
				System.out.println("成功");
			}
			}
		}else {
			SgDAO sgDao = new SgDAO();
			if(sgDao.updateSg(new Sg(Integer.parseInt(sgId5), day_s_5, day_e_5, sg5))) {
				System.out.println("成功");
			}
		}
		//短期目標５のToDo
		if (tdId5_1.equals("") || tdId5_1 == null) {
			if(!td5_1.equals("")) {
			System.out.println("短期目標５のToDo１: " + td5_1);

			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(number, Date, day_s_5, day_e_5, td5_1))) {
				System.out.println("成功");
			}
			}
		}else {
			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(Integer.parseInt(tdId5_1), Integer.parseInt(sgId5), td5_1))) {

			}
		}

		if (tdId5_2.equals("") || tdId5_2 == null) {
			if(!td5_2.equals("")) {
			System.out.println("短期目標５のToDo２: " + td5_2);

			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(number, Date, day_s_5, day_e_5, td5_2))) {
				System.out.println("成功");
			}
			}
		}else {
			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(Integer.parseInt(tdId5_2), Integer.parseInt(sgId5), td5_2))) {

			}
		}

		if (tdId5_3.equals("") || tdId5_3 == null) {
			if(!td5_3.equals("")) {
			System.out.println("短期目標５のToDo３: " + td5_3);

			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(number, Date, day_s_5, day_e_5, td5_3))) {
				System.out.println("成功");
			}
			}
		}else {
			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(Integer.parseInt(tdId5_3), Integer.parseInt(sgId5), td5_3))) {

			}
		}
		if (tdId5_5.equals("") || tdId5_4 == null) {
			if(!td5_4.equals("")) {
			System.out.println("短期目標５のToDo４: " + td5_4);

			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(number, Date, day_s_5, day_e_5, td5_4))) {
				System.out.println("成功");
			}
			}
		}else {
			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(Integer.parseInt(tdId5_4), Integer.parseInt(sgId5), td5_4))) {

			}
		}
		if (tdId5_5.equals("") || tdId5_5 == null) {
			if(!td5_5.equals("")) {
			System.out.println("短期目標５のToDo５: " + td5_5);

			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(number, Date, day_s_5, day_e_5, td5_5))) {
				System.out.println("成功");
			}
			}
		}else {
			TodotbDAO todotbDao = new TodotbDAO();
			if(todotbDao.updateTodo(new Todo(Integer.parseInt(tdId5_5), Integer.parseInt(sgId5), td5_5))) {

			}
		}
		//一日のスケジュールへ遷移
		response.sendRedirect("/amateur/ScheduleServlet");
	}

}
