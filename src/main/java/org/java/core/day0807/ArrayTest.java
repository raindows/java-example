package org.java.core.day0807;

import java.util.Arrays;
import java.util.List;

public class ArrayTest {

	public static void main(String[] args) {
		char[] p1 = new char[3];
		long[] p2 = new long[4];
		String[] p3 = new String[5];
		Arrays.fill(p1, 'b');
		Arrays.fill(p2, 5L);
		Arrays.fill(p3, "Hello");
		System.out.println(Arrays.toString(p1)); // [b, b, b]
		System.out.println(Arrays.toString(p2)); // [5, 5, 5, 5]
		System.out.println(Arrays.toString(p3)); // [Hello, Hello, Hello, Hello, Hello]
		Arrays.fill(p3, 4, 5, "World");
		System.out.println(Arrays.toString(p3)); // [Hello, Hello, Hello, Hello, World]

		System.out.println(p3.length);
		List<String> list = Arrays.asList(p3);
		System.out.println(list);
	}

}
