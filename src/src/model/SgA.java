package model;
import java.io.Serializable;
import java.util.List;

public class SgA implements Serializable {
	private int sgId;
	private int lgId;
	private String sg;
	private String day_s;
	private String day_e;
	private int sAchieve;
	private List<TodoA> TodoA;

	//初期値設定
	public SgA() {
		this.sgId = 0;
		this.lgId = 0;
		this.sAchieve = 0;
	}

	public List<TodoA> getTodoA() {
		return TodoA;
	}

	public String getSg() {
		return sg;
	}

	public void setSg(String sg) {
		this.sg = sg;
	}

	public void setTodoA(List<TodoA> TodoA) {
		this.TodoA = TodoA;
	}

	//SQLで配列に入れるためのメソッド
	public SgA(int lgId, int sgId,String sg,String day_s,String day_e, int sAchieve ,List<TodoA> TodoA) {
		this.lgId = lgId;
		this.sgId = sgId;
		this.sg=sg;
		this.day_s=day_s;
		this.day_e=day_e;
		this.sAchieve = sAchieve;
		this.TodoA = TodoA;
	}

	public String getDay_s() {
		return day_s;
	}

	public void setDay_s(String day_s) {
		this.day_s = day_s;
	}

	public String getDay_e() {
		return day_e;
	}

	public void setDay_e(String day_e) {
		this.day_e = day_e;
	}

	public int getLgId() {
		return lgId;
	}

	public void setLgId(int lgId) {
		this.lgId = lgId;
	}

	public int getSgId() {
		return sgId;
	}

	public void setSgId(int sgId) {
		this.sgId = sgId;
	}

	public int getsAchieve() {
		return sAchieve;
	}

	public void setsAchieve(int sAchieve) {
		this.sAchieve = sAchieve;
	}


}
