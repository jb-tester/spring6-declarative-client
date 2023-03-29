package com.mytests.spring.spring6.declarativeClient;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

/**
 * *
 * <p>Created by irina on 6/9/2022.</p>
 * <p>Project: spring-declarative-client</p>
 * *
 */
@HttpExchange(url = "/${spring.application.name}")
public interface WithPlaceholdersClient {

    @GetExchange("/home")
    String getAppHome();

    @GetExchange("/${foo.bar}")
    String getFooBar();

    @GetExchange("/${foo.bar}/${foo.buzz}")
    String getFooBarBuzz();

    @GetExchange("/${foo.boo}-and-{pv}")
    String getBooPlusPathVar(@PathVariable String pv);

    @GetExchange("/second/test-${foo.boo}-and-{pv}")
    String pathVarsMapping2(@PathVariable String pv);

    @GetExchange("${url.with.pathvars}")
    String pathVarsConsumedInPropertyUrl(@PathVariable String pv1, @PathVariable String pv2);
}
