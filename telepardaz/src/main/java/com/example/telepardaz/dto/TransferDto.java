package com.example.telepardaz.dto;

import com.example.telepardaz.enums.TransferMethod;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TransferDto extends BaseDto {
    @NotNull(message = "Entering this field is required")
    private Long amount;
    @NotNull(message = "Entering this field is required")
    private String qrCodeId;
    @NotNull(message = "Entering this field is required")
    private TransferMethod transferMethod;
}
