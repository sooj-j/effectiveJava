package chapter12.item89;

import java.io.Serializable;
import java.util.Arrays;

public class ElvisStealer implements Serializable {
	static Elvis impersonator;
	private Elvis payload;

	private Object readResolve() {
//		System.out.println("readResolve");
//		System.out.println(Elvis.INSTANCE);
//		System.out.println(payload);

		impersonator = payload;
		return Arrays.asList("Hello", "I Stole");
	}

	private static final long serialVersionUID = 0;
}
