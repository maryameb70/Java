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

    @Column(unique = true,name = "terminalId")
    private String terminalId;

    @Column(unique = true,name="qrCodeId")
    private String qrCodeId;
}
