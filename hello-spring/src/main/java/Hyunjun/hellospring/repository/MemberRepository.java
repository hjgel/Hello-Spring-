package Hyunjun.hellospring.repository;

import Hyunjun.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); // 회원이 저장소에 저장.
    Optional<Member> findById(Long id); // id를 찾기 위해 만듦.
    Optional<Member> findByName(String name); // name을 찾아오기 위해 만듦.
    List<Member> findAll();
}
