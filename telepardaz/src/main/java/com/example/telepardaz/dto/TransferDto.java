package com.example.telepardaz.dto;

import com.example.telepardaz.enums.TransferMethod;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.Instant;

@Data
@EqualsAndHashCode(callSuper = true)
public class TransferDto extends BaseDto {
    private Long amount;
    private Long qrCodeId;
    private TransferMethod transferMethod;
}
