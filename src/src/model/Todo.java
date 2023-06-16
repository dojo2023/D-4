package model;
import java.io.Serializable;

public class Todo implements Serializable{
 private int todoid;
 private int sgid;
 private String todo;
 private int achieve;

 public Todo(int todoid,int sgid,String todo,int achieve) {
	 this.todoid=todoid;
	 this.sgid=sgid;
	 this.todoid=todoid;
	 this.achieve=achieve;
 }
 public Todo(int sgid) {
	 this.sgid=sgid;
 }
public int getTodoid() {
	return todoid;
}
public void setTodoid(int todoid) {
	this.todoid = todoid;
}
public int getSgid() {
	return sgid;
}
public void setSgid(int sgid) {
	this.sgid = sgid;
}
public String getTodo() {
	return todo;
}
public void setTodo(String todo) {
	this.todo = todo;
}
public int getAchieve() {
	return achieve;
}
public void setAchieve(int achieve) {
	this.achieve = achieve;
}


}
