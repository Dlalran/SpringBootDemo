package priv.howard.SpringBootDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
    @ResponseBody
    @RequestMapping("helloSpringBoot")
    public String helloSpringBoot() {
        return "Hello SpringBoot Web!";
    }
}
