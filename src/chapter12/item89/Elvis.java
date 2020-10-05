package chapter12.item89;

import java.io.Serializable;
import java.util.Arrays;

public class Elvis implements Serializable {
	public static final Elvis INSTANCE = new Elvis();
	private Elvis() { }

	// to create invalid bytes
	// private Object favoriteSongs = new ElvisStealer();

	private Object favoriteSongs = Arrays.asList("Hello", "World");

	public void printFavorites() {
		System.out.println(favoriteSongs.toString());
	}

	private Object readResolve() {
		return INSTANCE;
	}
}
