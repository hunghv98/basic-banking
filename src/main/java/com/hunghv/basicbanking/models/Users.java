package com.hunghv.basicbanking.models;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false, length = 20)
    private String userName;
    @Column(nullable = false, length = 20)
    private String password;

    private String phone;
    @Column(nullable = false)
    private String email;
    private Timestamp joinDate;

    @OneToMany(mappedBy = "user")
    private List<Account> accounts;
}
