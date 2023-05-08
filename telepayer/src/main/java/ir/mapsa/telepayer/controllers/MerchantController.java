package ir.mapsa.telepayer.controllers;

import ir.mapsa.telepayer.dto.MerchantDto;
import ir.mapsa.telepayer.dto.QRCodeDto;
import ir.mapsa.telepayer.exceptions.ServiceException;
import ir.mapsa.telepayer.models.Merchant;
import ir.mapsa.telepayer.services.MerchantService;
import ir.mapsa.telepayer.services.QrCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tele")
public class MerchantController extends AbstractController<Merchant, MerchantDto, MerchantService> {
    @Autowired
    private QrCodeService qrCodeService;

    @PostMapping("/merchant")
    @Transactional
    public void createMerchant(@Validated @RequestBody MerchantDto dto) throws ServiceException {
        service.createMerchant(converter.convertDto(dto));
    }

    @PostMapping("/qrcode")
    @Transactional
    public void createQr(@Validated @RequestBody QRCodeDto dto) throws ServiceException {
        qrCodeService.createQRCode(dto);
    }

}
