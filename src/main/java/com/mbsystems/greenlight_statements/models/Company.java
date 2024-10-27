package com.mbsystems.greenlight_statements.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
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
public class Company {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne
    @JoinColumn(name = "account_id",referencedColumnName = "id")
    private Account account;

    private int startBalanceStatus; // Consider using an enum for status

    private BigDecimal startBalance;
    private BigDecimal currentBalance = BigDecimal.ZERO; // Set default to 0.00 using BigDecimal.ZERO



//    @OneToMany
//    @JoinColumn(name = "invoice_id",referencedColumnName = "id")
//    private List<Invoice> invoices;

    @Column(length = 225)
    private String notes;

    @ManyToOne()
    @JoinColumn(name = "added_by",referencedColumnName = "id")
    @CreatedBy
    private Admin addedBy;

    @ManyToOne()
    @JoinColumn(name = "updated_by",referencedColumnName = "id")
    @LastModifiedBy
    private Admin updatedBy;

    @Column(nullable = false)
    private LocalDateTime createdAt=LocalDateTime.now();

    @LastModifiedDate
    private LocalDateTime updatedAt;

    private boolean active;

    @Column(length = 250)
    private String address;

    @Column(length = 50)
    private String phones;
    @OneToMany(mappedBy = "company")
    @JsonIgnore
    private List<JobType> jobTypes;
//
//    @OneToMany(mappedBy = "jobType.company")
//    private List<Invoice> invoices;
    public Company(Long id) {
        this.id = id;
    }

}
