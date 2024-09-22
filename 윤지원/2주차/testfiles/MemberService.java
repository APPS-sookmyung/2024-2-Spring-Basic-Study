package act.act_spring.service;
import act.act_spring.domain.Member;
import act.act_spring.repository.MemberRepository;
import act.act_spring.repository.MemoryMemberRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    /**
     * 회원가입 : memberRepository 에 호출만 하면 됨 .
     * 같은 이름인 중복 회원은 X.
     * optional을 바로 반환한느건 좋지 않음. 어차피 result 가 반환이 되기 때문에 , 바로 ifpresent 가 들어갈 수 있다.
     * 단축키: ctl+T :extract method (맥북) . extract method valiDateDulicateMember
     * 외부에서 직접 넣어주도록 MemberService(MemberRepository memberRepository)
     */
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository=memberRepository;
    }
    public Long join(Member member) {
        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> { //if member has value
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
    /**
     * 전체 회원 조회
     * 서비스클래스는 비즈니스에서 쓰이는 이름을 써야 함. 레포지토리는 단순히 개발적으로용어들을 선택 가능. 단순히 데이터를 담는 용도이기 때문
     *
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
