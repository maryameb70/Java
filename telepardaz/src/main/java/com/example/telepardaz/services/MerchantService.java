package com.example.telepardaz.services;

import com.example.telepardaz.exceptions.ServiceException;
import com.example.telepardaz.dto.MerchantResponse;
import com.example.telepardaz.models.Merchant;
import com.example.telepardaz.repositories.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

@Service
public class MerchantService extends BaseService<MerchantRepository, Merchant> {
    @Autowired
    private LinkService linkService;

    public MerchantResponse create(Merchant merchant) throws ServiceException {
        Merchant existingMerchant = repository.findByUsername(merchant.getUsername());
        if (existingMerchant != null) {
            throw new ServiceException("this-merchant-exists-in-the-system");
        }
        return getMerchantResponse( saveMerchant(merchant));
    }

    private MerchantResponse getMerchantResponse(Merchant merchant) {
        MerchantResponse response = new MerchantResponse();
        response.setId(merchant.getId());
        response.setFirstName(merchant.getFirstName());
        response.setLastName(merchant.getLastName());
        response.setUrl("localhost:8080/link?code=" + merchant.getCode());
        return response;
    }

    private Merchant saveMerchant(Merchant merchant) throws ServiceException {
        Merchant entity = new Merchant();
        entity.setUsername(merchant.getUsername());
        entity.setPassword(getPasswordEncrypt(merchant.getPassword()));
        entity.setFirstName(merchant.getFirstName());
        entity.setLastName(merchant.getLastName());
        entity.setAccountNumber(merchant.getAccountNumber());
        entity.setCardNumber(merchant.getCardNumber());
        entity.setQrCodes(merchant.getQrCodes());
        entity.setMerchantId(String.valueOf(UUID.randomUUID()));
        entity.setUserId(merchant.getUserId());
        Merchant savedNewMerchant=repository.save(entity);
        savedNewMerchant.setCode(linkService.generateLink(savedNewMerchant));
        super.update(savedNewMerchant);
        return savedNewMerchant;
    }

    public String getPasswordEncrypt(String pass)
    {
        String encryptedpassword = null;
        try
        {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(pass.getBytes());
            byte[] bytes = m.digest();
            StringBuilder s = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            encryptedpassword = s.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return encryptedpassword;
    }
}
