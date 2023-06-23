package test;

import java.util.List;

import dao.TodotbDAO;
import model.Todo;

public class TodotbDAOTest {
	public static void main(String[] args) {
		TodotbDAO dao = new TodotbDAO();

		// select()のテスト
		System.out.println("---------- select()のテスト ----------");
		int number =1000;
		String month="2023-06-01";
		List<Todo> cardList2 = dao.todo(number,month);
		for (Todo card : cardList2) {
			System.out.println("TODOID：" + card.getTodoid());
			System.out.println("SGID：" + card.getSgid());
			System.out.println("TODO:" + card.getTodo());
			System.out.println("ACHIEVE：" + card.getAchieve());
			System.out.println();
		}
		// insert()のテスト
		/*System.out.println("---------- insert()のテスト ----------");
		Todo insRec = new Todo(number, "2023-07-01","2023-07-01","2023-07-03", "動画見る");
		if (dao.updateTodo(insRec)) {
			System.out.println("登録成功！");
		}
		else {
			System.out.println("登録失敗！");
		}*/

		// update()のテスト
		System.out.println("---------- update()のテスト ----------");
		Todo upRec = new Todo(7,4, "疲れた",40);
		if (dao.updateTodo(upRec)) {
			System.out.println("更新成功！");
			}else {
			System.out.println("更新失敗！");
		}
		/*
		// delete()のテスト
		System.out.println("---------- delete()のテスト ----------");
		Todo delRec = new Todo(6,3, "",2);
		if (dao.updateTodo(delRec)) {
			System.out.println("削除成功！");
		}
		else {
			System.out.println("削除失敗！");
		}*/
	}
}
