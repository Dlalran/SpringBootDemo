package priv.howard.SpringBootDemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import priv.howard.SpringBootDemo.dao.StudentDao;
import priv.howard.SpringBootDemo.service.StudentService;

/**
 * 通过@Configuration指定该类为配置类
 */
@Configuration
public class MyConfig {

    /**
     * 通过@Bean来注入Bean，原xml形式<bean>标签中的class对应返回值类型，id对应方法
     */
    @Bean
    public StudentService studentService() {
        StudentService studentService = new StudentService();

//        注入内部属性时，创建对象并赋给该Bean对象（通过Setter或直接在构造方法中加入），相当于xml形式的<property>
        StudentDao studentDao = new StudentDao();
        studentService.setStudentDao(studentDao);

        return studentService;
    }
}
