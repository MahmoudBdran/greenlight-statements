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

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity

@EntityListeners({AuditingEntityListener.class})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne()
    @JoinColumn(name = "invoice_id" , referencedColumnName = "id")
    private Invoice invoice;
    private String name;
    @ManyToOne()
    @JoinColumn(name = "unit_id",referencedColumnName = "id")
    private Unit Unit;

    private BigDecimal last_made;

    private BigDecimal MadeInPeriod;

    private BigDecimal finishedTillNow;

    private BigDecimal percentage;

    private BigDecimal itemPrice;
    private BigDecimal itemQuantity;

    private BigDecimal totalPrice;

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
