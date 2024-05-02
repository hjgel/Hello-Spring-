package Hyunjun.hellospring;

import Hyunjun.hellospring.repository.MemberRepository;
import Hyunjun.hellospring.repository.MemoryMemberRepository;
import Hyunjun.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
