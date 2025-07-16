package com.example.demo.v1.controller;

import com.example.demo.v1.domain.Member;
import com.example.demo.v1.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/api/get")
    public List<Member> getAllMembers() {
        log.info("→ [Controller] getAllMembers 호출됨");
        List<Member> memberList = memberService.getAllMembers();
        log.info("→ [Controller] getAllMembers 종료");
        return memberList;
    }

    @PostMapping("/api/save")
    public Member createMember(@RequestBody Member member) {;
        log.info("→ [Controller] createMember 호출됨");
        Member saved = memberService.save(member);
        log.info("← [Controller] createMember 종료");
        return saved;
    }
}
