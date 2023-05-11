package com.example.telepardaz.dto;

import lombok.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MerchantResponse extends MerchantBaseInfo {
    private String url;
}
