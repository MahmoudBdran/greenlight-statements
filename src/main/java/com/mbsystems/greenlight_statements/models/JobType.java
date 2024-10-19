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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@EntityListeners({AuditingEntityListener.class})
public class JobType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
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

    @OneToMany
    @JoinColumn(name = "invoice_id")
    private List<Invoice> invoice;
    private String type; // "جارية" أو "ختامية"

    private LocalDate jobTypeDate;



    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;


}
