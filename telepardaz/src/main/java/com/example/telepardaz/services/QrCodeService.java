package com.example.telepardaz.services;

import com.example.telepardaz.dto.QRCodeDto;
import com.example.telepardaz.exceptions.ServiceException;
import com.example.telepardaz.models.Merchant;
import com.example.telepardaz.models.QRCode;
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
public class QrCodeService extends BaseService<QRCodeRepository, QRCode> {

    @Autowired
    private MerchantService merchantService;

    public BufferedImage generateQRCodeImage(QRCodeDto dto) throws ServiceException, WriterException {
//        Merchant merchant = merchantService.findByMerchant(dto.getMerchants().getUsername());
//        if (merchant == null) {
//            throw new ServiceException("this_merchandise_is_not_registered_in_the_system");
//        }
        QRCode qrCode = saveQrCode(dto);
        QRCodeWriter barcodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = barcodeWriter.encode(String.valueOf(qrCode), BarcodeFormat.QR_CODE, 200, 200);
        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }

    private QRCode saveQrCode(QRCodeDto dto) {
        QRCode qrCode = new QRCode();
        if (dto.getAmount() != 0) {
            qrCode.setIsAuthorization(true);
        }
        qrCode.setMerchants(dto.getMerchants());
        qrCode.setAmount(dto.getAmount());
        qrCode.setOrderDescription(dto.getOrderDescription());
        qrCode.setOrderItems(dto.getOrderItems());
        qrCode.setMetadata(dto.getMetadata());
        qrCode.setCodeType(dto.getCodeType());
        qrCode.setStoreInfo(dto.getStoreInfo());
        qrCode.setStoreId(dto.getStoreId());
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

}
