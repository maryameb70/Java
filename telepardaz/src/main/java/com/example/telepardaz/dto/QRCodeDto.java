package com.example.telepardaz.dto;

import lombok.*;
@Data
@EqualsAndHashCode(callSuper = true)
public class QRCodeDto extends BaseDto {
    private String merchantId;
    private String terminalId;
    private String qrCodeId;
}
