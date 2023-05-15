package com.example.telepardaz.controllers;

import com.example.telepardaz.dto.LegalMerchantDto;
import com.example.telepardaz.dto.MerchantResponse;
import com.example.telepardaz.exceptions.ServiceException;
import com.example.telepardaz.models.LegalMerchant;
import com.example.telepardaz.services.LegalMerchantService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/legal")
public class LegalMerchantController extends BaseController<LegalMerchant, LegalMerchantDto, LegalMerchantService> {

    @PostMapping("/add")
    @Transactional
    public MerchantResponse createLegalMerchant(@RequestBody LegalMerchantDto dto) throws ServiceException {
         return service.createLegalMerchant(mapper.convertDto(dto));
    }

}
