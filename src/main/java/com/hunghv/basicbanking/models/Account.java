package com.hunghv.basicbanking.models;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long id;

    @NotNull
    private String name;

    private Date dateOpened;
    private Date dateClosed;

    @NotNull
    @Min(value = 0, message = "Account balance must greater than 0")
    private BigDecimal currentBalance;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private Users user;

    private Long userId;

    @OneToMany
    private List<Transaction> transactions;
}
