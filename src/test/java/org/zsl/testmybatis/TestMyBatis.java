package org.zsl.testmybatis;

import javax.annotation.Resource;

import com.cn.hnust.util.TestUtil;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.cn.hnust.pojo.User;
import com.cn.hnust.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})

public class TestMyBatis {
	private static Logger logger = Logger.getLogger(TestMyBatis.class);
//	private ApplicationContext ac = null;
	@Resource
	private IUserService userService = null;

//	@Before
//	public void before() {
//		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//		userService = (IUserService) ac.getBean("userService");
//	}

	@Test
	public void test1() {
		User user = userService.getUserById(1);
		// System.out.println(user.getUserName());
		// logger.info("值："+user.getUserName());
		logger.info(JSON.toJSONString(user));
	}

	@Test
	public void testPost(){
		String url = "http://report.testehaier.com/api_690/product/getSingleProduct.html";
		String param = "appKey=690&productId=2555&sign=22be2aade041b543c8045deb651a7b28";
		String post = TestUtil.sendPost(url, param);
		System.out.println(post);
		System.out.println("----------------------------------");
	}
}
