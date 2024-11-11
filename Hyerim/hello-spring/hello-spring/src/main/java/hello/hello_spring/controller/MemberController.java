package hello.hello_spring.controller;

import hello.hello_spring.domain.Member;
import hello.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

     @Autowired //연결을 시켜줌
     public MemberController(MemberService memberService){
         this.memberService=memberService;
         System.out.println("memberService = "+memberService.getClass()); // 여기에 프록시가 뜸
     }

     @GetMapping("/members/new")
     public String createForm(){
         return "members/createMemberForm";
     }

     @PostMapping("/members/new") // PostMapping은 데이터를 폼에 넣어서 전달할때, Get은 조회할때
     public String create(MemberForm form){
         Member member = new Member();
         member.setName(form.getName());

         memberService.join(member);

         return "redirect:/";
     }

     @GetMapping(value = "/members")
     public String list(Model model){
         List<Member> members = memberService.findMembers();
         model.addAttribute("members", members);
         return "members/memberList";
     }
}

// 멤버 컨트롤러가 생성될때 스프링 빈에 등록되어있는 멤버 서비스 객체를 넣어줌
// 스프링 통이 생김->컨트롤러 @Autowired 가 있으면 멤버 컨트롤러 객체!를 생성해서 스프링에 넣어 관리
// 스프링 컨테이너에 하나 등록하여 돌려 씀
// 웬만하면 생성자 주입을 쓰자