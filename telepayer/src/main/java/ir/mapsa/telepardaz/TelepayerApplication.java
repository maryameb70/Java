package ir.mapsa.telepardaz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.awt.image.BufferedImage;

@SpringBootApplication
@EnableJpaRepositories
@EnableTransactionManagement
@EnableJpaAuditing
public class TelepayerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TelepayerApplication.class, args);
    }

    @Bean
    public HttpMessageConverter<BufferedImage> createImageHttpMessageConverter() {
        return new BufferedImageHttpMessageConverter();
    }
}
