package org.java.core.day0815;

import org.java.core.day0806.AbstractFruit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 展示 @Qualifier 的用法
 * <p>
 * 使用@Autowired时，当出现多个与类型匹配的候选集时，Spring不知道选哪个。这时可使用@Qualifier bean的名称来锁定需要的bean。
 *
 * @author victor
 */
public class AnnotationQualifier {
	private static final Logger log = LoggerFactory.getLogger(AnnotationQualifier.class);

	@Autowired
	@Qualifier("apple") /** 去除这行，会报异常 */
	AbstractFruit fieldA;

	AbstractFruit fieldB;

	@Autowired
	// @Resource
	AbstractFruit orange;

	public AbstractFruit getFieldA() {
		return fieldA;
	}

	public void setFieldA(AbstractFruit fieldA) {
		this.fieldA = fieldA;
	}

	public AbstractFruit getFieldB() {
		return fieldB;
	}

	public AbstractFruit getOrange() {
		return orange;
	}

	public void setOrange(AbstractFruit orange) {
		this.orange = orange;
	}

	@Autowired
	public void setFieldB(@Qualifier("banana") AbstractFruit fieldB) {
		this.fieldB = fieldB;
	}

	public static void main(String[] args) throws Exception {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("spring-demo.xml");

		AnnotationQualifier annotationQualifier = (AnnotationQualifier) ctx.getBean("annotationQualifier");

		log.debug("type: {}, name: {}", annotationQualifier.getFieldA().getClass(),
				annotationQualifier.getFieldA().getName());

		log.debug("type: {}, name: {}", annotationQualifier.getFieldB().getClass(),
				annotationQualifier.getFieldB().getName());

		log.debug("type: {}, name: {}", annotationQualifier.getOrange().getClass(),
				annotationQualifier.getOrange().getName());
		ctx.close();
	}
}
