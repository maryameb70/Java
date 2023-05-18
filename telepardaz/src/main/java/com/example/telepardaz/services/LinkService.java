package com.example.telepardaz.services;

import com.example.telepardaz.dto.MerchantBaseInfo;
import com.example.telepardaz.enums.MerchantType;
import com.example.telepardaz.models.LegalMerchant;
import com.example.telepardaz.models.Merchant;
import com.example.telepardaz.models.PersonMerchant;
import com.example.telepardaz.repositories.MerchantRepository;
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
    @Autowired
    private ObjectMapper mapper;

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
        Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token).getBody();
        Long id = ((Number) claims.get("id")).longValue();
        String name = (String) claims.get("name");
        return getShowMerchant(name, id);
    }

    private static MerchantBaseInfo getShowMerchant(String fullname, Long id) {
        MerchantBaseInfo response = new MerchantBaseInfo();
        response.setId(id);
        response.setName(fullname);
        return response;
    }
}
