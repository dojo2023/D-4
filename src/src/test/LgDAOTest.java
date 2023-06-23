package test;
import dao.LgDAO;
import model.Lg;

public class LgDAOTest {
	public static void main(String[] args) {
		LgDAO dao = new LgDAO();

		// select()のテスト
		System.out.println("---------- select()のテスト ----------");
		int number =1000;
		String month="2023-06-01";
		String cardList2 = dao.lg(number,month);
			System.out.println("LG：" + cardList2 );
			System.out.println();

		// insert()のテスト
		System.out.println("---------- insert()のテスト ----------");
		Lg insRec = new Lg(number, "2022-08-01", "休みたい");
		if (dao.updateLg(insRec)) {
			System.out.println("登録成功！");
		}
		else {
			System.out.println("登録失敗！");
		}

		// update()のテスト
		/*System.out.println("---------- update()のテスト ----------");
		Lg upRec = new Lg(1,number, "2023-06-01", "休憩");
		if (dao.updateLg(upRec)) {
			System.out.println("更新成功！");
			}else {
			System.out.println("更新失敗！");
			}
			*/
	}

}
