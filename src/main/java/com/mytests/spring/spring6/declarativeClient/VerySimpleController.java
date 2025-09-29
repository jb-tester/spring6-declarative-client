package com.mytests.spring.spring6.declarativeClient;

import org.springframework.web.bind.annotation.*;


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
