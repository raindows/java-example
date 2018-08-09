package org.java.core.day0810;

import java.util.concurrent.TimeUnit;

public class ProducerConsumerTest {

	// 生产者消费者模式
	public static void main(String[] args) {

		Factory<String> factory = new IPhoneFactory<>(-1);

		test(factory);
	}

	private static void test(Factory<String> factory) {

		// 开启15个生产线程 每个线程生产1个商品
		for (int i = 0; i < 15; i++) {
			new Thread(new Producer<String>(factory, "iPhoneX#" + i)).start();
		}

		try {
			// 当前线程睡眠1秒钟
			TimeUnit.SECONDS.sleep(1);
			System.err.println("-----------sleep 1s start-----------");
			// 当前线程睡眠30秒钟
			TimeUnit.SECONDS.sleep(30);
			System.err.println("-----------sleep 30s end-----------");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// 开启20个消费线程 每个线程消费1个商品
		for (int i = 0; i < 20; i++) {
			new Thread(new Consumer<String>(factory)).start();
		}

		try {
			// 当前线程睡眠1秒钟
			TimeUnit.SECONDS.sleep(1);
			System.err.println("-----------sleep 1s start-----------");
			// 当前线程睡眠30秒钟
			TimeUnit.SECONDS.sleep(30);
			System.err.println("-----------sleep 30s end-----------");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// 开启10个生产线程 每个线程生产1个商品
		for (int i = 15; i < 25; i++) {
			new Thread(new Producer<String>(factory, "iPhone8#" + i)).start();
		}
	}

}
