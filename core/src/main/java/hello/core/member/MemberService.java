package hello.core.member;

public interface MemberService {
    //회원 가입, 회원 조회
    Member findMember(Long MemberID);
    void join(Member member);

}
