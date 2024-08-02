//Member.java
package com.kh.final_project.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@Data

@ToString
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "member")
public class Member {
    @Id
    @Column(name = "member_id")
    private String memberId;
    @Column(nullable = false)
    private String name;
    private String password;
    private boolean memberType;
    private LocalDateTime createAccountTime;
    private boolean deleteYn; // 삭제 여부
    private LocalDateTime deleteAccountTime;

    @OneToMany(mappedBy = "member")
    private List<QuestionBoard> QuestionBoard= new ArrayList<>();


}
