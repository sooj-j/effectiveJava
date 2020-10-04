package chapter12;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
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

	private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
		s.defaultReadObject();

		// 불변식을 만족하는지 검사한다.
		if (start.compareTo(end) > 0)
			throw new InvalidObjectException(start + "가 " + end + "보다 늦다.");
	}


	@Override
	public String toString() {
		return String.format("%s - %s", start.toString(), end.toString());
	}
}
