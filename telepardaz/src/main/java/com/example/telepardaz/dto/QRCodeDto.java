package com.example.telepardaz.dto;

import com.example.telepardaz.models.MerchantOrderItem;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.Instant;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class QRCodeDto extends BaseDto {
    @NotEmpty(message = "merchantPaymentId is required")
    @Size(max = 64, message = "maximum 64 characters are allowed for merchantPaymentId")
    private String merchantPaymentId ;

    @NotNull(message = "amount is required")
    private Long amount ;

    @Size(max =255 ,message = "maximum 255 characters allowed for orderDescription")
    private String orderDescription ;

    private List<MerchantOrderItem> orderItems;

    private String metadata;

    @NotEmpty(message = "codeType is required")
    private String codeType ;

    @Size(max =255 ,message = "maximum 255 characters allowed for storeInfo")
    private String storeInfo ;

    @Size(max =255 ,message = "maximum 255 characters allowed for storeId")
    private String storeId;

    @Size(max =255 ,message = "maximum 255 characters allowed for terminalId")
    private String terminalId ;

    private Long requestedAt = Instant.now().getEpochSecond();

    private Boolean isAuthorization ;

    private Long authorizationExpiry ;

    private String redirectUrl ;

 }
