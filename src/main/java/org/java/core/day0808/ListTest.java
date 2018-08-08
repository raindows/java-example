package org.java.core.day0808;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListTest {

	// 可以去了解ArrayList LinkedList Vector的区别
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(100);
		list.add(200);
		list.add(300);
		list.add(100);
		list.add(null);
		System.out.println(list.size());
		System.out.println(list);
		System.out.println(list.contains(200));
		System.out.println(list.contains(900));

		System.out.println("遍历方法一(for循环遍历)");
		int size = list.size();
		for (int i = 0; i < size; i++) {
			System.out.println(list.get(i));
		}

		System.out.println("遍历方法二(foreach遍历)");
		for (Integer value : list) {
			System.out.println(value);
		}

		System.out.println("遍历方法三(iterator迭代器遍历)");
		Iterator<Integer> iterator = list.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

		list.remove(1);
		System.out.println(list);
	}

}
