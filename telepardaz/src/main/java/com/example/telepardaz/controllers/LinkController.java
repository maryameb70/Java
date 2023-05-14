package com.example.telepardaz.controllers;

import com.example.telepardaz.dto.MerchantBaseInfo;
import com.example.telepardaz.dto.MerchantDto;
import com.example.telepardaz.models.Merchant;
import com.example.telepardaz.services.LinkService;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;

@RestController
public class LinkController extends BaseController<Merchant, MerchantDto, LinkService> {

    @GetMapping("/link")
    public MerchantBaseInfo getMerchant(@RequestParam String code) throws IOException {
        return service.decode(code);
    }
}
