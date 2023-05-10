package com.example.telepardaz.controllers;

import com.example.telepardaz.dto.MerchantDto;
import com.example.telepardaz.exceptions.ServiceException;
import com.example.telepardaz.models.Merchant;
import com.example.telepardaz.services.LinkService;
import jakarta.validation.Valid;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;

@RestController
@RequestMapping("/link")
public class LinkController extends BaseController<Merchant, MerchantDto, LinkService> {

    @PostMapping(value = "/generate")
    @Transactional
    public String createLink(@Valid @RequestBody MerchantDto dto) throws ServiceException {
        return service.generateLink(mapper.convertDto(dto));
    }

    @GetMapping("/{code}")
    @Transactional
    public Merchant decode(@PathVariable("code") String code) throws ServiceException, IOException {
       return service.decode(code);
    }
}
