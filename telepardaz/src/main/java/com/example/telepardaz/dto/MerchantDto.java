package com.example.telepardaz.dto;

import com.example.telepardaz.models.QrRCode;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class MerchantDto extends BaseDto {
    @NotNull(message = "Entering this field is required")
    @Pattern(regexp = "^([a-zA-Z]|\\s){3,10}$", message = "your username must be between 3 and 10 characters long.")
    private String username;
    @NotNull(message = "Entering this field is required")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$", message = "Use 8 or more characters with a mix of letters,numbers & symbols for your password")
    private String password;
    @NotNull(message = "Entering this field is required")
    @Pattern(regexp = "^([a-zA-Z]|\\s){3,20}$")
    private String firstName;
    @NotNull(message = "Entering this field is required")
    @Pattern(regexp = "^([a-zA-Z]|\\s){3,40}$")
    private String lastName;
    @NotNull(message = "Entering this field is required")
    @Pattern(regexp = "^\\d{18}$", message = "Use only 18 digits for your accountNumber")
    private String accountNumber;
    @NotNull(message = "Entering this field is required")
    @Pattern(regexp = "^\\d{16}$", message = "Use only 8 digits for your cardNumber")
    private String cardNumber;
}
