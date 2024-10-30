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
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@EntityListeners({AuditingEntityListener.class})
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String phone;
    private String email;
    private String address;
    private String notes;
    private int startBalanceStatus=3; // Consider using an enum for status

    private BigDecimal startBalance=BigDecimal.ZERO;

    private BigDecimal currentBalance = BigDecimal.ZERO; // Set default to 0.00 using BigDecimal.ZERO
    @OneToOne
    @JoinColumn(name = "account_id",referencedColumnName = "id")
    private Account account;
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
    @OneToMany(mappedBy = "owner")
    @JsonIgnore
    private List<JobType> jobTypes;
//
//    @OneToMany(mappedBy = "jobType.owner")
//    private List<Invoice> invoices;




}
