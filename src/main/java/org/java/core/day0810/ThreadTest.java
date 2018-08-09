package org.java.core.day0810;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadTest {

	// 日志 配置在log4j.properties pom.xml引入相应的依赖jar包
	private static final Logger LOG = LoggerFactory.getLogger(ThreadTest.class);

	public static void main(String[] args) {
		LOG.info("{} {} {} {}", Thread.currentThread().getName(), Thread.currentThread().getId(),
				Thread.currentThread().getPriority(), Thread.currentThread().getContextClassLoader());

		for (int i = 0; i < 20; i++) {
			new ThreadImpl01().start();
		}
		for (int i = 0; i < 20; i++) {
			new Thread(new ThreadImpl02(), "自定义线程名称").start();
		}

		LOG.info("{} {} {} {}", Thread.currentThread().getName(), Thread.currentThread().getId(),
				Thread.currentThread().getPriority(), Thread.currentThread().getContextClassLoader());
	}

}

class ThreadImpl01 extends Thread {

	@Override
	public void run() {
		Thread thread = Thread.currentThread();
		System.out.printf("%s %s\n", thread.getName(), thread.getId());
	}

}

class ThreadImpl02 implements Runnable {

	@Override
	public void run() {
		Thread thread = Thread.currentThread();
		System.out.printf("%s %s\n", thread.getName(), thread.getId());
	}

}
