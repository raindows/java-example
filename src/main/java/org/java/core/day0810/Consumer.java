package org.java.core.day0810;

//消费者继承 java.lang.Thread
public class Consumer<E> extends Thread {

	private Factory<E> factory;

	public Consumer(Factory<E> factory) {
		this.factory = factory;
	}

	@Override
	public void run() {
		this.consume();
	}

	private E consume() {
		E value = factory.consume();
		return value;
	}
}
