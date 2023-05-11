package com.example.telepardaz.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;
@Data
@EqualsAndHashCode(callSuper = true)
public class QRCodeDto extends BaseDto {
    private Long merchantId;
    private String terminalId;
}
