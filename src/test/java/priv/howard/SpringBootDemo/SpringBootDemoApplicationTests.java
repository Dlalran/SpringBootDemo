package priv.howard.SpringBootDemo;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import priv.howard.SpringBootDemo.entity.Student;
import priv.howard.SpringBootDemo.service.StudentService;

@SpringBootTest
class SpringBootDemoApplicatonTests {
	/**
	 * @Description SpringBoot测试类
	 */

//	测试注入application.yml中注入的实体类
	@Autowired
	Student student;
	@Test
	void contextLoads() {
		System.out.println(student);
	}

//	自动注入Spring上下文（容器）
	@Autowired
	ApplicationContext applicationContext;
//	测试自定义Spring配置文件
	@Test
	void testCustomizeConfig() {
//		该类以及其属性都通过自定义配置注入，未添加注解
		StudentService studentService = applicationContext.getBean("studentService", StudentService.class);
		System.out.println(studentService);
		System.out.println(studentService.getStudentDao());
	}

//	Spring默认使用的日志实现是slf4j和logback
//	通过反射从slf4j中的LoggerFactory获得logger
	Logger logger =  LoggerFactory.getLogger(SpringBootDemoApplicatonTests.class);
	@Test
	void testLogger() {
//		测试日志级别，在当前级别以及之上的信息才会被打印，默认是info，可以在配置文件中定义
		logger.trace("trace...");
		logger.debug("debug...");
		logger.info("info...");
		logger.warn("warn...");
		logger.error("error...");
	}
}
