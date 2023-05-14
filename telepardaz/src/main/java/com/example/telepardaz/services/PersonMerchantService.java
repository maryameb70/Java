package com.example.telepardaz.services;

import com.example.telepardaz.dto.MerchantResponse;
import com.example.telepardaz.exceptions.ServiceException;
import com.example.telepardaz.models.Merchant;
import com.example.telepardaz.models.PersonMerchant;
import com.example.telepardaz.repositories.PersonMerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonMerchantService extends BaseService<PersonMerchantRepository, PersonMerchant> {
    @Autowired
    private LinkService linkService;

    public MerchantResponse createPersonMerchant(PersonMerchant personMerchant) throws ServiceException {
        return getMerchantResponse(savePersonMerchant(personMerchant));
    }

    private MerchantResponse getMerchantResponse(Merchant merchant) {
        MerchantResponse response = new MerchantResponse();
        response.setId(merchant.getId());
//        response.setFirstName(merchant.getFirstName());
//        response.setLastName(merchant.getLastName());
        response.setUrl("localhost:8080/link?code=" + merchant.getCode());
        return response;
    }

    private Merchant savePersonMerchant(PersonMerchant personMerchant) throws ServiceException {
        PersonMerchant entityPerson = new PersonMerchant();
        entityPerson.setFirstName(personMerchant.getFirstName());
        entityPerson.setLastName(personMerchant.getLastName());
        entityPerson.setPhone(personMerchant.getPhone());
        entityPerson.setMobile(personMerchant.getMobile());
        entityPerson.setEmail(personMerchant.getEmail());
        entityPerson.setWebsite(personMerchant.getWebsite());
        entityPerson.setIban(personMerchant.getIban());
        entityPerson.setCode(personMerchant.getCode());
        PersonMerchant savedNewMerchant = repository.save(entityPerson);
        savedNewMerchant.setCode(linkService.generateLink(savedNewMerchant));
        super.update(savedNewMerchant);
        return savedNewMerchant;
    }
}
