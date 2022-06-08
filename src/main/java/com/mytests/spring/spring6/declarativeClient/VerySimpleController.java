package com.mytests.spring.spring6.declarativeClient;

import org.springframework.web.bind.annotation.*;

/**
 * *
 * <p>Created by irina on 6/8/2022.</p>
 * <p>Project: spring-declarative-client</p>
 * *
 */
@RestController
public class VerySimpleController {

    @GetMapping("/dummy")
    public String singleMapping(){

        return str;
    }

    @PostMapping("/dummy")
    public void postSmth(@RequestBody String str){


        this.str = str;
    }

    String str = "nothing";
}
