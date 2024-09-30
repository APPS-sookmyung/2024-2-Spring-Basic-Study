package hello.hello_spring;


import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;
import hello.hello_spring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    } // 스프링 빈에 등록

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    } // 스프링 빈에 등록
} // 등록된 멤버 리포지토리를 멤버 서비스에 넣어줌
