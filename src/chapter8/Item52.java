package chapter8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Item52 {
	public static void main(String[] args) {
		new Thread(System.out::println).start();

		ExecutorService exec = Executors.newCachedThreadPool();
		exec.submit(() -> System.out.println("hello"));
	}
}
