package com.example.telepardaz.dto.transfer;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class WalletToWalletDto {
    private String userName;
    private Long amount;
}
