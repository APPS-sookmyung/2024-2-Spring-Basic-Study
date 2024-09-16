package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello") //url 매칭
    public String hello(Model model){ //model(data:hello!!)
        model.addAttribute(  "data",  "hello!!"); //데이터에 저장된 값==hello!!
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; //Body에 데이터를 그대로 직접 넣음
    }

    @GetMapping("hello-api")
    @ResponseBody //json방식
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name); //value
        return hello; //객체를 넘김(문자가 아님!!)-> 스프링에서 json스타일로 데이터를 만들어서 html응답에 반환
    }
    static class Hello {
        private String name; //key

        public String getName() {
            return name;
        } //get set메소드를 통해 접근(property)
        public void setName(String name) {
            this.name = name;
        }
    }
}
//컨트롤러에서 리턴값으로 문자를 반환하면
//viewResolver 에서 스프링이 templates/hello.html를 찾아서 타임리프 템츨릿 엔진처리->웹브라우저로 반환