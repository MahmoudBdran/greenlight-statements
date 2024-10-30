package com.mbsystems.greenlight_statements.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@EntityListeners({AuditingEntityListener.class})
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
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
//
//    @ManyToOne
//    @JoinColumn(name = "contractor_id",referencedColumnName = "id")
//    private Contractor contractor;
    private String type; // "جارية" أو "ختامية"

    private LocalDate invoiceDate;

    private BigDecimal amount;

    @Column(name = "what_remain", precision = 10, scale = 2)
    private BigDecimal whatRemain;
    @Column(name = "what_paid", precision = 10, scale = 2)
    private BigDecimal whatPaid;


//    @ManyToOne
//    @JoinColumn(name = "owner_id",referencedColumnName = "id")
//    private Owner owner;

//    @ManyToOne
//    @JoinColumn(name = "company_id",referencedColumnName = "id")
//    private Company company;


//    @OneToOne
//    @JoinColumn(name = "account_id",referencedColumnName = "id")
//    private Account account;
    @ManyToOne
    @JoinColumn(name = "jobtype_id", referencedColumnName = "id")
    private JobType jobType;
    @OneToMany(mappedBy = "invoice")
    @JsonIgnore
   private List<Item> items;



}