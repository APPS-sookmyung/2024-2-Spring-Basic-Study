package hello.hello_spring;


import hello.hello_spring.aop.TimeTraceAop;
import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.JdbcMemberRepository;
import hello.hello_spring.repository.JpaMemberRepository;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;
import hello.hello_spring.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import jakarta.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {
//    private final DataSource dataSource;
////    public SpringConfig(DataSource dataSource) {
////        this.dataSource = dataSource;
////    }
//    private final EntityManager em;
//
//    @Autowired
//    public SpringConfig(DataSource dataSource, DataSource dataSource1, EntityManager em){
//        this.dataSource = dataSource1;
//        this.em=em;
//    }
    private final MemberRepository memberRepository;
    @Autowired
    public SpringConfig(MemberRepository memberRepository){
        this.memberRepository=memberRepository;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    } // 스프링 빈에 등록

    @Bean
    public TimeTraceAop TimeTraceAop(){
        return new TimeTraceAop();
    }
//    @Bean
//    public MemberRepository memberRepository(){
//     return new MemoryMemberRepository();
//    return new JdbcMemberRepository(dataSource) { //다형성을 활용. 인터페이스를 두고 구현체를 바꿔끼는 것이 가능
//           @Override
//          public void clearStore() {
//         }
//        };
//       return new JpaMemberRepository(em);
//    } // 스프링 빈에 등록
} // 등록된 멤버 리포지토리를 멤버 서비스에 넣어줌
