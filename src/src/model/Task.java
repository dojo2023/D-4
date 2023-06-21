package model;
import java.io.Serializable;

public class Task implements Serializable{
	private int number;
	private String hour_s;
	private String hour_e;
	private String task;
	public Task(int number,String hour_s,String hour_e,String task) {
		this.number=number;
		this.hour_s=hour_s;
		this.hour_e=hour_e;
		this.task=task;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getHour_s() {
		return hour_s;
	}
	public void setHour_s(int YYYY,int MM,int DD,int h) {
		String hour_s=(YYYY+"-"+MM+"-"+DD+" "+h);
		this.hour_s = hour_s;
	}
	public String getHour_e() {
		return hour_e;
	}
	public void setHour_e(int YYYY,int MM,int DD,int h){
		String hour_e=(YYYY+"-"+MM+"-"+DD+" "+h);
		this.hour_e = hour_e;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}

}
