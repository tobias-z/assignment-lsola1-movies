package com.tobiasz.assignmentlsola1movies.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ConfigurationProperties("com.tobiasz.elastic")
@Configuration
@Getter
@Setter
public class ElasticSearchConfigurationProperties {

    @NotBlank
    private String host;

    @NotNull
    private Integer port;
}
