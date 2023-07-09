package com.study.board1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo()); // apiInfo() 메서드 호출
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("First Spring Boot Board REST API")
                .version("1.0.0")
                .description("장지해의 첫번째 스프링 부트 프로젝트인 게시판 swagger api 입니다.")
                .build();
    }
}
