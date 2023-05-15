package com.example.telepardaz.services;

import com.example.telepardaz.dto.MerchantResponse;
import com.example.telepardaz.enums.MerchantType;
import com.example.telepardaz.exceptions.ServiceException;
import com.example.telepardaz.models.Merchant;
import com.example.telepardaz.models.PersonMerchant;
import com.example.telepardaz.repositories.PersonMerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PersonMerchantService extends BaseService<PersonMerchantRepository, PersonMerchant> {
    @Autowired
    private LinkService linkService;

    @Value("$base-url")
    private String baseUrl;

    public MerchantResponse createPersonMerchant(PersonMerchant personMerchant) throws ServiceException {
        return getMerchantResponse((PersonMerchant) savePersonMerchant(personMerchant));
    }

    private MerchantResponse getMerchantResponse(PersonMerchant merchant) {
        MerchantResponse response = new MerchantResponse();
        response.setId(merchant.getId());
        response.setName(merchant.getName());
        response.setUrl(baseUrl + "/link?code=" + merchant.getCode());
        return response;
    }

    private Merchant savePersonMerchant(PersonMerchant personMerchant) throws ServiceException {
        PersonMerchant savedNewMerchant = repository.save(personMerchant);
        savedNewMerchant.setCode(linkService.generateLink(savedNewMerchant, MerchantType.PERSON));
        super.update(savedNewMerchant);
        return savedNewMerchant;
    }
}
