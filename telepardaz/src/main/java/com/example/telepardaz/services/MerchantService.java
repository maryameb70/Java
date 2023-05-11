package com.example.telepardaz.services;

import com.example.telepardaz.exceptions.ServiceException;
import com.example.telepardaz.dto.MerchantResponse;
import com.example.telepardaz.models.Merchant;
import com.example.telepardaz.repositories.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MerchantService extends BaseService<MerchantRepository, Merchant> {
    @Autowired
    private LinkService linkService;
    private static String code;

    public MerchantResponse create(Merchant merchant) throws ServiceException {
        Merchant existingMerchant = repository.findByUsername(merchant.getUsername());
        if (existingMerchant != null) {
            throw new ServiceException("this-merchant-exists-in-the-system");
        }
        return getMerchantResponse( saveMerchant(merchant));
    }

    private static MerchantResponse getMerchantResponse(Merchant merchant) {
        MerchantResponse response = new MerchantResponse();
        response.setId(merchant.getId());
        response.setFirstName(merchant.getFirstName());
        response.setLastName(merchant.getLastName());
        response.setUrl("localhost:8080/link?code=" + code);
        return response;
    }

    private Merchant saveMerchant(Merchant merchant) throws ServiceException {
        Merchant entity = new Merchant();
        entity.setUsername(merchant.getUsername());
        entity.setPassword(merchant.getPassword());
        entity.setFirstName(merchant.getFirstName());
        entity.setLastName(merchant.getLastName());
        entity.setAccountNumber(merchant.getAccountNumber());
        entity.setCardNumber(merchant.getCardNumber());
        entity.setQrCodes(merchant.getQrCodes());
        entity.setMerchantId(String.valueOf(UUID.randomUUID()));
        entity.setUserId(merchant.getUserId());
        Merchant savedNewMerchant=repository.save(entity);
        code = linkService.generateLink(savedNewMerchant);
        savedNewMerchant.setCode(code);
        super.update(savedNewMerchant);
        return savedNewMerchant;
    }
}
