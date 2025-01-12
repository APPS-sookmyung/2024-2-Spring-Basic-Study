package hello.core.member;

public interface MemberRepository {
    //회원 저장, 회원 찾기
    void save(Member member);
    Member findById(Long memberId);


}
