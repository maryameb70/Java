package ir.mapsa.telepayer.services;

import ir.mapsa.telepayer.dto.MerchantDto;
import ir.mapsa.telepayer.exceptions.ServiceException;
import ir.mapsa.telepayer.models.Merchant;
import ir.mapsa.telepayer.repositories.MerchantRepository;
import org.springframework.stereotype.Service;

@Service
public class MerchantService extends AbstractService<MerchantRepository, Merchant> {
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
