package com.example.telepardaz.services;

import com.example.telepardaz.config.GeneralObject;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.util.Optional;
import java.util.UUID;

@Service
public class QrCodeService extends BaseService<QRCodeRepository, QrCode> {
    @Autowired
    private MerchantService merchantService;
    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private GeneralObject QRCodeWriter;

    public BufferedImage generateQRCodeImage(QRCodeDto dto) throws ServiceException, WriterException, JsonProcessingException {
        Optional<Merchant> merchant = merchantService.findById(dto.getId());
        if (merchant.isEmpty()) {
            throw new ServiceException("this-merchandise-is-not-registered-in-the-system");
        }
        saveQrCode(dto, merchant);
        MerchantBaseInfo response = getShowMerchant(merchant);
        String infoSavedOnQr = mapper.writeValueAsString(response);
        BitMatrix bitMatrix = QRCodeWriter.barcodeWriter().encode(String.valueOf(infoSavedOnQr), BarcodeFormat.QR_CODE, 200, 200);
        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }

    private MerchantBaseInfo getShowMerchant(Optional<Merchant> merchant) {
        MerchantBaseInfo response = new MerchantBaseInfo();
        response.setId(merchant.get().getId());
        response.setName(merchant.get().getName());
        return response;
    }

    private void saveQrCode(QRCodeDto dto, Optional<Merchant> merchant) {
        QrCode qrCode = new QrCode();
        qrCode.setMerchant(merchant.get());
        qrCode.setTerminalId(dto.getTerminalId());
        qrCode.setQrCodeId(String.valueOf(UUID.randomUUID()));
        repository.save(qrCode);
    }

    public ResponseEntity<BufferedImage> okResponse(BufferedImage image) {
        return new ResponseEntity<>(image, HttpStatus.OK);
    }
}
