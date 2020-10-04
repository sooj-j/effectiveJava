package chapter12.item88;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;

public class Period implements Serializable {
	private Date start;
	private Date end;

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

		// 가변 요소들을 방어적으로 복사한다
		start = new Date(start.getTime());
		end = new Date(end.getTime());

		// 불변식을 만족하는지 검사한다.
		if (start.compareTo(end) > 0)
			throw new InvalidObjectException(start + "가 " + end + "보다 늦다.");
	}


	@Override
	public String toString() {
		return String.format("%s - %s", start.toString(), end.toString());
	}
}
