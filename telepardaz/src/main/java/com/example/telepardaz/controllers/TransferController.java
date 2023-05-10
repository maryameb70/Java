package com.example.telepardaz.controllers;

import com.example.telepardaz.dto.QRCodeDto;
import com.example.telepardaz.dto.TransferDto;
import com.example.telepardaz.exceptions.ServiceException;
import com.example.telepardaz.models.QrCode;
import com.example.telepardaz.services.QrCodeService;
import com.example.telepardaz.services.TransferService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfer")
public class TransferController extends BaseController<QrCode, QRCodeDto, TransferService> {

    @PostMapping
    @Transactional
    public void transfer(@RequestBody TransferDto transferDto) throws ServiceException  {
        service.transfer(transferDto);
    }
}
