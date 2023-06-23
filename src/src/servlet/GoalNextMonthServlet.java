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

/**
 * Servlet implementation class GoalNextMonthServlet
 */
@WebServlet("/GoalNextMonthServlet")
public class GoalNextMonthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


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

	  	request.setAttribute("displayMonth", month);
	  	request.setAttribute("displayYear", year);

	    // セッションスコープに保存
	    session.setAttribute("monthCounter", mc);

	    //ログインしている人の管理番号を取得
	  	//Integer id = (Integer) session.getAttribute("id");

	  	//↓これ以降に表示するために取得したい情報を書いてください↓

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/GoalRegist.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



		// セッションを取得
        HttpSession session = request.getSession(true);
        // monthCounterの値をセッションから取得
        Integer mc = (Integer) session.getAttribute("monthCounter");

		//送信したい月の年月を取得
		Calendar calendar = Calendar.getInstance();
	  	calendar.add(Calendar.MONTH, mc);
	  	int month = calendar.get(Calendar.MONTH) + 1;
	  	int year = calendar.get(Calendar.YEAR);
	  	//長期目標に送るための月日を作成
	  	String Date = year + "-" + month + "-01";

		// フォームデータの受け取り
				// 長期目標
				String lg = request.getParameter("lg");

				// 短期目標１
				String sg1 = request.getParameter("sg1");
				String day_s_1 = request.getParameter("day_s_1");
				String day_e_1 = request.getParameter("day_e_1");
				// 短期目標１のToDo
				String td1_1 = request.getParameter("td1_1");
				String td1_2 = request.getParameter("td1_2");
				String td1_3 = request.getParameter("td1_3");
				String td1_4 = request.getParameter("td1_4");
				String td1_5 = request.getParameter("td1_5");

				//短期目標２
				String sg2 = request.getParameter("sg2");
				//短期目標２のToDo
				String td2_1 = request.getParameter("td2_1");
				String td2_2 = request.getParameter("td2_2");
				String td2_3 = request.getParameter("td2_3");
				String td2_4 = request.getParameter("td2_4");
				String td2_5 = request.getParameter("td2_5");

				//短期目標３
				String sg3 = request.getParameter("sg3");
				//短期目標３のToDo
				String td3_1 = request.getParameter("td3_1");
				String td3_2 = request.getParameter("td3_2");
				String td3_3 = request.getParameter("td3_3");
				String td3_4 = request.getParameter("td3_4");
				String td3_5 = request.getParameter("td3_5");

				//短期目標４
				String sg4 = request.getParameter("sg4");
				//短期目標４のToDo
				String td4_1 = request.getParameter("td4_1");
				String td4_2 = request.getParameter("td4_2");
				String td4_3 = request.getParameter("td4_3");
				String td4_4 = request.getParameter("td4_4");
				String td4_5 = request.getParameter("td4_5");

				//短期目標５
				String sg5 = request.getParameter("sg5");
				//短期目標５のToDo
				String td5_1 = request.getParameter("td5_1");
				String td5_2 = request.getParameter("td5_2");
				String td5_3 = request.getParameter("td5_3");
				String td5_4 = request.getParameter("td5_4");
				String td5_5 = request.getParameter("td5_5");

				//スコープからNUMBERを取得

			    //int number = Integer.parseInt(request.getParameter("NUMBER"));

				//nullチェック（lg sg td）
				// 受け取ったデータの表示

				//長期目標
				if (lg != null && lg != "") {
					System.out.println("長期目標: " + lg);

				//number, year, month, lgをLGOALに登録

					//LgDAO lgDao = new LgDAO();
				    //Lg lgs = new Lg(number, year, month, lg);

				}
				//短期目標１
				if (sg1 != null && sg1 != "") {
					System.out.println("短期目標１: " + sg1);
					System.out.println(day_s_1);
					System.out.println(day_e_1);
				}
				//短期目標１のToDo
				if (td1_1 != null && td1_1 != "") {
					System.out.println("短期目標１のToDo1: " + td1_1);
				}
				if (td1_2 != null && td1_2 != "") {
					System.out.println("短期目標１のToDo2: " + td1_2);
				}
				if (td1_3 != null && td1_2 != "") {
					System.out.println("短期目標１のToDo3: " + td1_3);
				}
				if (td1_4 != null && td1_4 != "") {
					System.out.println("短期目標１のToDo4: " + td1_4);
				}
				if (td1_5 != null && td1_5 != "") {
					System.out.println("短期目標１のToDo5: " + td1_5);
				}
					//短期目標２
				if (sg2 != null && sg2 != "") {
					System.out.println("短期目標２: " + sg2);
				}
					//短期目標２のToDo
				if (td2_1 != null && td2_1 != "") {
					System.out.println("短期目標２のToDo1: " + td2_1);
				}
				if (td2_2 != null && td2_2 != "") {
					System.out.println("短期目標２のToDo2: " + td2_2);
				}
				if (td2_3 != null && td2_3 != "") {
					System.out.println("短期目標２のToDo3: " + td2_3);
				}
				if (td2_4 != null && td2_4 != "") {
					System.out.println("短期目標２のToDo4: " + td2_4);
				}
				if (td2_5 != null && td2_5 != "") {
					System.out.println("短期目標２のToDo5: " + td2_5);
				}

				//短期目標３
				if (sg3 != null && sg3 != "") {
					System.out.println("短期目標３: " + sg3);
				}
				//短期目標３のToDo
				if (td3_1 != null && td3_1 != "") {
					System.out.println("短期目標３のToDo1: " + td3_1);
				}
				if (td3_2 != null && td3_2 != "") {
					System.out.println("短期目標３のToDo2: " + td3_2);
				}
				if (td3_3 != null && td3_3 != "") {
					System.out.println("短期目標３のToDo3: " + td3_3);
				}
				if (td3_4 != null && td3_4 != "") {
					System.out.println("短期目標３のToDo4: " + td3_4);
				}
				if (td3_5 != null && td3_5 != "") {
				System.out.println("短期目標３のToDo5: " + td3_5);
				}

				//短期目標４
				if (sg4 != null && sg4 != "") {
					System.out.println("短期目標４: " + sg4);
				}
				//短期目標４のToDo
				if (td4_1 != null && td4_1 != "") {
					System.out.println("短期目標４のToDo1: " + td4_1);
				}
				if (td4_2 != null && td4_2 != "") {
					System.out.println("短期目標４のToDo2: " + td4_2);
				}
				if (td4_3 != null && td4_3 != "") {
					System.out.println("短期目標４のToDo3: " + td4_3);
				}
				if (td4_4 != null && td4_4 != "") {
					System.out.println("短期目標４のToDo4: " + td4_4);
				}
					if (td4_5 != null && td4_5 != "") {
				System.out.println("短期目標４のToDo5: " + td4_5);

				//短期目標５
				if (sg5 != null && sg5 != "") {
					System.out.println("短期目標５: " + sg5);
				}
				//短期目標５のToDo
				if (td5_1 != null && td5_1 != "") {
					System.out.println("短期目標５のToDo1: " + td5_1);
				}
				if (td5_2 != null && td5_2 != "") {
					System.out.println("短期目標５のToDo2: " + td5_2);
				}
				if (td5_3 != null && td5_3 != "") {
					System.out.println("短期目標５のToDo3: " + td5_3);
				}
				if (td5_4 != null && td5_4 != "") {
					System.out.println("短期目標５のToDo4: " + td5_4);
				}
				if (td5_5 != null && td5_5 != "") {
					System.out.println("短期目標５のToDo5: " + td5_5);
				}
				// 他の処理を追加することも可能

				// レスポンスの設定
				response.setContentType("text/html");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().println("データの受け取りが完了しました");
		}
	}

}