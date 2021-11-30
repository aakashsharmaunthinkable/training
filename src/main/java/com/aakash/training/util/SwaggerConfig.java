package com.aakash.training.util;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket getAPI() {
        Set produce = new HashSet(Arrays.asList("application/json", "application/xml"));
        Set consume = new HashSet(Arrays.asList("application/json", "application/xml"));
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(getAPIInfo()).produces(produce).consumes(consume);
    }

    public ApiInfo getAPIInfo() {
        return new ApiInfoBuilder().description("")
                .title("Training project apis")
                .version("1.0")
                .license("Apache License")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
                .build();
    }

}
