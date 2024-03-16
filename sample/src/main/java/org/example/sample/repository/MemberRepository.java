package org.example.sample.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.example.sample.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager entityManager;
    private final MemberRepositoryInterface memberRepositoryInterface;


    public void save(Member member) {
        entityManager.persist(member);
    }

    public Member findOne(Long id) {
        return entityManager.find(Member.class, id);
    }

    public List<Member> findAll() {
        // JPQL perform query based on entity.

        return memberRepositoryInterface.findAll();

//        return entityManager.createQuery("select m from Member m", Member.class)
//                .getResultList();
    }
}
