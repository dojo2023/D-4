package model;
import java.util.List;

public class AllA {
	private int LgA;
	private List<SgA> SgA;
	private List<TodoA> TodoA;

	public AllA(int LgA,List<SgA> SgA,List<TodoA> TodoA) {
		this.LgA=LgA;
		this.SgA=SgA;
		this.TodoA=TodoA;
	}
	public int getLgA() {
		return LgA;
	}
	public void setLgA(int lgA) {
		this.LgA = lgA;
	}
	public List<SgA> getSgA() {
		return SgA;
	}
	public void setSgA(List<SgA> sgA) {
		this.SgA = sgA;
	}
	public List<TodoA> getTodoA() {
		return TodoA;
	}
	public void setTodoA(List<TodoA> todoA) {
		this.TodoA = todoA;
	}

}
