package com.mytests.spring.spring6.declarativeClient;

import org.springframework.web.bind.annotation.*;


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
