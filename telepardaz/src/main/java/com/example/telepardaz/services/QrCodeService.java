package com.example.telepardaz.services;

import com.example.telepardaz.dto.QRCodeDto;
import com.example.telepardaz.dto.TransferDto;
import com.example.telepardaz.exceptions.ServiceException;
import com.example.telepardaz.mappers.MerchantMapper;
import com.example.telepardaz.models.Merchant;
import com.example.telepardaz.models.QrCode;
import com.example.telepardaz.repositories.MerchantRepository;
import com.example.telepardaz.repositories.QRCodeRepository;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;

@Service
public class QrCodeService extends BaseService<QRCodeRepository, QrCode> {
    @Autowired
    private MerchantService merchantService;

    public BufferedImage generateQRCodeImage(QRCodeDto dto) throws ServiceException, WriterException {
        Merchant merchant = merchantService.findByMerchantId(dto.getMerchantId());
        if (merchant==null) {
            throw new ServiceException("this_merchandise_is_not_registered_in_the_system");
        }
        QrCode qrCode = saveQrCode(dto, merchant);
        QRCodeWriter barcodeWriter = new QRCodeWriter();
        StringBuffer infoSavedOnQr = new StringBuffer("QrCodeId:" + qrCode.getQrCodeId()).append("\n" + "MerchantId:").append(merchant.getMerchantId()).append("\n" + "MerchantFirstName:").append(merchant.getFirstName()).append("\n" + "MerchantLastName:").append(merchant.getLastName());
        BitMatrix bitMatrix = barcodeWriter.encode(String.valueOf(infoSavedOnQr), BarcodeFormat.QR_CODE, 200, 200);
        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }

    private QrCode saveQrCode(QRCodeDto dto, Merchant merchant) {
        QrCode qrCode = new QrCode();
        qrCode.setMerchant(merchant);
        qrCode.setAmount(dto.getAmount());
        qrCode.setCodeType(dto.getCodeType());
        qrCode.setTerminalId(dto.getTerminalId());
        qrCode.setQrCodeId(dto.getQrCodeId());
        repository.save(qrCode);
        return qrCode;
    }

    public ResponseEntity<BufferedImage> okResponse(BufferedImage image) {
        return new ResponseEntity<>(image, HttpStatus.OK);
    }

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
                };
    }
}
