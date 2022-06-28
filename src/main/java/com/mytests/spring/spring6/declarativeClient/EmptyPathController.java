package com.mytests.spring.spring6.declarativeClient;

import org.springframework.web.bind.annotation.*;

/**
 * *
 * <p>Created by irina on 6/8/2022.</p>
 * <p>Project: spring-declarative-client</p>
 * *
 */
@RestController
@RequestMapping
public class EmptyPathController {

    @GetMapping
    public String getSmth(){

        return this.str;
    }

    @PostMapping
    public void postSmth(@RequestBody String str){
        this.str = str;
    }

    String str = "nothing";
}
