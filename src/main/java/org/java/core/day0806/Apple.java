package org.java.core.day0806;

public class Apple extends AbstractFruit {

	@Override
	public String getName() {
		return "苹果";
	}

	@Override
	public String getHistory() {
		return "苹果（学名：Malus pumila）是水果的一种，是蔷薇科苹果亚科苹果属植物，其树为落叶乔木。苹果的果实富含矿物质和维生素，是人们经常食用的水果之一。";
	}

	@Override
	protected String getFactory() {
		return "XX苹果食品公司";
	}

}
