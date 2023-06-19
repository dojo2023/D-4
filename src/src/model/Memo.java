package model;

import java.io.Serializable;

public class Memo implements Serializable {

		private int number;
		private String day;
		private String memo;

		public Memo(int number, String day, String memo) {
	        this.number = number;
	        this.day = day;
	        this.memo = memo;
	    }
		public Memo(int number, String day) {
	        this.number = number;
	        this.day = day;
	    }

		public int getNumber() {
			return number;
		}

		public void setNumber(int number) {
			this.number = number;
		}

		public String getDay() {
			return day;
		}

		public void setDay(int YYYY,int MM,int DD) {
			String day=(YYYY+"-"+MM+"-"+DD);
			this.day = day;
		}

		public String getMemo() {
			return memo;
		}

		public void setMemo(String memo) {
			this.memo = memo;
		}

}
