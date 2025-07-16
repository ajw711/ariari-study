package com.example.demo.v1.service;

import com.example.demo.v1.domain.Member;
import com.example.demo.v1.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public List<Member> getAllMembers() {
        log.info("→ [Service] getAllMembers 호출됨");
        List<Member> memberList = memberRepository.findAll();
        log.info("← [Service] getAllMembers 종료");
        return  memberList;
    }

    @Transactional
    public Member save(Member member) {
        log.info("→ [Service] save 호출됨");
        Member saved = memberRepository.save(member);
        log.info("← [Service] save 종료");
        return saved;
    }
}
