package model;

import java.io.Serializable;

public class CalendarCounter implements Serializable {
	private int monthCounter;

	public int getMonthCounter() {
		return monthCounter;
	}

	public void setMonthCounter(int monthCounter) {
		this.monthCounter = monthCounter;
	}
}
