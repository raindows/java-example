package org.java.core.day0807;

public class StringTest {

	public static void main(String[] args) {
		System.out.println("\n测试String");
		String value = "123abc123";
		System.out.println(value.length());
		System.out.println(value.lastIndexOf("2"));
		System.out.println(value.replace("abc", "xyz"));
		System.out.println(value.endsWith("3"));
		System.out.println(value.endsWith("321"));
		System.out.println(value.substring(3, 6));
		System.out.println(value.substring(3));
		System.out.println("\n测试StringBuffer");
		StringBuffer buffer = new StringBuffer("abc");
		System.out.println(buffer.toString());
		buffer.append("xyz");
		System.out.println(buffer.toString());
		System.out.println(buffer.deleteCharAt(buffer.length()-1));
		System.out.println("\n测试String StringBuffer StringBuilder字符串处理性能");
		testString(100000, "0");
		testStringBuffer(600000, "0");
		testStringBuilder(600000, "0");
	}

	public static void testString(int count, String appendValue) {
		long startTime = System.currentTimeMillis();
		String value = "";
		for (int i = 0; i < count; i++) {
			value = value + appendValue;
		}
		long endTime = System.currentTimeMillis();
		System.out.println("String\t"+(endTime - startTime) + "ms");
	}

	public static void testStringBuffer(int count, String appendValue) {
		long startTime = System.currentTimeMillis();
		StringBuffer value = new StringBuffer();
		for (int i = 0; i < count; i++) {
			value.append(appendValue);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("StringBuffer\t"+(endTime - startTime) + "ms");
	}

	public static void testStringBuilder(int count, String appendValue) {
		long startTime = System.currentTimeMillis();
		StringBuilder value = new StringBuilder();
		for (int i = 0; i < count; i++) {
			value.append(appendValue);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("StringBuilder\t"+(endTime - startTime) + "ms");
	}

}
