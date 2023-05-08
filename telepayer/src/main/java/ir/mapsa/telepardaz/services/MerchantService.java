package ir.mapsa.telepardaz.services;

import ir.mapsa.telepardaz.exceptions.ServiceException;
import ir.mapsa.telepardaz.repositories.MerchantRepository;
import ir.mapsa.telepardaz.dto.MerchantDto;
import ir.mapsa.telepardaz.models.Merchant;
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
