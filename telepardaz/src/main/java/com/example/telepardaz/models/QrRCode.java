package com.example.telepardaz.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "qrcode")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class QrRCode extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "merchant_id")
    private Merchant merchant;

    @Column(name = "amount")
    private Long amount;

    @Column(name = "codeType")
    private String codeType="ORDER_QR";

    @Column(name = "terminalId")
    private String terminalId;

    @Column(name = "requestedAt")
    private Long requestedAt = Instant.now().getEpochSecond();

    @Column(name = "isAuthorization")
    private Boolean isAuthorization;

    @Column(name = "authorizationExpiry")
    private Long authorizationExpiry;

    @Column(name = "redirectUrl")
    private String redirectUrl;

}
