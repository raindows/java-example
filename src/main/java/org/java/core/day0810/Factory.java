package org.java.core.day0810;

//工厂接口
public interface Factory<E> {

	// 工厂默认的最大库存容量
	int DEFAULT_MAX_CAPACITY = 10;

	// 生产商品
	void produce(E value);

	// 销售商品
	E consume();

}
