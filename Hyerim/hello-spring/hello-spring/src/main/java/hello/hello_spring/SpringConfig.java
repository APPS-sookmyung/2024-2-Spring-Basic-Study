package hello.hello_spring;


import hello.hello_spring.repository.JdbcMemberRepository;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;
import hello.hello_spring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private final DataSource dataSource;
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    } // 스프링 빈에 등록

    @Bean
    public MemberRepository memberRepository(){
        //return new MemoryMemberRepository();
        return new JdbcMemberRepository(dataSource) { //다형성을 활용. 인터페이스를 두고 구현체를 바꿔끼는 것이 가능
            @Override
            public void clearStore() {

            }
        };
    } // 스프링 빈에 등록
} // 등록된 멤버 리포지토리를 멤버 서비스에 넣어줌
