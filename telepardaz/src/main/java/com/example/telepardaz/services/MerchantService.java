package com.example.telepardaz.services;

import com.example.telepardaz.exceptions.ServiceException;
import com.example.telepardaz.dto.MerchantResponse;
import com.example.telepardaz.models.LegalMerchant;
import com.example.telepardaz.models.Merchant;
import com.example.telepardaz.models.PersonMerchant;
import com.example.telepardaz.repositories.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class MerchantService extends BaseService<MerchantRepository, Merchant> {
    @Autowired
    private LinkService linkService;

    public MerchantResponse createPersonMerchant(PersonMerchant personMerchant) throws ServiceException {
        return getMerchantResponse(savePersonMerchant(personMerchant));
    }

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
        Merchant savedNewMerchant = repository.save(entityPerson);
        savedNewMerchant.setCode(linkService.generateLink(savedNewMerchant));
        super.update(savedNewMerchant);
        return savedNewMerchant;
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
        Merchant savedNewMerchant = repository.save(entityLegal);
        savedNewMerchant.setCode(linkService.generateLink(savedNewMerchant));
        super.update(savedNewMerchant);
        return savedNewMerchant;
    }

    public String getPasswordEncrypt(String pass) {
        String encryptedpassword = null;
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(pass.getBytes());
            byte[] bytes = m.digest();
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            encryptedpassword = s.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return encryptedpassword;
    }
}
