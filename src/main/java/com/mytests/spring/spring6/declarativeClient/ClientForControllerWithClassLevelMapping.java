package com.mytests.spring.spring6.declarativeClient;

import org.springframework.web.service.annotation.GetExchange;

/**
 * *
 * <p>Created by irina on 6/22/2022.</p>
 * <p>Project: spring-declarative-client</p>
 * *
 */
public interface ClientForControllerWithClassLevelMapping {

    @GetExchange("/top_level/something/test1/foo")
    String t1();
}
