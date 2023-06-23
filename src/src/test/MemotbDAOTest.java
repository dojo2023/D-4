package test;

import java.util.Calendar;

import dao.MemotbDAO;
import model.Memo;

public class MemotbDAOTest {
	public static void main(String[] args) {
		MemotbDAO dao = new MemotbDAO();

		//表示したい月の年月日を取得
				Calendar calendar = Calendar.getInstance();
				int day = calendar.get(Calendar.DATE);
				int month = calendar.get(Calendar.MONTH) + 1;
				int year = calendar.get(Calendar.YEAR);
		// select()のテスト
		System.out.println("---------- select()のテスト ----------");
		int number =1000;
		String date=year + "-" + month + "-" + day;;
		String cardList2 = dao.memo(number,date);
			System.out.println("Memo：" + cardList2 );
			System.out.println();
		// insert()のテスト
		System.out.println("---------- insert()のテスト ----------");
		Memo insRec = new Memo(number,"2023-08-01", "休みたい");
		if (dao.updateMemo(insRec)) {
			System.out.println("登録成功！");
		}
		else {
			System.out.println("登録失敗！");
		}
	}
}
