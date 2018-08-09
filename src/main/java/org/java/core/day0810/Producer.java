package org.java.core.day0810;

//生产者 实现接口 java.lang.Runnable
public class Producer<E> implements Runnable {

	private Factory<E> factory;

	private E value;

	public Producer(Factory<E> factory, E value) {
		this.factory = factory;
		this.value = value;
	}

	@Override
	public void run() {
		produce();
	}

	private void produce() {
		factory.produce(value);
	}

}
