package hello.helloSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")    // url주소상 매핑
    public String hello(Model model){
        model.addAttribute("date","hello!!");
                            //thymeleaf사용하여 값 넘겨주는 과정
        return "hello";     //경로 지정
    }


}
