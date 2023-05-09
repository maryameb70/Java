package com.example.telepardaz.services;

import com.example.telepardaz.dto.QRCodeDto;
import com.example.telepardaz.dto.TransferDto;
import com.example.telepardaz.exceptions.ServiceException;
import com.example.telepardaz.models.Merchant;
import com.example.telepardaz.models.QrRCode;
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
import java.util.Optional;

@Service
public class QrCodeService extends BaseService<QRCodeRepository, QrRCode> {

    @Autowired
    private MerchantService merchantService;

    public BufferedImage generateQRCodeImage(QRCodeDto dto) throws ServiceException, WriterException {
        Optional<Merchant> merchant = merchantService.findById(dto.getMerchantId());
        if (merchant.isEmpty()) {
            throw new ServiceException("this_merchandise_is_not_registered_in_the_system");
        }
        QrRCode qrCode = saveQrCode(dto, merchant);
        QRCodeWriter barcodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = barcodeWriter.encode(String.valueOf(qrCode), BarcodeFormat.QR_CODE, 200, 200);
        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }

    private QrRCode saveQrCode(QRCodeDto dto, Optional<Merchant> merchant) {
        QrRCode qrCode = new QrRCode();
//        if (dto.getAmount() != 0) {
//            qrCode.setIsAuthorization(true);
//        }
        qrCode.setMerchant(merchant.get());
        qrCode.setAmount(dto.getAmount());
        qrCode.setCodeType(dto.getCodeType());
        qrCode.setTerminalId(dto.getTerminalId());
        qrCode.setRequestedAt(dto.getRequestedAt());
        qrCode.setAuthorizationExpiry(dto.getAuthorizationExpiry());
        qrCode.setRedirectUrl(dto.getRedirectUrl());
        repository.save(qrCode);
        return qrCode;
    }

    public ResponseEntity<BufferedImage> okResponse(BufferedImage image) {
        return new ResponseEntity<>(image, HttpStatus.OK);
    }

    public void transfer(TransferDto transferDto) throws ServiceException  {

    }
}
