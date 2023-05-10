package com.example.telepardaz.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name ="merchant")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Merchant extends BaseEntity {
    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String accountNumber;

    @Column(nullable = false)
    private String cardNumber;

    @OneToMany(mappedBy = "merchant")
    private List<QrCode> qrCodes;

    @Column(unique = true)
    private String merchantId;
}
