package model;
import java.io.Serializable;
public class TodoA implements Serializable{
	private int todoId;
	private int sgId;
	private int tAchieve;
	public TodoA() {
		this.todoId = 0;
		this.sgId = 0;
		this.tAchieve = 0;
	}
	public TodoA(int todoId,int sgId,int tAchieve) {
		this.todoId = todoId;
		this.sgId = sgId;
		this.tAchieve = tAchieve;
	}
	public int getTodoId() {
		return todoId;
	}
	public void setTodoId(int todoId) {
		this.todoId = todoId;
	}
	public int getSgId() {
		return sgId;
	}
	public void setSgId(int sgId) {
		this.sgId = sgId;
	}
	public int gettAchieve() {
		return tAchieve;
	}
	public void settAchieve(int tAchieve) {
		this.tAchieve = tAchieve;
	}
}