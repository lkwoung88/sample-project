package org.example.sample.repository;

import org.example.sample.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepositoryInterface extends JpaRepository<Member, String> {

    @Override
    List<Member> findAll();
}
