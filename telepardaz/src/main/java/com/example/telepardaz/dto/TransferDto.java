package com.example.telepardaz.dto;

import com.example.telepardaz.enums.TransferMethod;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TransferDto extends BaseDto {
    private Long merchantId;
    @NotNull(message = "Entering this field is required")
    private Long amount;
    @NotNull(message = "Entering this field is required")
    private TransferMethod transferMethod;
}
