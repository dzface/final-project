
package com.kh.final_project.dto;

import com.kh.final_project.entity.Member;
import com.kh.final_project.entity.QuestionBoard;
import lombok.*;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionBoardDto {
    private Long id;
    private String title;
    private String content;
    private boolean deleteYn;
    private Member member;
    private QuestionBoard.Category category;

    public static QuestionBoardDto toDto(QuestionBoard entity){
        return QuestionBoardDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .content(entity.getContent())
                .deleteYn(entity.isDeleteYn())
                .member(entity.getMember())
                .build();
    }
}
