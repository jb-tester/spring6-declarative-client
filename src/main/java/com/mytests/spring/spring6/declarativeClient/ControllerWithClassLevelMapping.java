package com.mytests.spring.spring6.declarativeClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * *
 * <p>Created by irina on 6/22/2022.</p>
 * <p>Project: spring-declarative-client</p>
 * *
 */
@RestController
@RequestMapping("/top_level/something")
public class ControllerWithClassLevelMapping {

    @GetMapping("/test1/foo")
    public String test1_foo(){
        return "test1_foo";
    }
}
