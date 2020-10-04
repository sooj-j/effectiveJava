package chapter12;

import java.io.Serializable;

public class Article implements Serializable {
	private transient Integer id;
	private String title;
	private String pressName;
	private String reporterName;

	public Article(Integer id, String title, String pressName, String reporterName) {
		this.id = id;
		this.title = title;
		this.pressName = pressName;
		this.reporterName = reporterName;
	}

	/**
	 * 멤버 필드 확인 용도로 재정의한다.
	 */
	@Override
	public String toString() {
		return String.format("id = %s, title = %s, pressName = %s, reporterName = %s",
			id, title, pressName, reporterName);
	}
}
