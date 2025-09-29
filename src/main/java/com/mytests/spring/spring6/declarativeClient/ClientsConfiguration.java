package com.mytests.spring.spring6.declarativeClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.EmbeddedValueResolver;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

/**
 * *
 * <p>Created by irina on 3/29/2023.</p>
 * <p>Project: spring-declarative-client</p>
 * *
 */
@Configuration
public class ClientsConfiguration {

    final ConfigurableApplicationContext ctx;

    public ClientsConfiguration(ConfigurableApplicationContext ctx) {
        this.ctx = ctx;
    }

    // ======== Define the client beans: =========
    @Bean
    public MyPojoClient myPojoClient() {
        WebClient web_client = WebClient.builder()
                .baseUrl("http://localhost:8081/spring6/tests")
                .build();
        HttpServiceProxyFactory proxyFactory =
                HttpServiceProxyFactory.builder(WebClientAdapter.forClient(web_client)).build();

        return proxyFactory.createClient(MyPojoClient.class);
    }

    @Bean
    public SimplePostGetClient simpleGetClient() {
        WebClient web_client = WebClient.builder()
                .baseUrl("http://localhost:8081/spring6/tests")
                .build();
        HttpServiceProxyFactory proxyFactory =
                HttpServiceProxyFactory.builder(WebClientAdapter.forClient(web_client)).build();

        return proxyFactory.createClient(SimplePostGetClient.class);
    }

    @Bean
    public VerySimplePostGetClient verySimpleGetClient() {
        WebClient web_client = WebClient.builder()
                .baseUrl("http://localhost:8081/spring6/tests")
                .build();
        HttpServiceProxyFactory proxyFactory =
                HttpServiceProxyFactory.builder(WebClientAdapter.forClient(web_client)).build();

        return proxyFactory.createClient(VerySimplePostGetClient.class);
    }
    @Bean
    public EmptyPathClient emptyPathClient() {
        WebClient web_client = WebClient.builder()
                .baseUrl("http://localhost:8081/spring6/tests")
                .build();
        HttpServiceProxyFactory proxyFactory =
                HttpServiceProxyFactory.builder(WebClientAdapter.forClient(web_client)).build();

        return proxyFactory.createClient(EmptyPathClient.class);
    }
    // beans for the endpoints with placeholders:
    @Bean
    public EmbeddedValueResolver embeddedValueResolver(ConfigurableApplicationContext ctx){

        return new EmbeddedValueResolver(ctx.getBeanFactory());
    }

    @Bean
    public WithPlaceholdersClient withPlaceholdersClient() {
        WebClient web_client = WebClient.builder()
               // .baseUrl("http://localhost:8081/spring6/tests")
                .build();
        HttpServiceProxyFactory proxyFactory =
                HttpServiceProxyFactory.builder(WebClientAdapter.forClient(web_client))
                        .embeddedValueResolver(embeddedValueResolver(ctx))
                        .build();

        return proxyFactory.createClient(WithPlaceholdersClient.class);
    }

}
