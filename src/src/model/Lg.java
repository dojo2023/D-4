package model;
import java.io.Serializable;

public class Lg implements Serializable {
	private int lgid;
	private int number;
	private String month;
	private String lg;

	//データ新規追加用
	public Lg(int number,String YYYY,String MM,String lg) {
		this.number = number;
		this.month = (YYYY+"-"+MM);
		this.lg = lg;
	}
	public Lg(int number,String month,String lg) {
		this.number = number;
		this.month = month;
		this.lg = lg;
	}
	//データ取得・消去・変更用
	public Lg(int lgid,int number,String month,String lg) {
		this.lgid=lgid;
		this.number = number;
		this.month = month;
		this.lg = lg;
	}
	public int getLgid() {
		return lgid;
	}
	public void setLgid(int lgid) {
		this.lgid = lgid;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(int YYYY,int MM) {
		String month=(YYYY+"-"+MM);
		this.month = month;
	}
	public String getLg() {
		return lg;
	}
	public void setLg(String lg) {
		this.lg = lg;
	}


}
