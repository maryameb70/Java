package com.example.telepardaz.controllers;

import com.example.telepardaz.dto.MerchantDto;
import com.example.telepardaz.dto.QRCodeDto;
import com.example.telepardaz.exceptions.ServiceException;
import com.example.telepardaz.models.Merchant;
import com.example.telepardaz.services.MerchantService;
import com.example.telepardaz.services.QrCodeService;
import com.google.zxing.WriterException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.awt.image.BufferedImage;
@RestController
@RequestMapping("/telepardaz")
public class MerchantController extends BaseController<Merchant, MerchantDto, MerchantService> {
    @Autowired
    private QrCodeService qrCodeService;

    @PostMapping("/merchant")
    @Transactional
    public void createMerchant( @RequestBody MerchantDto dto) throws ServiceException {
        service.createMerchant(mapper.convertDto(dto));
    }

    @PostMapping(value = "/qrcode", produces = MediaType.IMAGE_PNG_VALUE)
    @Transactional
    public ResponseEntity<BufferedImage> createQrCode(@Valid @RequestBody QRCodeDto dto) throws ServiceException, WriterException {
        return qrCodeService.okResponse(qrCodeService.generateQRCodeImage(dto));
    }



}
