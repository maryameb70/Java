package com.example.telepardaz.controllers;

import com.example.telepardaz.dto.MerchantDto;
import com.example.telepardaz.exceptions.ServiceException;
import com.example.telepardaz.dto.MerchantResponse;
import com.example.telepardaz.models.Merchant;
import com.example.telepardaz.services.MerchantService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/merchant")
public class MerchantController extends BaseController<Merchant, MerchantDto, MerchantService> {

    @PostMapping("/add")
    @Transactional
    public MerchantResponse createMerchant(@RequestBody MerchantDto dto) throws ServiceException {
      return service.create(mapper.convertDto(dto));
    }
}
