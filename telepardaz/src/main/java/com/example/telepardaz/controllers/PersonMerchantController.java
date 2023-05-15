package com.example.telepardaz.controllers;

import com.example.telepardaz.dto.MerchantResponse;
import com.example.telepardaz.dto.PersonMerchantDto;
import com.example.telepardaz.exceptions.ServiceException;
import com.example.telepardaz.models.PersonMerchant;
import com.example.telepardaz.services.PersonMerchantService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonMerchantController extends BaseController<PersonMerchant, PersonMerchantDto, PersonMerchantService> {

    @PostMapping("/add")
    @Transactional
    public MerchantResponse createPersonMerchant(@RequestBody PersonMerchantDto dto) throws ServiceException {
        return service.createPersonMerchant(mapper.convertDto(dto));
    }
}
