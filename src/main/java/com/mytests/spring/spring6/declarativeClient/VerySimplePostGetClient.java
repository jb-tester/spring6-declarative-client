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

public interface VerySimplePostGetClient {

    @PostExchange("/dummy")
    void postString(@RequestBody String foo);

    @GetExchange("/dummy")
    String getString();
}
