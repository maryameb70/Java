package com.example.telepardaz.controllers;

import com.example.telepardaz.dto.MerchantDto;
import com.example.telepardaz.models.Merchant;
import com.example.telepardaz.services.MerchantService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/merchant")
public class MerchantController extends BaseController<Merchant, MerchantDto, MerchantService> {

}
