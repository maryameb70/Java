package com.example.telepardaz.dto;

import com.example.telepardaz.models.QrCode;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class MerchantDto extends BaseDto {
    private String phone;
    private String mobile;
    private String email;
    private String website;
    private String iban;
    private String code;
    @OneToMany(mappedBy = "merchant")
    private List<QrCode> qrCodes;
}
