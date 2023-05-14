package com.example.telepardaz.dto;

import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
public class LegalMerchantDto extends MerchantDto {
    private String storeName;
    private String postalCode;
    private String description;
    private String address;
}
