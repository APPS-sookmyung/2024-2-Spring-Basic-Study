package hello.core.member;

public class MemberServiceImpl implements MemberService{
    //가입을 하려면 memberrepository가 필요함
    private final MemberRepository memberRepository= new MemoryMemberRepository();

    public MemberServiceImpl(MemoryMemberRepository memoryMemberRepository) {
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member); //오버라이드 한 게 호출됨
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
