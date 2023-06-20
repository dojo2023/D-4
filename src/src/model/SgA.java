package model;
import java.io.Serializable;

public class SgA implements Serializable {
	private int sgId;
	private int lgId;
	private int sAchieve;

	//初期値設定
	public SgA() {
		this.sgId = 0;
		this.lgId = 0;
		this.sAchieve = 0;
	}

	//SQLで配列に入れるためのメソッド
	public SgA(int lgId, int sgId, int sAchieve) {
		this.lgId = lgId;
		this.sgId = sgId;
		this.sAchieve = sAchieve;
	}

	public int getLgId() {
		return lgId;
	}

	public void setLgId(int lgId) {
		this.lgId = lgId;
	}

	public int getSgId() {
		return sgId;
	}

	public void setSgId(int sgId) {
		this.sgId = sgId;
	}

	public int getsAchieve() {
		return sAchieve;
	}

	public void setsAchieve(int sAchieve) {
		this.sAchieve = sAchieve;
	}


}
