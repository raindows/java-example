package org.java.core.day0806;

public abstract class AbstractFruit implements Fruit {

	public String description() {
		StringBuilder builder = new StringBuilder();
		builder.append("【");
		builder.append(this.getFactory());
		builder.append("】工厂加工处理了水果,水果名称\n【");
		builder.append(this.getName());
		builder.append("】,当前水果的历史如下\n【");
		builder.append(this.getHistory());
		builder.append("】");
		return builder.toString();
	}

	protected abstract String getFactory();
	
}
