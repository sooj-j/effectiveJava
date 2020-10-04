package chapter12.item88;

import java.util.Date;

public class PeriodTester {
	public static void main(String[] args) {
		mutablePeriodTest();
	}

	static void mutablePeriodTest() {
		MutablePeriod mp = new MutablePeriod();
		Period p = mp.period;
		Date pEnd = mp.end;

		pEnd.setYear(78);
		System.out.println(p);
	}
}
