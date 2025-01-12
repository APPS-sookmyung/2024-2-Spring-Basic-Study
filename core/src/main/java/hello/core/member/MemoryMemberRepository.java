package hello.core.member;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class MemoryMemberRepository implements MemberRepository {
    private static Map<Long, Member> store = new ConcurrentHashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member); //오류처리는 스킵
    }

    @Override
    public Member findById(Long  memberId){
        return store.get(memberId);
    }
}
