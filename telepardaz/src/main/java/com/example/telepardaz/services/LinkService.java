package com.example.telepardaz.services;

import javax.xml.bind.DatatypeConverter;

import com.example.telepardaz.dto.MerchantBaseInfo;
import com.example.telepardaz.models.Merchant;
import com.example.telepardaz.repositories.MerchantRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class LinkService extends BaseService<MerchantRepository, Merchant> {

    public String generateLink(Merchant merchant) {
        MerchantBaseInfo dto=new MerchantBaseInfo();
        dto.setMerchantId(merchant.getMerchantId());
        dto.setFirstName(merchant.getFirstName());
        dto.setLastName(merchant.getLastName());
        String base64 = null;
        try {
            base64 = encode(dto);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return base64;
    }

    public String encode(MerchantBaseInfo merchant) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return DatatypeConverter.printBase64Binary(mapper.writeValueAsBytes(merchant));
    }

    public MerchantBaseInfo decode(String base64) throws IOException {
        byte [] bytes =  DatatypeConverter.parseBase64Binary(base64);
        ObjectMapper mapper = new ObjectMapper();
        Merchant decodedMerchant=mapper.readValue(bytes,Merchant.class);
        decodedMerchant=repository.findByMerchantId(decodedMerchant.getMerchantId());
        return getShowMerchant(decodedMerchant);
    }

    private static MerchantBaseInfo getShowMerchant(Merchant decodedMerchant) {
        MerchantBaseInfo response = new MerchantBaseInfo();
        response.setMerchantId(decodedMerchant.getMerchantId());
        response.setFirstName(decodedMerchant.getFirstName());
        response.setLastName(decodedMerchant.getLastName());
        return response;
    }
}
