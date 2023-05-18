package com.example.telepardaz.dto.transfer;

import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CardDto  {
    @Pattern(regexp = "\\d{16}" , message = "Source Card Number Must Have 16 Digit")
    private String sourceCardNumber;
    @Pattern(regexp = "\\d{16}" , message = "Destination Card Number Must Have 16 Digit")
    private String destinationCardNumber;
    private Integer cvv2;
    @Pattern(regexp = "\\d{2}-\\d{2}" , message = "expire time must be like 05-04")
    private String expireTime;
    private Integer otp;
    private Long amount;
}
