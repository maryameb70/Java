package com.example.telepardaz.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
public class MerchantOrderItemDto extends BaseDto {
    @NotNull(message = "Entering this field is required")
    private String name ;
    private String category ;
    @NotNull(message = "Entering this field is required")
    @Min(value = 1)
    private Integer quantity ;
    private String productId ;
    @NotNull(message = "Entering this field is required")
    private Long unitPrice;
}
