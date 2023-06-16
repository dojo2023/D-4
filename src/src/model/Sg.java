package model;
import java.io.Serializable;

public class Sg implements Serializable {
	private int sgid;
	private int lgid;
	private String day_s;
	private String day_e;
	private String sg;

	private String date;;
	private int number;

	public Sg(int sgid,int lgid,String day_s,String day_e,String sg) {
		this.sgid = sgid;
		this.lgid = lgid;
		this.day_s = day_s;
		this.day_e = day_e;
		this.sg = sg;

	}

	public int getSgid() {
		return sgid;
	}

	public void setSgid(int sgid) {
		this.sgid = sgid;
	}

	public int getLgid() {
		return lgid;
	}

	public void setLgid(int lgid) {
		this.lgid = lgid;
	}

	public String getDay_s() {
		return day_s;
	}

	public void setDay_s(int YYYY,int MM,int DD) {
		String day_s=(YYYY+"-"+MM+"-"+DD);
		this.day_s = day_s;
	}

	public String getDay_e() {
		return day_e;
	}

	public void setDay_e(int YYYY,int MM,int DD) {
		String day_e=(YYYY+"-"+MM+"-"+DD);
		this.day_e = day_e;
	}

	public String getSg() {
		return sg;
	}

	public void setSg(String sg) {
		this.sg = sg;
	}

	public String getDate() {
		return date;
	}

	public void setDate(int YYYY,int MM) {
		String date=(YYYY+"-"+MM);
		this.date = date;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

}
