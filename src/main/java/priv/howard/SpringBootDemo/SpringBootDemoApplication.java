package priv.howard.SpringBootDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * 添加@SpringBootApplication指定该类为SpringBoot的主配置类，并实现SpringBoot的自动配置
 * 该注解中包含:1、@SpringBootConfiguration:包含@Configuration，作用是指定该类为Spring配置类(代替xml)
 * 			   2、@EnableAutoConfiguration:1.包含@AutoConfigurationPackage -> @Import(AutoConfigurationPackages.Registrar.class)，自动引入自定义类，将主配置类(即该类)所在包及其子包所有类纳入Spring容器中
 * 			    						   2.包含@Import(AutoConfigurationImportSelector.class)，自动引入第三方依赖，根据spring-boot-test-autoconfigure-2.2.2.RELEASE.jar\META-INF\spring.factories
 * 			    						     该文件中的各个自动配置类AutoConfiguration通过以@Conditional开头的注解判断进行自动配置的条件是否成立（如是否有自定义配置等）
 * 			    						     可以在application.properties中通过对于AutoConfiguration中@EnableConfigurationProperties指定的类中的@ConfigurationProperties指定的prefix加.(内部类).属性名= 来指定自定义配置
 * 			    						     如{@link org.springframework.boot.autoconfigure.http.HttpProperties}中的spring.http(前面为prefix).encoding(内部类).charset(属性名)=GBK(自定义属性值)
 * 			   3、@ComponentScan，扫描指定包内带有注解的类，还可以指定过滤器filter来排除或包含组件
 */
@SpringBootApplication

/**
 * 通过@ImportSource引入自定义的配置文件(如Spring配置文件），参数value/locations通过String[]数组形式指定路径，注意添加{}
 * 不推荐该方式，因为SpringBoot实现对带有注解的类进行自动注入
 * 还可以通过配置类方式进行自定义注入{@link priv.howard.SpringBootDemo.config.MyConfig}
 */
//@ImportResource({"classpath:applicationContext.xml"})
public class SpringBootDemoApplication {
// 		在主配置类(或加了@Configuration的其他配置类)中写出方法,并在方法上添加@Bean,等于<bean id="方法名" class="返回值类型"/>
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}

}
