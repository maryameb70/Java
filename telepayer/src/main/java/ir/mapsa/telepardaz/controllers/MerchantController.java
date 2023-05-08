package ir.mapsa.telepardaz.controllers;

import com.google.zxing.WriterException;
import ir.mapsa.telepardaz.dto.MerchantDto;
import ir.mapsa.telepardaz.dto.QRCodeDto;
import ir.mapsa.telepardaz.exceptions.ServiceException;
import ir.mapsa.telepardaz.models.Merchant;
import ir.mapsa.telepardaz.services.MerchantService;
import ir.mapsa.telepardaz.services.QrCodeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import java.awt.image.BufferedImage;
@RestController
@RequestMapping("/telepardaz")
public class MerchantController extends BaseController<Merchant, MerchantDto, MerchantService> {
    @Autowired
    private QrCodeService qrCodeService;

    @PostMapping("/merchant")
    @Transactional
    public void createMerchant( @RequestBody MerchantDto dto) throws ServiceException {
        service.createMerchant(converter.convertDto(dto));
    }

    @PostMapping(value = "/qrcode", produces = MediaType.IMAGE_PNG_VALUE)
    @Transactional
    public ResponseEntity<BufferedImage> createQrCode(@Valid @RequestBody QRCodeDto dto) throws ServiceException, WriterException {
        return qrCodeService.okResponse(qrCodeService.generateQRCodeImage(dto));
    }



}
