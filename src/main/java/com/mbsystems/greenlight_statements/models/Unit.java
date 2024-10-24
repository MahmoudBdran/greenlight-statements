package com.mbsystems.greenlight_statements.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EntityListeners({AuditingEntityListener.class})
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne()
    @JoinColumn(name = "added_by",referencedColumnName = "id")
    @CreatedBy
    private Admin addedBy;

    @ManyToOne()
    @JoinColumn(name = "updated_by",referencedColumnName = "id")
    @LastModifiedBy
    private Admin updatedBy;

    @CreatedDate
    private LocalDateTime createdAt=LocalDateTime.now();

    @LastModifiedDate
    private LocalDateTime updatedAt;
}
