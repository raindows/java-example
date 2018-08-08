package org.java.core.day0809;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Jsoup001 {

	public static void main(String[] args) {
		String html = "<html><head><title>First parse</title></head>"
				+ "<body><p>Parsed HTML into a doc.</p></body></html>";
		Document doc = Jsoup.parse(html);
		System.out.println(doc);

		System.out.println("\n===================\n");
		Element head = doc.head();
		System.out.println(head);

		System.out.println("\n===================\n");
		Element body = doc.body();
		System.out.println(body);
	}

}
