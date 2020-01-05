package priv.howard.SpringBootDemo.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 注意：使用@ConfigurationProperties注解IDEA提示错误，可在maven中加入依赖(见pom.xml)，不处理也不会影响执行
 * 原因是SpringBoot1.5后该注解取消location属性，默认从src/main/resource/application.properties(yml)中寻找注入的属性
 * 而IDEA仍提示未指定获取属性的路径
 */

//开启JSR303属性校验
@Validated

/**
 * 两个注解配合使用，@Component将其纳入Spring容器，@ConfigurationProperties指定在application.properties(yml)中的变量名
 * properties和yml文件对同一对象注入属性时会互补，如果重复则properties优先级高于yml
 * @ConfigurationProperties还支持变量名的驼峰转松散语法，例如homeAddress属性可以写成home-address
 * 还支持JSR303属性校验
 * 注意：prefix参数必须全部小写并以-连接单词
 */
@Component
@ConfigurationProperties(prefix = "student")
/**
 * 通过@PropertySource指定在application.properties(yml)中找不到prefix指定对象(或其中的属性)时，在指定路径的资源文件(仅限properties)中寻找
 * 注意：value值为Spring[]数组，在路径外添加{}，并且不支持yml类型
 */
@PropertySource({"classpath:test.properties"})
public class Student {
    /**
     * 通过@Value也可以单独注入对象的属性，优先级低于@ConfigurationProperties
     * 支持SpringEL获得属性值，但不支持JSR303校验和复杂类型属性注入
     */
//    @Value("howard")
//    @Value("${student.name}")
    private String name;
    private int age;
    private boolean sex ;
    private Date birthday;
    private Map<String, String> address;
    private String[] hobbies;
    private List<String> skills;
    private Pet pet;

//    进行JSR303 Email属性校验
    @Email
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Map<String, String> getAddress() {
        return address;
    }

    public void setAddress(Map<String, String> address) {
        this.address = address;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", address=" + address +
                ", hobbies=" + Arrays.toString(hobbies) +
                ", skills=" + skills +
                ", pet=" + pet +
                ", email='" + email + '\'' +
                '}';
    }
}
