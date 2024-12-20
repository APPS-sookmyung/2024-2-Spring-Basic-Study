package hello.hello_spring.service;
import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    } // 스프링 컨테이너에 멤버 서비스 등록

    /**
     * 회원가입
     */
    public Long join(Member member) {
            validateDuplicateMember(member); //같은 이름이 있는 중복 회원x
            memberRepository.save(member);
            return member.getId();
    }
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName()) //optional 빼기
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
         return memberRepository.findAll();
    }
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
