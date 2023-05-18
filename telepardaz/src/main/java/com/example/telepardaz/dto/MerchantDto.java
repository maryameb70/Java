package com.example.telepardaz.dto;

import com.example.telepardaz.models.QrCode;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class MerchantDto extends BaseDto {
    private String name;
    private String phone;
    private String mobile;
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$")
    private String email;
    private String website;
    private String iban;
    private String code;
    private String cardNumber;
    private String accountNumber;
    @OneToMany(mappedBy = "merchant")
    private List<QrCode> qrCodes;
}
