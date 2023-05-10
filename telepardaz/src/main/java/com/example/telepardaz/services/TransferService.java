package com.example.telepardaz.services;

import com.example.telepardaz.dto.TransferDto;
import com.example.telepardaz.exceptions.ServiceException;
import com.example.telepardaz.models.Merchant;
import com.example.telepardaz.models.QrCode;
import com.example.telepardaz.repositories.QRCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferService extends BaseService<QRCodeRepository, QrCode> {
    @Autowired
    private MerchantService merchantService;

    public void transfer(TransferDto transferDto) throws ServiceException {
        QrCode qrCode = repository.findByQrCodeId(transferDto.getQrCodeId());
        Merchant merchant =merchantService.findByMerchantId(qrCode.getMerchant().getMerchantId());

                switch (transferDto.getTransferMethod()) {
                    case TO_CARD -> { //TODO Call depositOnBankWithCardNumber(merchant.getCardNumber(),transferDto.getAmount())
                    }
                    case TO_ACCOUNT -> {
                        //TODO Call depositOnBankWithAccountNumber(merchant.getAccountNumber(),transferDto.getAmount())
                    }
                    case TO_WALLET -> {
                        //TODO Call depositOnBankWithWallet
                    }
                }
    }
}
