package org.java.core.day0815;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * 展示使用注解方式标记扫描的类。
 *
 * @author victor
 * @see ComponentScanInJava
 */
// @Configuration
@ComponentScan(basePackages = "org.java.core.day0815")
public class AnnotationComponentScan {
	private static final Logger log = LoggerFactory.getLogger(AnnotationComponentScan.class);

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AnnotationComponentScan.class);
		// Job job = (Job) ctx.getBean("teacher");
		Job job = (Job) ctx.getBean("police");
		log.debug(job.work());
	}
}
