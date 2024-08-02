package com.kh.final_project.repository;

import com.kh.final_project.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByMemberId(String memberId);
    // 존재여부 확인
    boolean existsByMemberId(String memberId);
}
