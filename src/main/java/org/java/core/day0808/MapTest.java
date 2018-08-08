package org.java.core.day0808;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapTest {

	// 可以去了解HashMap Hashtable TreeMap LinkedHashMap ConcurrentHashMap的区别
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("k1", "v1");
		map.put("k2", "v1");
		map.put("k3", "v3");
		map.put("k1", "v4");
		map.put(null, null);
		System.out.println(map.size());
		System.out.println(map);

		System.out.println("遍历方法一(keySet迭代器遍历)");
		Set<String> keySet = map.keySet();
		Iterator<String> iterator = keySet.iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			System.out.printf("key:%s value:%s\n", key, map.get(key));
		}

		System.out.println("遍历方法一(entrySet迭代器遍历)");
		Set<Entry<String, String>> entrySet = map.entrySet();
		Iterator<Entry<String, String>> entryIterator = entrySet.iterator();
		while (entryIterator.hasNext()) {
			Entry<String, String> entry = entryIterator.next();
			System.out.printf("key:%s value:%s\n", entry.getKey(), entry.getValue());
		}
	}

}
