package com.example.telepardaz.services;

import com.example.telepardaz.dto.MerchantBaseInfo;
import com.example.telepardaz.enums.MerchantType;
import com.example.telepardaz.models.LegalMerchant;
import com.example.telepardaz.models.Merchant;
import com.example.telepardaz.models.PersonMerchant;
import com.example.telepardaz.repositories.MerchantRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class LinkService extends BaseService<MerchantRepository, Merchant> {
    @Value("${jwt.secret}")
    private String secret;

    public <T> String generateLink(T merchant, MerchantType type) {
        Map<String, Object> claims = new HashMap<>();
        String id = UUID.randomUUID().toString().replace("-", "");

        if (type == MerchantType.PERSON) {
            return getGenerateLinkCode((PersonMerchant) merchant, claims, id);
        }
        return getGenerateLinkCode((LegalMerchant) merchant, claims, id);
    }

    private <T extends Merchant> String getGenerateLinkCode(T merchant, Map<String, Object> claims, String id) {
        return Jwts.builder().setClaims(claims)
                .setSubject(merchant.getMerchantId())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .claim("name", merchant.getName())
                .claim("id", merchant.getId())
                .setId(id).signWith(SignatureAlgorithm.HS512, secret).compact();
    }


    public MerchantBaseInfo decode(String token) throws IOException {
        String[] chunks = token.split("\\.");
        Base64.Decoder decoder = Base64.getUrlDecoder();
        String payload = new String(decoder.decode(chunks[1]));

        return getShowMerchant(payload);
    }

    private MerchantBaseInfo getShowMerchant(String payload) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(payload, MerchantBaseInfo.class);
    }
}
