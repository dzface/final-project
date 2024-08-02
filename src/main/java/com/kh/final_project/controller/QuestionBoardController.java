package com.kh.final_project.controller;

import com.kh.final_project.dto.MemberDto;
import com.kh.final_project.dto.QuestionBoardDto;
import com.kh.final_project.entity.Member;
import com.kh.final_project.entity.QuestionBoard;
import com.kh.final_project.service.QuestionBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/support")
public class QuestionBoardController {
    private final QuestionBoardService questionBoardService;
    @PostMapping("/create-post")
    public ResponseEntity<QuestionBoardDto> createPost(@RequestBody QuestionBoardDto request){//Authentication authentication
        // DTO에서 Member와 QuestionBoard 객체 추출
        QuestionBoardDto createPost = questionBoardService.createPost(null, request);
        return ResponseEntity.ok(createPost);
    }
}
