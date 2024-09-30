package hello.hello_spring.controller;

import hello.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;

     @Autowired //연결을 시켜줌
     public MemberController(MemberService memberService){
         this.memberService=memberService;
     }  // 멤버 컨트롤러가 생성될때 스프링 빈에 등록되어있는 멤버 서비스 객체를 넣어줌
} // 스프링 통이 생김->컨트롤러 @Autowired 가 있으면 멤버 컨트롤러 객체!를 생성해서 스프링에 넣어 관리
// 스프링 컨테이너에 하나 등록하여 돌려 씀
// 웬만하면 생성자 주입을 쓰자