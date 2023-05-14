package com.example.telepardaz.services;

import com.example.telepardaz.dto.MerchantResponse;
import com.example.telepardaz.exceptions.ServiceException;
import com.example.telepardaz.models.LegalMerchant;
import com.example.telepardaz.models.Merchant;
import com.example.telepardaz.repositories.LegalMerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LegalMerchantService extends BaseService<LegalMerchantRepository, LegalMerchant> {
    @Autowired
    private LinkService linkService;


    public MerchantResponse createLegalMerchant(LegalMerchant legalMerchant) throws ServiceException {
        return getMerchantResponse(saveLegalMerchant(legalMerchant));
    }

    private MerchantResponse getMerchantResponse(Merchant merchant) {
        MerchantResponse response = new MerchantResponse();
        response.setId(merchant.getId());
//        response.setFirstName(merchant.getFirstName());
//        response.setLastName(merchant.getLastName());
        response.setUrl("localhost:8080/link?code=" + merchant.getCode());
        return response;
    }

    private Merchant saveLegalMerchant(LegalMerchant legalMerchant) throws ServiceException {
        LegalMerchant entityLegal = new LegalMerchant();
        entityLegal.setStoreName(legalMerchant.getStoreName());
        entityLegal.setPostalCode(legalMerchant.getPostalCode());
        entityLegal.setDescription(legalMerchant.getDescription());
        entityLegal.setAddress(legalMerchant.getAddress());
        entityLegal.setPhone(legalMerchant.getPhone());
        entityLegal.setMobile(legalMerchant.getMobile());
        entityLegal.setEmail(legalMerchant.getEmail());
        entityLegal.setWebsite(legalMerchant.getWebsite());
        entityLegal.setIban(legalMerchant.getIban());
        entityLegal.setCode(legalMerchant.getCode());
        LegalMerchant savedNewMerchant = repository.save(entityLegal);
        savedNewMerchant.setCode(linkService.generateLink(savedNewMerchant));
        super.update(savedNewMerchant);
        return savedNewMerchant;
    }
}
