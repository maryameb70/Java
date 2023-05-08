package com.example.telepardaz.services;

import com.example.telepardaz.dto.MerchantDto;
import com.example.telepardaz.exceptions.ServiceException;
import com.example.telepardaz.models.Merchant;
import com.example.telepardaz.repositories.MerchantRepository;
import org.springframework.stereotype.Service;

@Service
public class MerchantService extends BaseService<MerchantRepository, Merchant> {
    public void createMerchant(Merchant merchant) throws ServiceException {
        MerchantDto dto = new MerchantDto();
        Merchant existingMerchant = repository.findByUsername(dto.getUsername());
        if (existingMerchant != null) {
            throw new ServiceException("This_merchant_exists_in_the_system");
        }
        merchant.setUsername(dto.getUsername());
        merchant.setPassword(dto.getPassword());
        merchant.setFirstName(dto.getFirstName());
        merchant.setLastName(dto.getLastName());
        merchant.setAccountNumber(dto.getAccountNumber());
        merchant.setCardNumber(dto.getCardNumber());
        merchant.setMerchantId(dto.getMerchantId());
        repository.save(merchant);
    }

}
