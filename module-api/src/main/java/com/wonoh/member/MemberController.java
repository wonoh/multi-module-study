package com.wonoh.member;

import com.wonoh.common.model.Member;
import com.wonoh.common.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;

    @GetMapping
    public ResponseEntity getMember(){

        Member member = Member.builder()
                        .name("test")
                        .build();

        return ResponseEntity.ok(memberRepository.save(member));

    }
}
