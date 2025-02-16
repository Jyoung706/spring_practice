package com.hellospring.hellospring;

import com.hellospring.hellospring.repository.JdbcMemberRepository;
import com.hellospring.hellospring.repository.JpaMemberRepository;
import com.hellospring.hellospring.repository.MemberRepository;
import com.hellospring.hellospring.repository.MemoryMemberRepository;
import com.hellospring.hellospring.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository() {
//        return new JdbcMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//    }
}
