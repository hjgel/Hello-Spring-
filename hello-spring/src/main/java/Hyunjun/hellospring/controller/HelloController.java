package Hyunjun.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!");
        return "hello";
    }

    @GetMapping("hello-mvc")
        public String helloMvc(@RequestParam("name") String name, Model model) {
        // @RequestParam : Http요청 파라미터의 이름으로 바인딩하여 그 값을 변수에 저장.
        // Model에서 name을 받고 그 name을 "name"에 대입하여 hello-template에 보냄.
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) { // RequestParam = 사용자가 입력한대로 출력.
        // hello-spring?name=~~~
        return "hello " + name; // "hello spring"
    }

    @GetMapping("hello-api")
    @ResponseBody // http에 body부에 직접 값을 넣어주겠다는 뜻.
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    } // json 방식 {key : value} 방식으로 구성됨.

    static class Hello {
        // 프로퍼티 접근방식
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
