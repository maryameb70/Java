package com.example.telepardaz.controllers;

import com.example.telepardaz.utills.TokenValidResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name ="authentication", url = "192.168.43.12:8081")
public interface MerchantClient {
    @GetMapping("/api/token/is-valid")
    TokenValidResponse checkvalid(@RequestHeader(name = "Authorization") String token);
}
