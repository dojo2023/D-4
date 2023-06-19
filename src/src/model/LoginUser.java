package model;

import java.io.Serializable;

public class LoginUser implements Serializable{
	// ログイン時のID
	private int number;
	private String name;
	private int days;

	public LoginUser(int number,String name,int days){
		this.number=number;
		this.name=name;
		this.days=days;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
}
