package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import jakarta.persistence.EntityManager;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{

    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member; // jpa가 insert 쿼리 만들고 아이디set도 해줌
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() { //멤버 자체를 select
        return em.createQuery("select m from Member m", Member.class)
                .getResultList(); //특별한 객체지향 쿼리 씀 객체를 대상으로 쿼리를 날림
    }

    @Override
    public void clearStore() {

    }
}
