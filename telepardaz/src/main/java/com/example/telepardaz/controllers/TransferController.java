package com.example.telepardaz.controllers;

import com.example.telepardaz.dto.TransactionDto;
import com.example.telepardaz.dto.TransferDto;
import com.example.telepardaz.exceptions.ServiceException;
import com.example.telepardaz.models.ConvertTokenToUserDetails;
import com.example.telepardaz.models.Transaction;
import com.example.telepardaz.models.UserDetails;
import com.example.telepardaz.services.TransferService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transfer")
public class TransferController extends BaseController<Transaction, TransactionDto, TransferService> {

    @PostMapping("trans")
    @Transactional
    public void transfer(@RequestBody TransferDto transferDto, @RequestHeader(name = "Authorization") String token) throws ServiceException, JsonProcessingException {
        UserDetails userDetails = ConvertTokenToUserDetails.convert(token);
        service.transfer(transferDto, userDetails);
    }
}
