package chapter12;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.Date;

public class BogusPeriod {
	// 진짜 Period 인스턴스에서는 만들어질 수 없는 바이트 스트림
	// Sun Oct 04 21:59:35 KST 2020 - Mon Oct 04 21:59:35 KST 2010
	private static final byte[] serializedForm = {
		(byte)0xAC, (byte)0xED, (byte)0x00, (byte)0x05, (byte)0x73, (byte)0x72, (byte)0x00, (byte)0x10, (byte)0x63, (byte)0x68, (byte)0x61, (byte)0x70,
		(byte)0x74, (byte)0x65, (byte)0x72, (byte)0x31, (byte)0x32, (byte)0x2E, (byte)0x50, (byte)0x65, (byte)0x72, (byte)0x69, (byte)0x6F, (byte)0x64,
		(byte)0x57, (byte)0x27, (byte)0xCE, (byte)0x3A, (byte)0x9E, (byte)0x0D, (byte)0x31, (byte)0xDB, (byte)0x02, (byte)0x00, (byte)0x02, (byte)0x4C,
		(byte)0x00, (byte)0x03, (byte)0x65, (byte)0x6E, (byte)0x64, (byte)0x74, (byte)0x00, (byte)0x10, (byte)0x4C, (byte)0x6A, (byte)0x61, (byte)0x76,
		(byte)0x61, (byte)0x2F, (byte)0x75, (byte)0x74, (byte)0x69, (byte)0x6C, (byte)0x2F, (byte)0x44, (byte)0x61, (byte)0x74, (byte)0x65, (byte)0x3B,
		(byte)0x4C, (byte)0x00, (byte)0x05, (byte)0x73, (byte)0x74, (byte)0x61, (byte)0x72, (byte)0x74, (byte)0x71, (byte)0x00, (byte)0x7E, (byte)0x00,
		(byte)0x01, (byte)0x78, (byte)0x70, (byte)0x73, (byte)0x72, (byte)0x00, (byte)0x0E, (byte)0x6A, (byte)0x61, (byte)0x76, (byte)0x61, (byte)0x2E,
		(byte)0x75, (byte)0x74, (byte)0x69, (byte)0x6C, (byte)0x2E, (byte)0x44, (byte)0x61, (byte)0x74, (byte)0x65, (byte)0x68, (byte)0x6A, (byte)0x81,
		(byte)0x01, (byte)0x4B, (byte)0x59, (byte)0x74, (byte)0x19, (byte)0x03, (byte)0x00, (byte)0x00, (byte)0x78, (byte)0x70, (byte)0x77, (byte)0x08,
		(byte)0x00, (byte)0x00, (byte)0x01, (byte)0x2B, (byte)0x77, (byte)0x53, (byte)0x64, (byte)0xC7, (byte)0x78, (byte)0x73, (byte)0x71, (byte)0x00,
		(byte)0x7E, (byte)0x00, (byte)0x03, (byte)0x77, (byte)0x08, (byte)0x00, (byte)0x00, (byte)0x01, (byte)0x74, (byte)0xF3, (byte)0xB2, (byte)0x30,
		(byte)0xC7, (byte)0x78 };

	public static void main(String[] args) {
		Period p = (Period)deserialize(serializedForm);
		System.out.println(p);
	}

	static Object deserialize(byte[] serializedData) {
		try {
			return new ObjectInputStream(new ByteArrayInputStream(serializedData)).readObject();
		} catch (IOException | ClassNotFoundException e) {
			throw new IllegalArgumentException(e);
		}
	}

	static byte[] serialize(Object object) {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(object);
		} catch (Exception e) {
		}
		return bos.toByteArray();
	}

	static void createInvalidPeriod() {
		Date date = new Date();

		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.YEAR, -10);

		byte[] serializedData = serialize(new Period(date, c.getTime()));

		for (byte serializedDatum : serializedData) {
			System.out.print(String.format("(byte)0x%02X, ", serializedDatum));
		}
	}
}

