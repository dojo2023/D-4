package test;

import dao.TodotbDAO;
import model.AllA;

public class TodotbDAOTestAchieve {
	public static void main(String[] args) {
		// select()のテスト
		System.out.println("---------- select()のテスト ----------");
		int number =1000;
		String month="2023-09-01";
		TodotbDAO dao = new TodotbDAO();
		AllA alla = dao.achieve(number,month);
			System.out.println("長期目標：" + alla.getLg());
			System.out.println("長期目標達成度：" + alla.getLgA());
			System.out.println("===========================================================================");

			//System.out.println("短期目標の数:"+(alla.getSgA()).size());
			System.out.println("===========================================================================");
			for(int i=0;i<(alla.getSgA()).size();i++) {
				System.out.println("短期目標"+(i+1)+"：" + (alla.getSgA()).get(i).getSg());
				System.out.println("短期目標"+(i+1)+"の達成度：" + (alla.getSgA()).get(i).getsAchieve());
				System.out.println();
				for(int j=0;j<alla.getSgA().get(i).getTodoA().size();j++) {
				System.out.println("    todo"+(j+1)+":" + alla.getSgA().get(i).getTodoA().get(j).getTodo());
				System.out.println("    todo"+(j+1)+"の達成度:" + alla.getSgA().get(i).getTodoA().get(j).gettAchieve());
				System.out.println();
				}
				System.out.println("===========================================================================");
			}

		// insert()のテスト
		/*System.out.println("---------- insert()のテスト ----------");
		if (dao.update(8,40)) {
			System.out.println("登録成功！");
		}
		else {
			System.out.println("登録失敗！");
		}*/
	}
}
