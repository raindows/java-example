package org.java.core.day0806;

public class Main {

	public static void main(String[] args) {
		// testBase();
		testClassLoad();
	}

	private static void testBase() {
		System.out.println("\n1.继承 封装 多态测试\n");
		// AbstractFruit fruit = new Apple();
		AbstractFruit fruit = new Orange();
		String desc = fruit.description();
		System.out.println(desc);
	}

	private static void testClassLoad() {
		System.out.println("\n2.类加载执行顺序测试\n");
		// AbstractFruit fruit = new Apple();
		AbstractFruit fruit = new Orange();
		String desc = fruit.description();
		System.out.println(desc);
		System.out.println("\n---------------------分割线---------------------\n");
		fruit = new Orange();
		desc = fruit.description();
		System.out.println(desc);
		System.out.println("\n---------------------分割线---------------------\n");
		fruit = new Apple();
		desc = fruit.description();
		System.out.println(desc);
	}

}
