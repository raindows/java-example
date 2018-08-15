package org.java.core.day0815;

import org.java.core.day0806.Apple;
import org.java.core.day0806.Banana;
import org.java.core.day0806.Orange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 展示 @Autowired 的用法
 * <p>
 * 
 * @Autowired 可用于修饰属性、setter 方法、构造方法。
 *            被@Autowired修饰的属性在初始化时，会自动匹配与其类型相符的bean。如果存在多个匹配的候选bean，Spring会报异常。
 *
 * @author victor
 */
public class AnnotationAutowired {
	private static final Logger log = LoggerFactory.getLogger(AnnotationAutowired.class);

	/** 修饰属性 */
	@Autowired
	private Apple fieldA;

	private Banana fieldB;

	private Orange fieldC;

	public Apple getFieldA() {
		return fieldA;
	}

	public void setFieldA(Apple fieldA) {
		log.info("setFieldA...");
		this.fieldA = fieldA;
	}

	public Banana getFieldB() {
		return fieldB;
	}

	/** 修饰setter方法 */
	@Autowired
	public void setFieldB(Banana fieldB) {
		log.info("setFieldB...");
		this.fieldB = fieldB;
	}

	public Orange getFieldC() {
		return fieldC;
	}

	public void setFieldC(Orange fieldC) {
		log.info("setFieldC...");
		this.fieldC = fieldC;
	}

	public AnnotationAutowired() {
		log.info("AnnotationAutowired无参构造器...");
	}

	/** 修饰构造方法 */
	@Autowired
	public AnnotationAutowired(Orange fieldC) {
		log.info("AnnotationAutowired有参构造器...");
		this.fieldC = fieldC;
	}

	public static void main(String[] args) throws Exception {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("spring-demo.xml");

		AnnotationAutowired annotationAutowired = (AnnotationAutowired) ctx.getBean("annotationAutowired");

		log.debug("type: {}, name: {}", annotationAutowired.getFieldA().getClass(),
				annotationAutowired.getFieldA().getName());

		log.debug("type: {}, name: {}", annotationAutowired.getFieldB().getClass(),
				annotationAutowired.getFieldB().getName());

		log.debug("type: {}, name: {}", annotationAutowired.getFieldC().getClass(),
				annotationAutowired.getFieldC().getName());
		ctx.close();
	}
}
