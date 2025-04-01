package com.ssafy.ws;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public OpenAPI openAPI() {
        Info info = new Info()
                .title("SSAFY GuestBook API")
                .version("v1.0")
                .description("<h3>SSAFY API Reference for Developers</h3>Swagger를 이용한 GuestBook API<br><img src=\"/img/ssafy_logo.png\" width=\"150\">")
        		.license(new License().name("SSAFY License").url("https://www.ssafy.com/ksp/jsp/swp/etc/swpPrivacy.jsp"))
        		.contact(new Contact().name("ssafy").email("ssafy@ssafy.com"));
        

        return new OpenAPI()
                .info(info);
    }
}

