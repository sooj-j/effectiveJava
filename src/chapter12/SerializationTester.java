package chapter12;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationTester {
	public byte[] serialize() {
		Article article = new Article(1, "직렬화 테스트", "김탱일보", "김탱");

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(article);
		} catch (Exception e) {
			// ... 구현 생략
		}
		return bos.toByteArray();
	}

	public Article deserialize(byte[] serializedData) {
		ByteArrayInputStream bis = new ByteArrayInputStream(serializedData);
		try {
			ObjectInputStream ois = new ObjectInputStream(bis);
			Object object = ois.readObject();
			return (Article)object;
		} catch (Exception e) {
			// ... 구현 생략
		}
		return null;
	}

	public static void main(String[] args) {
		SerializationTester serializationTester = new SerializationTester();
		byte[] serializedData = serializationTester.serialize();

//		for (byte serializedDatum : serializedData) {
//			System.out.print(String.format("0x%02X ", serializedDatum));
//		}
//		System.out.println();

		Article article = serializationTester.deserialize(serializedData);
		System.out.println(article);
	}
}
