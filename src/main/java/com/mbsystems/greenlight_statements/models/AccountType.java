package com.mbsystems.greenlight_statements.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "account_types")
public class AccountType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private boolean active;

    @Column(name = "relatediternalaccounts")
    private boolean relatedInternalAccounts;

    @OneToMany(mappedBy = "accountType") // MappedBy points to the field in Account
    @JsonIgnore
    private List<Account> accounts;

}

