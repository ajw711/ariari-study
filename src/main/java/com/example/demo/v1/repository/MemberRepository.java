package com.example.demo.v1.repository;

import com.example.demo.v1.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberRepository extends JpaRepository<Member, Long> {

}
