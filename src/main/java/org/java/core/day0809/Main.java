package org.java.core.day0809;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * http://www.open-open.com/jsoup/load-document-from-url.htm
 * 
 * @author xiaoyu.wang
 */
// 网络爬虫
public class Main {

	public static void main(String[] args) throws Exception {
		 parseMain();
		// parseSubHtml(0,"http://science.ecust.edu.cn/2013/0614/c5567a38625/page.htm");
		// System.out.println("==========");
		//parseSubHtml(0, "http://science.ecust.edu.cn/2013/0618/c5567a38786/page.htm");
	}

	private static void parseMain() throws Exception {
		Document doc = Jsoup.connect("http://science.ecust.edu.cn/5528/list.htm").get();
		String title = doc.title();
		// System.out.println(title);

		// System.out.println("\n===================\n");
		// System.out.println(doc.toString());

		Element body = doc.body();
		// System.out.println("\n===================\n");
		// System.out.println(body);

		// System.out.println("\n===================\n");
		Element wp_content_w6_0 = body.getElementById("wp_content_w6_0");
		// System.out.println(wp_content_w6_0);
		Elements links = wp_content_w6_0.select("a");// 查找第一个a元素
		// System.out.println(links);

		int size = links.size();
		for (int i = 0; i < size; i++) {
			Element link = links.get(i);
			// System.out.println(link);
			String linkHref = link.attr("href"); // 取得链接地址
			String linkText = link.text(); // 取得链接地址中的文本
			// System.out.println(linkText + "\t" + linkHref);
			String contact = parseSubHtml(i + 1, linkHref);
			// System.out.println(linkText + ":\t" + contact);
		}

	}

	private static String parseSubHtml(int orderNum, String linkHref) throws Exception {
		Document doc = Jsoup.connect(linkHref).get();
		String title = doc.title();
		System.out.println(orderNum + "、" + title + "\t\t" + linkHref);

		Element body = doc.body();
		// //System.out.println(body);
		//
		// Element infocontent = body.getElementById("infocontent");
		// if (infocontent == null) {
		// System.out.println("infocontent is null");
		// return null;
		// }
		//
		// //Elements Article_Content =
		// infocontent.getElementsByClass("Article_Content");
		// // System.out.println(Article_Content);

		Elements divs = body.select("div");
		// System.out.println(divs.size());
		// System.out.println(p);
		String contact = "";
		for (int i = 0; i < divs.size(); i++) {
			String text = divs.get(i).text();
			if (text.contains("联络方式") ) {
				contact = text.substring(text.indexOf("联络方式"),text.indexOf("Copyright"));
				break;
			}
			if (text.contains("联系方式") ) {
				contact = text.substring(text.indexOf("联系方式"),text.indexOf("Copyright"));
				break;
			}
		}
		System.out.println(contact+"\n");
		return contact;
	}

}
