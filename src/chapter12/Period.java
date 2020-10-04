package chapter12;

import java.io.Serializable;
import java.util.Date;

public class Period implements Serializable {
	private final Date start;
	private final Date end;

	public Period(Date start, Date end) {
		this.start = new Date(start.getTime());
		this.end = new Date(end.getTime());

		if (this.start.compareTo(this.end) > 0)
			throw new IllegalArgumentException(start + "가 " + end + "보다 늦다.");
	}

	public Date start() {
		return new Date(start.getTime());
	}
	public Date end() {
		return new Date(end.getTime());
	}

	@Override
	public String toString() {
		return String.format("%s - %s", start.toString(), end.toString());
	}
}
