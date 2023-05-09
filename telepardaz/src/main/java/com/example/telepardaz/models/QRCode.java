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
public class QRCode extends BaseEntity {
    //    @Column(name = "merchantId")
//    private String merchantId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "merchant_id")
    private Merchant merchants;

    @Column(name = "amount")
    private Long amount;

    @Column(name = "orderDescription")
    private String orderDescription;

    @Column(name = "orderItems")
    @OneToMany
    private List<MerchantOrderItem> orderItems;

    @Column(name = "metadata")
    private String metadata;

    @Column(name = "codeType")
    private String codeType;

    @Column(name = "storeInfo")
    private String storeInfo;

    @Column(name = "storeId")
    private String storeId;

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
