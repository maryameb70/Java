package com.example.telepardaz.services;

import com.example.telepardaz.controllers.MerchantClient;
import com.example.telepardaz.dto.MerchantResponse;
import com.example.telepardaz.exceptions.RequiredLoginException;
import com.example.telepardaz.exceptions.ServiceException;
import com.example.telepardaz.models.LegalMerchant;
import com.example.telepardaz.models.Merchant;
import com.example.telepardaz.repositories.LegalMerchantRepository;
import com.example.telepardaz.utills.TokenValidResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LegalMerchantService extends BaseService<LegalMerchantRepository, LegalMerchant> {
    @Autowired
    private LinkService linkService;

    //    @Autowired
//    private MerchantClient merchantClient;

    @Value("$base-url")
    private String baseUrl;

    public MerchantResponse createLegalMerchant(LegalMerchant legalMerchant) throws ServiceException {
//        TokenValidResponse checkvalid = merchantClient.checkvalid(token);
//        if (!checkvalid.getIsValid()) {
//            throw new RequiredLoginException("user-required-login");
//        }
        return getMerchantResponse((LegalMerchant) saveLegalMerchant(legalMerchant));
    }

    private MerchantResponse getMerchantResponse(LegalMerchant merchant) {
        MerchantResponse response = new MerchantResponse();
        response.setId(merchant.getId());
        response.setName(merchant.getStoreName());
        response.setUrl(baseUrl + "/link?code=" + merchant.getCode());
        return response;
    }

    private Merchant saveLegalMerchant(LegalMerchant legalMerchant) throws ServiceException {
        LegalMerchant savedNewMerchant = repository.save(legalMerchant);
        savedNewMerchant.setCode(linkService.generateLink(savedNewMerchant));
        super.update(savedNewMerchant);
        return savedNewMerchant;
    }
}
