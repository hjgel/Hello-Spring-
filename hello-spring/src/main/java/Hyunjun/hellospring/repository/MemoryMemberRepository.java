package Hyunjun.hellospring.repository;

import Hyunjun.hellospring.domain.Member;

import java.util.*;


public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence); // sequence번호를 올려주고(id값 세팅)
        store.put(member.getId(), member); // store에다가 저장 후
        return member; // 반환
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); // Optional.ofNullable : Null이어도 반환되게 해줌.
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream().filter(member -> member.getName().equals(name)).findAny(); // 루프 돌면서 하나 찾아지면 바로 반환해주는 시스템.

    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear(); // 스토어를 싹 비워줌
    }

}
