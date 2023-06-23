package test;

import java.util.List;

import dao.TasktbDAO;
import model.Task;
public class TaskDAOTest {
	public static void main(String[] args) {
		TasktbDAO dao = new TasktbDAO();

		// select()のテスト
		System.out.println("---------- select()のテスト ----------");
		int number =1000;
		String month="2022-06-01";
		List<Task> cardList2 = dao.task(number,month);
		for (Task card : cardList2) {
			System.out.println("HOUR_S：" + card.getHour_s());
			System.out.println("HOUR_E：" + card.getHour_e());
			System.out.println("TASK：" + card.getTask());
			System.out.println();
		}

	}
}
