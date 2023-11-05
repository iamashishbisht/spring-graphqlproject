package com.project.graphqlproject.springgraphqlproject.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.client.HttpGraphQlClient;

@Configuration
public class GraphqlConfiguration {

    @Bean
    HttpGraphQlClient httpGraphQlClient(){
        return HttpGraphQlClient.builder().url("http://localhost:8080/graphql").build();
    }
}
