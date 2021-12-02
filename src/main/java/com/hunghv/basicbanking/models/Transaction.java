package com.hunghv.basicbanking.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long id;

    @NotNull
    @JsonProperty("Transfer from account id:")
    private Long accountFromId;

    @NotNull
    @JsonProperty("Transfer to account id:")
    private Long accountToId;

    @Min(value = 0, message = "Can't transfer amount less than ZERO")
    private BigDecimal transAmount;

    private Timestamp transDateTime;
}
