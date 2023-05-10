package com.example.telepardaz.services;

import com.example.telepardaz.exceptions.ServiceException;
import com.example.telepardaz.models.Merchant;
import com.example.telepardaz.repositories.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MerchantService extends BaseService<MerchantRepository, Merchant> {
    @Autowired
    private LinkService linkService;

    public Merchant findByMerchantId(String id) {
        return repository.findByMerchantId(id);
    }

    public void createMerchant(Merchant merchant) throws ServiceException {
        Merchant existingMerchant = repository.findByUsername(merchant.getUsername());
        if (existingMerchant != null) {
            throw new ServiceException("this-merchant-exists-in-the-system");
        }
        saveMerchant(merchant);
    }

    private void saveMerchant(Merchant merchant){
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
        entity.setCode(linkService.generateLink(merchant));
        repository.save(entity);
    }

}
