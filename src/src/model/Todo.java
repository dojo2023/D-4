package model;
import java.io.Serializable;

public class Todo implements Serializable{
 private int todoid;
 private int sgid;
 private String day_s;
 private String day_e;
 private String todo;
 private int achieve;
 private String month;
 private int number;
	//データ取得・消去・変更用
 public Todo(int todoid,int sgid,String todo,int achieve) {
	 this.todoid=todoid;
	 this.sgid=sgid;
	 this.todoid=todoid;
	 this.achieve=achieve;
 }
 	//データ新規追加用
 public Todo(int number, String month, String day_s, String day_e, String todo) {
	 this.number = number;
	 this.month = month;
	 this.day_s = day_s;
	 this.day_e = day_e;
	 this.todo=todo;
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
public String getMonth() {
	return month;
}
public void setMonth(String month) {
	this.month = month;
}
public int getNumber() {
	return number;
}
public void setNumber(int number) {
	this.number = number;
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
