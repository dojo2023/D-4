package model;
import java.io.Serializable;
public class Sg implements Serializable {
	private int sgid;
	private int lgid;
	private String day_s;
	private String day_e;
	private String sg;
	private String month;
	private int number;
	//データ新規追加用
	public Sg(int number, String month,String day_s,String day_e,String sg) {
		this.number = number;
		this.month = month;
		this.day_s = day_s;//YYYY-MM-DDにしてください
		this.day_e = day_e;
		this.sg = sg;
	}
	//データ取得・消去・変更用
	public Sg(int sgid,int lgid,String day_s,String day_e,String sg) {
		this.sgid=sgid;
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
	public String getMonth() {
		return month;
	}
	public void setMonth(int YYYY,int MM) {
		String date=(YYYY+"-"+MM);
		this.month = date;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
}











