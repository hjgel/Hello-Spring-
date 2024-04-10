package Hyunjun.hellospring.service;

import Hyunjun.hellospring.domain.Member;
import Hyunjun.hellospring.repository.MemberRepository;
import Hyunjun.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 회원 가입
    public Long join(Member member) {
        // 같은 이름이 있는 중복 회원 X
        // null일 가능성이 있으면 Optional로 한번 감싸줌
        extracted(member); // 중복회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void extracted(Member member) {
        // 같은 이름이 있는 중복 회원 X
        // null일 가능성이 있으면 Optional로 한번 감싸줌
        memberRepository.findByName(member.getName()).ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    // 전체 회원 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
