package org.example.sample.service;

import lombok.RequiredArgsConstructor;
import org.example.sample.entity.Member;
import org.example.sample.repository.MemberRepository;
import org.example.sample.request.SignUpRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public void signUp(SignUpRequest request) {
        try {
            Member member = Member.builder()
                    .id(request.getId())
                    .password(request.getPassword())
                    .name(request.getName())
                    .build();

            memberRepository.save(member);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Member> findMembers() {
        try {
            return memberRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
