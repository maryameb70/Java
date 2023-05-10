package com.example.telepardaz.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "qrcode")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class QrCode extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "merchant_id")
    private Merchant merchant;

    @Column(name = "amount")
    private Long amount;

    @Column(name = "codeType")
    private String codeType="ORDER_QR";

    @Column(unique = true,name = "terminalId")
    private String terminalId;

    @Column(unique = true,name="qrCodeId")
    private String qrCodeId;


}
