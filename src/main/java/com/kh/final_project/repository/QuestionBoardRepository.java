package com.kh.final_project.repository;

import com.kh.final_project.entity.Member;
import com.kh.final_project.entity.QuestionBoard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface QuestionBoardRepository extends JpaRepository<QuestionBoard, Long> {

    Optional<QuestionBoard> findById(Long id);
    List<QuestionBoard> findByMember(Member member);
}
