package com.example.telepardaz.services;

import com.example.telepardaz.dto.QRCodeDto;
import com.example.telepardaz.dto.MerchantBaseInfo;
import com.example.telepardaz.exceptions.ServiceException;
import com.example.telepardaz.models.Merchant;
import com.example.telepardaz.models.QrCode;
import com.example.telepardaz.repositories.QRCodeRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    public BufferedImage generateQRCodeImage(QRCodeDto dto) throws ServiceException, WriterException, JsonProcessingException {
        Merchant merchant = merchantService.findByMerchantId(dto.getMerchantId());
        if (merchant==null) {
            throw new ServiceException("this-merchandise-is-not-registered-in-the-system");
        }
        saveQrCode(dto, merchant);
        QRCodeWriter barcodeWriter = new QRCodeWriter();
        MerchantBaseInfo response = getShowMerchant(merchant);
        ObjectMapper mapper = new ObjectMapper();
        String infoSavedOnQr=mapper.writeValueAsString(response);
        BitMatrix bitMatrix = barcodeWriter.encode(String.valueOf(infoSavedOnQr), BarcodeFormat.QR_CODE, 200, 200);
        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }

    private static MerchantBaseInfo getShowMerchant(Merchant merchant) {
        MerchantBaseInfo response=new MerchantBaseInfo();
        response.setMerchantId(merchant.getMerchantId());
        response.setFirstName(merchant.getFirstName());
        response.setLastName(merchant.getLastName());
        return response;
    }

    private void saveQrCode(QRCodeDto dto, Merchant merchant) {
        QrCode qrCode = new QrCode();
        qrCode.setMerchant(merchant);
        qrCode.setTerminalId(dto.getTerminalId());
        qrCode.setQrCodeId(dto.getQrCodeId());
        repository.save(qrCode);
    }

    public ResponseEntity<BufferedImage> okResponse(BufferedImage image) {
        return new ResponseEntity<>(image, HttpStatus.OK);
    }
}
