package model;

import java.io.Serializable;

public class Idpw implements Serializable {
	private int number;
	private String name;
	private String pw;

	public Idpw(int number,String name, String pw) {
		this.number = number;
		this.name=name;
		this.pw = pw;
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

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

}
