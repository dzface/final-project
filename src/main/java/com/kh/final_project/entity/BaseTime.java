package com.kh.final_project.entity;


import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(value= AuditingEntityListener.class) // 값 자동 생성 어노테이션
public class BaseTime {
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdTime;
    @LastModifiedDate
    private LocalDateTime modifiedTime;
}
