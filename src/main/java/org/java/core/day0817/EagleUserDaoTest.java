package org.java.core.day0817;

import org.java.core.day0817.db.entity.EagleUser;
import org.java.core.day0817.service.EagleUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

/**
 * http://www.mybatis.org/mybatis-3/zh/index.html
 * 
 * http://www.mybatis.org/generator/quickstart.html
 * 
 * @author xiaoyu.wang
 */
@RunWith(SpringJUnit4ClassRunner.class) // 表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:mybatis-spring.xml" })
public class EagleUserDaoTest {

	@Autowired
	private EagleUserService eagleUserService;

	@Test
	public void testSelect() {
		EagleUser eagleUser = eagleUserService.selectByPrimaryKey(Long.parseLong("1"));
		System.out.println(JSON.toJSONString(eagleUser));
	}

	@Test
	public void test() {
		System.out.println(eagleUserService.getClass().getName());
		EagleUser eagleUser = eagleUserService.selectByPrimaryKey((long) 5);
		System.err.println(eagleUser.getUserName() + "\t" + JSON.toJSONString(eagleUser));

		try {
			eagleUser.setUserName("胡五");
			int update = eagleUserService.updateByPrimaryKeySelective(eagleUser);
			System.err.println(update);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		eagleUser = eagleUserService.selectByPrimaryKey((long) 5);
		System.err.println(eagleUser.getUserName() + "\t" + JSON.toJSONString(eagleUser));
	}
}
