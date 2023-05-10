package com.example.telepardaz.services;

import com.example.telepardaz.exceptions.ServiceException;
import com.example.telepardaz.models.Merchant;
import com.example.telepardaz.repositories.MerchantRepository;
import org.springframework.stereotype.Service;

@Service
public class MerchantService extends BaseService<MerchantRepository, Merchant> {
    public Merchant findByMerchantId(String id) {
        return repository.findByMerchantId(id);
    }

    public void createMerchant(Merchant merchant) throws ServiceException {
        Merchant existingMerchant = repository.findByUsername(merchant.getUsername());
        if (existingMerchant != null) {
            throw new ServiceException("This_merchant_exists_in_the_system");
        }
        Merchant entity = new Merchant();
        entity.setUsername(merchant.getUsername());
        entity.setPassword(merchant.getPassword());
        entity.setFirstName(merchant.getFirstName());
        entity.setLastName(merchant.getLastName());
        entity.setAccountNumber(merchant.getAccountNumber());
        entity.setCardNumber(merchant.getCardNumber());
        entity.setQrCodes(merchant.getQrCodes());
        entity.setMerchantId(merchant.getMerchantId());
        repository.save(entity);

    }

}
