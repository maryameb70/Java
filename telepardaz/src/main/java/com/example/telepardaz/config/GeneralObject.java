package com.example.telepardaz.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneralObject {
    @Bean
    public QRCodeWriter barcodeWriter() {
        return new QRCodeWriter();
    }

}
