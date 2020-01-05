package priv.howard.SpringBootDemo.service;

import priv.howard.SpringBootDemo.dao.StudentDao;

public class StudentService {
    /**
     * 模拟Service层组件，未添加注解，因此不被SpringBoot自动注入，通过自定义Spring配置文件applicationContext.xml注入
     */
    private StudentDao studentDao;

    public StudentDao getStudentDao() {
        return studentDao;
    }

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
}
