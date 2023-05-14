package com.example.telepardaz.dto;

import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
public class PersonMerchantDto extends MerchantDto {
    private String firstName;
    private String lastName;

    public PersonMerchantDto(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
