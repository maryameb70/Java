package com.example.telepardaz.services;

import javax.xml.bind.DatatypeConverter;
import com.example.telepardaz.models.Merchant;
import com.example.telepardaz.repositories.MerchantRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class LinkService extends BaseService<MerchantRepository, Merchant> {

    public String generateLink(Merchant merchant) {
        Merchant newMerchant=new Merchant();
        newMerchant.setMerchantId(merchant.getMerchantId());
        newMerchant.setFirstName(merchant.getFirstName());
        newMerchant.setLastName(merchant.getLastName());
        String base64 = null;
        try {
            base64 = encode(newMerchant);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return base64;
    }

    public String encode(Merchant merchant) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return DatatypeConverter.printBase64Binary(mapper.writeValueAsBytes(merchant));
    }

    public Merchant decode(String base64) throws IOException {
        byte [] bytes =  DatatypeConverter.parseBase64Binary(base64);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(bytes,Merchant.class);
    }

}
