package org.java.core.day0806;

public class Orange extends AbstractFruit {

	{
		System.out.println("\t构造代码块Orange-A");
	}

	public Orange() {
		//super();
		System.out.println("\tOrange无参数构造器实例化");
	}

	{
		System.out.println("\t构造代码块Orange-B");
	}

	static {
		System.out.println("\tOrange静态代码块执行");
	}

	@Override
	public String getName() {
		return "橙子";
	}

	@Override
	public String getHistory() {
		return "橙子（学名：Citrus sinensis 英语：orange），是芸香科柑橘属植物橙树的果实，亦称为黄果、柑子、金环、柳丁。橙子是一种柑果，有很高的食用，药用价值。";
	}

	@Override
	protected String getFactory() {
		return "XX橙子水果公司";
	}

}
