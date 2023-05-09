package com.example.telepardaz.controllers;

import com.example.telepardaz.dto.QRCodeDto;
import com.example.telepardaz.exceptions.ServiceException;
import com.example.telepardaz.models.QRCode;
import com.example.telepardaz.services.QrCodeService;
import com.google.zxing.WriterException;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.image.BufferedImage;

@RestController
@RequestMapping("/qrcode")
public class QrCodeController extends BaseController<QRCode, QRCodeDto, QrCodeService> {

    @PostMapping(produces = MediaType.IMAGE_PNG_VALUE)
    @Transactional
    public ResponseEntity<BufferedImage> createQrCode(@Valid @RequestBody QRCodeDto dto) throws ServiceException, WriterException {
        return service.okResponse(service.generateQRCodeImage(dto));
    }

}
