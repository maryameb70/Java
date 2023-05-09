package com.example.telepardaz.dto;

import com.example.telepardaz.models.Merchant;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.Instant;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class QRCodeDto extends BaseDto {
    private Long merchantId;
    private Long amount;

    private String codeType = "ORDER_QR";


    @Size(max = 255, message = "maximum 255 characters allowed for terminalId")
    private String terminalId;

    private Long requestedAt = Instant.now().getEpochSecond();

    private Boolean isAuthorization;

    private Long authorizationExpiry;

    private String redirectUrl;

}
