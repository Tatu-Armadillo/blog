package br.com.web3clubtravel.blog.config.springdoc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SpringDocConfiguration {

        @Bean
        public OpenAPI customerOpenAPI() {
                return new OpenAPI()
                                .info(new Info()
                                                .title("Club Travel")
                                                .version("v1")
                                                .description("Blog de viagem")
                                                .termsOfService("https://github.com/Tatu-Armadillo")
                                                .license(new License()
                                                                .name("Apache 2.0")
                                                                .url("https://github.com/Tatu-Armadillo")))
                                .components(new Components()
                                                .addSecuritySchemes("bearer-key",
                                                                new SecurityScheme()
                                                                                .type(SecurityScheme.Type.HTTP)
                                                                                .scheme("bearer").bearerFormat("JWT")));
        }

}
