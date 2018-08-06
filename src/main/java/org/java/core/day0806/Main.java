package org.java.core.day0806;

public class Main {

	public static void main(String[] args) {
		// AbstractFruit fruit = new Apple();
		AbstractFruit fruit = new Orange();
		String desc = fruit.description();
		System.out.println(desc);
	}

}
