package model;
import java.util.List;

public class AllA {
	private String lg;
	private int LgA;
	private List<SgA> SgA;

	public AllA(String lg,int LgA,List<SgA> SgA) {
		this.lg=lg;
		this.LgA=LgA;
		this.SgA=SgA;
	}
	public String getLg() {
		return lg;
	}
	public void setLg(String lg) {
		this.lg = lg;
	}
	public int getLgA() {
		return LgA;
	}
	public void setLgA(int lgA) {
		this.LgA = lgA;
	}
	public List<SgA> getSgA() {
		return SgA;
	}
	public void setSgA(List<SgA> sgA) {
		this.SgA = sgA;
	}


}
