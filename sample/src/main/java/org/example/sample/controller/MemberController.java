package org.example.sample.controller;

import lombok.RequiredArgsConstructor;
import org.example.sample.entity.Member;
import org.example.sample.request.SignUpRequest;
import org.example.sample.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/signup") // 조회
    public String signUp(Model model) {
        model.addAttribute("signUpRequest", new SignUpRequest());
        return "members/createMemberForm";
    }

    @PostMapping("/signup") // 생성
    public String signUp(SignUpRequest request, Model model) {
        memberService.signUp(request);
        List<Member> members = memberService.findMembers();

        model.addAttribute("members", members);
        return "members/memberList";
    }
}
