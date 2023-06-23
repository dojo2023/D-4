package test;

import java.util.List;

import dao.SgDAO;
import model.Sg;

public class SgDAOTest {
	public static void main(String[] args) {
		SgDAO dao = new SgDAO();

		// select()のテスト
		System.out.println("---------- select()のテスト ----------");
		int number =1000;
		String month="2023-06-01";
		List<Sg> cardList2 = dao.sg(number,month);
		for (Sg card : cardList2) {
			System.out.println("SGID：" + card.getSgid());
			System.out.println("LGID：" + card.getLgid());
			System.out.println("DAY_S：" + card.getDay_s());
			System.out.println("DAY_E：" + card.getDay_e());
			System.out.println("SG：" + card.getSg());
			System.out.println();
		}
		// insert()のテスト
		System.out.println("---------- insert()のテスト ----------");
		Sg insRec = new Sg(number, "2023-08-01","2023-08-01","2023-08-03", "休みたい");
		if (dao.updateSg(insRec)) {
			System.out.println("登録成功！");
		}
		else {
			System.out.println("登録失敗！");
		}

		// update()のテスト
		/*System.out.println("---------- update()のテスト ----------");
		Sg upRec = new Sg(1,1, "2023-06-01","2023-06-03", "水分補給");
		if (dao.updateSg(upRec)) {
			System.out.println("更新成功！");
			}else {
			System.out.println("更新失敗！");
		}

		// delete()のテスト
		System.out.println("---------- delete()のテスト ----------");
		Sg delRec = new Sg(3,2, "2023-06-01","2023-06-03", "");
		if (dao.updateSg(delRec)) {
			System.out.println("削除成功！");
		}
		else {
			System.out.println("削除失敗！");
		}
		*/
	}
}
