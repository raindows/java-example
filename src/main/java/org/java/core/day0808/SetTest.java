package org.java.core.day0808;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTest {
	
	// 可以去了解HashSet TreeSet LinkedHashSet的区别
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("1");
		set.add("2");
		set.add("3");
		set.add("1");
		set.add(null);
		System.out.println(set);
		System.out.println(set.size());
		System.out.println("遍历方法一(foreach遍历)");
		for (String value : set) {
			System.out.println(value);
		}
		System.out.println("遍历方法二(iterator迭代器遍历)");
		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println(set.contains("1"));
		set.remove("1");
		System.out.println(set);
		System.out.println(set.contains("1"));
	}
}
