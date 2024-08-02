package com.kh.final_project.service;

import com.kh.final_project.dto.MemberDto;
import com.kh.final_project.dto.QuestionBoardDto;
import com.kh.final_project.entity.QuestionBoard;
import com.kh.final_project.repository.MemberRepository;
import com.kh.final_project.repository.QuestionBoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class QuestionBoardService {
    private final QuestionBoardRepository questionBoardRepository;
    private final ModelMapper modelMapper;
    private final MemberRepository memberRepository;



    // Build 패턴을 사용 한 글작성
    public QuestionBoardDto createPost(MemberDto memberDto, QuestionBoardDto questionBoardDto){
        // Dto > Entity
        QuestionBoard entity = QuestionBoard.toEntitiy(questionBoardDto);
        log.info("Dto를 entitiy로 변환 : " + entity.toString());
        // 글 저장
        QuestionBoard saveEntity = questionBoardRepository.save(entity);
        log.info("entitiy 저장 : " +saveEntity.toString());
        // Entity > Dto
        QuestionBoardDto dto = QuestionBoardDto.toDto(saveEntity);
        log.info("entitiy를 Dto로 변환 : " +dto);
        return dto;
    }
    // model Mapper를 사용한 글작성 서비스 코드
    public QuestionBoardDto createPost2(MemberDto memberDto, QuestionBoardDto questionBoardDto){
        // Dto > Entity
        QuestionBoard entitiy = modelMapper.map(questionBoardDto, QuestionBoard.class); // 첫번째는 바꿀 객체, 두번째는 변경할 타입
        // 글 저장
        QuestionBoard saveEntity = questionBoardRepository.save(entitiy);
        // Entity > Dto
        QuestionBoardDto dto = modelMapper.map(saveEntity, QuestionBoardDto.class);
        return dto;
    }
    // 리스트 타입으로 전체글 조회하기
    public  List<QuestionBoardDto> findAll(){
        // 조회
        List<QuestionBoard> entity = questionBoardRepository.findAll();
        // List 바인딩
        List<QuestionBoardDto> resultDto = entity.stream()
                .map(data -> modelMapper.map(data, QuestionBoardDto.class))
                .collect(Collectors.toList());
        return resultDto;
    }
}
//    // 글수정
//    public QuestionBoard updatePost(Member member, QuestionBoard updatedBoard) {
//        // 게시글 찾기
//        QuestionBoard isPost = questionBoardRepository.findById(updatedBoard.getId())
//                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 게시글을 찾을 수 없습니다: " + updatedBoard.getId()));
//        // 작성자 확인
//        if (!isPost.getMember().equals(member)) {
//            throw new IllegalArgumentException("수정 권한이 없습니다.");
//        }
//
//        // 제목과 내용 업데이트
//        isPost.setTitle(updatedBoard.getTitle());
//        isPost.setContents(updatedBoard.getContents());
//
//        // DB에 저장
//        QuestionBoard updatedPost = questionBoardRepository.save(isPost);
//        return updatedPost;
//    }
//
//    // 모든 글 조회
//    public List<QuestionBoard> findAllPosts() {
//        // 전체 게시글 중 논리적으로 삭제되지 않은 글만 조회
//        return questionBoardRepository.findAll()
//                .stream()
//                .filter(post -> !post.isDeleteYn())  // deleteYn이 false인 글만 필터링
//                .collect(Collectors.toList());
//    }
//    // 제목 또는 내용으로 글 조회
////    public QuestionBoard findPostById(QuestionBoard questionBoard) {
////        return questionBoardRepository.findById(postId)
////                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 게시글을 찾을 수 없습니다: " + postId));
////    }
//
//
//    // 내가 쓴 글만 조회
//    public List<QuestionBoard> findmyPosts(Member member){
//        List<QuestionBoard> myPosts = questionBoardRepository.findByMemberId(member);
//        // 논리적으로 삭제되지 않은 글만 필터링 deleteYn = false
//        return myPosts.stream()
//                .filter(post -> !post.isDeleteYn())
//                .collect(Collectors.toList());
//    }
//
//    // 글 삭제
//    public void deletePost(Member member, QuestionBoard questionBoard) {
//        QuestionBoard isPost = questionBoardRepository.findById(questionBoard.getId())
//                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 게시글을 찾을 수 없습니다: " + questionBoard.getId()));
//        // 작성자 확인
//        if (!isPost.getMember().equals(member)) {
//            throw new IllegalArgumentException("삭제 권한이 없습니다.");
//        }
//        // 실제로 삭제되지 않고 논리적 삭제 처리(DB보존위해) true로 되면 안보이게
//        isPost.setDeleteYn(true);
//        isPost.setDeleteTime(LocalDateTime.now());
//        questionBoardRepository.save(isPost);
//    }
