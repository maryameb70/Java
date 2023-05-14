package com.example.telepardaz.services;

import javax.xml.bind.DatatypeConverter;

import com.example.telepardaz.dto.MerchantBaseInfo;
import com.example.telepardaz.models.Merchant;
import com.example.telepardaz.repositories.MerchantRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.Optional;

@Service
public class LinkService extends BaseService<MerchantRepository, Merchant> {
    @Autowired
    private ObjectMapper mapper;

    public String generateLink(Merchant merchant) {
        MerchantBaseInfo dto=new MerchantBaseInfo();
        dto.setId(merchant.getId());
//        dto.setFirstName(merchant.getFirstName());
//        dto.setLastName(merchant.getLastName());
        String base64 = null;
        try {
            base64 = encode(dto);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return base64;
    }

    public String encode(MerchantBaseInfo merchant) throws JsonProcessingException {
        return DatatypeConverter.printBase64Binary(mapper.writeValueAsBytes(merchant));
    }

    public MerchantBaseInfo decode(String base64) throws IOException {
        byte [] bytes =  DatatypeConverter.parseBase64Binary(base64);
        Optional<Merchant> decodedMerchant= Optional.ofNullable(mapper.readValue(bytes, Merchant.class));
        decodedMerchant=repository.findById(decodedMerchant.get().getId());
        return getShowMerchant(decodedMerchant);
    }

    private static MerchantBaseInfo getShowMerchant(Optional<Merchant> decodedMerchant) {
        MerchantBaseInfo response = new MerchantBaseInfo();
        response.setId(decodedMerchant.get().getId());
//        response.setFirstName(decodedMerchant.get().getFirstName());
//        response.setLastName(decodedMerchant.get().getLastName());
        return response;
    }
}
