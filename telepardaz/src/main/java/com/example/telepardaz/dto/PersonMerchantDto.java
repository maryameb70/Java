package com.example.telepardaz.dto;

import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
public class PersonMerchantDto extends MerchantDto {
    private String firstName;
    private String lastName;

}
