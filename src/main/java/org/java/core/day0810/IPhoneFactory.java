package org.java.core.day0810;

import java.util.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//苹果制造工厂
public class IPhoneFactory<E> implements Factory<E> {

	// 日志
	private static final Logger LOG = LoggerFactory.getLogger(IPhoneFactory.class);

	// 库存最大容量
	private int maxSize;

	// 库存集合
	private final LinkedList<E> list = new LinkedList<E>();

	public IPhoneFactory(int maxSize) {
		if (maxSize <= 0) {
			maxSize = DEFAULT_MAX_CAPACITY;
		}
		this.maxSize = maxSize;
	}

	@Override
	public void produce(E value) {
		synchronized (list) {
			while (list.size() >= maxSize) {
				try {
					LOG.info("produce thread wait,list size:{},value:{}", list.size(), value);
					list.wait();
				} catch (InterruptedException e) {
					LOG.error(e.getMessage(), e);
				}
			}
			list.add(value);
			list.notifyAll();
			LOG.info("produce notifyAll thread,list size:{},produce-value:{},list:{}", list.size(), value, list);
		}
	}

	@Override
	public E consume() {
		synchronized (list) {
			while (list.size() == 0) {
				try {
					LOG.info("consume thread wait,list size:{}", list.size());
					list.wait();
				} catch (InterruptedException e) {
					LOG.error(e.getMessage(), e);
				}
			}
			E value = list.remove();
			list.notifyAll();
			LOG.info("consume notifyAll thread,list size:{}, consume-value:{},list:{}", list.size(), value, list);
			return value;
		}
	}

}
