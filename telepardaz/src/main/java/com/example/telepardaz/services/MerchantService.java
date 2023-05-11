package com.example.telepardaz.services;

import com.example.telepardaz.enums.TransferMethod;
import com.example.telepardaz.exceptions.ServiceException;
import com.example.telepardaz.dto.MerchantResponse;
import com.example.telepardaz.models.Merchant;
import com.example.telepardaz.repositories.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerchantService extends BaseService<MerchantRepository, Merchant> {
    @Autowired
    private LinkService linkService;
    private static String code;

    public Merchant findByMerchantId(String id) {
        return repository.findByMerchantId(id);
    }

    public MerchantResponse create(Merchant merchant) throws ServiceException {
        Merchant existingMerchant = repository.findByUsername(merchant.getUsername());
        if (existingMerchant != null) {
            throw new ServiceException("this-merchant-exists-in-the-system");
        }
        saveMerchant(merchant);
        return getMerchantResponse(merchant);
    }

    private static MerchantResponse getMerchantResponse(Merchant merchant) {
        MerchantResponse response = new MerchantResponse();
        response.setMerchantId(merchant.getMerchantId());
        response.setFirstName(merchant.getFirstName());
        response.setLastName(merchant.getLastName());
        response.setUrl("localhost:8080/link/url?code=" + code);
        return response;
    }

    private void saveMerchant(Merchant merchant) {
        Merchant entity = new Merchant();
        entity.setUsername(merchant.getUsername());
        entity.setPassword(merchant.getPassword());
        entity.setFirstName(merchant.getFirstName());
        entity.setLastName(merchant.getLastName());
        entity.setAccountNumber(merchant.getAccountNumber());
        entity.setCardNumber(merchant.getCardNumber());
        entity.setQrCodes(merchant.getQrCodes());
        entity.setMerchantId(merchant.getMerchantId());
        entity.setUserId(merchant.getUserId());
        code = linkService.generateLink(merchant);
        entity.setCode(code);
        repository.save(entity);
    }

    public void confirm(Long amount, TransferMethod transferMethod) {

    }
}
