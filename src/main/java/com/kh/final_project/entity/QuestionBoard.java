//QuestionBoard.java
package com.kh.final_project.entity;

import com.kh.final_project.dto.QuestionBoardDto;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Data
@Builder
@ToString // 테스트 어노테이션
@Entity
public class QuestionBoard {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String content;

    private boolean deleteYn; // 삭제 여부
    private LocalDateTime deleteTime; // 삭제 시간
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
    public enum Category{fna, member_service, lend_service, error}

    public static QuestionBoard toEntitiy(QuestionBoardDto dto){
        return QuestionBoard.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .content(dto.getContent())
                .deleteYn(dto.isDeleteYn())
                .member(dto.getMember())
                .build();
    }

}
