package com.kashish.astrologer_crm.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
                .info(
                        new Info()
                                .title("Astrologer CRM API")
                                .version("1.0")
                                .description("CRM for Astrologers, Clients and Appointments")
                                .contact(
                                        new Contact()
                                                .name("Kashish Gupta")
                                                .email("your-email@gmail.com")
                                )
                );
    }
}
