package com.mytests.spring.spring6.declarativeClient;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

/**
 * *
 * <p>Created by irina on 6/8/2022.</p>
 * <p>Project: spring-declarative-client</p>
 * *
 */
@HttpExchange
public interface EmptyPathClient {

    @PostExchange
    void postToHome(@RequestBody String foo);

    @GetExchange
    String getFromHome();
}
