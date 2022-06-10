package com.mytests.spring.spring6.declarativeClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * *
 * <p>Created by irina on 6/9/2022.</p>
 * <p>Project: spring-declarative-client</p>
 * *
 */
@RestController
public class WithPlaceholdersController {


    @RequestMapping("/${spring.application.name}/home")
    public String homeMapping() {
        return "home";
    }

    @GetMapping("/test${foo.bar}")
    public String fooBarMapping(){
        return "bar";
    }



    @GetMapping("/${foo.bar}/${foo.buzz}")
    public String multiPropsMapping(){
        return "buzz-and-bar";
    }



    @GetMapping("/${foo.boo}-and-{pv}")
    public String pathVarsMapping(@PathVariable String pv){
        return "boo + "+pv;
    }




    @GetMapping("/second/test-${foo.boo}-and-{pv}")
    public String pathVarsMapping2(@PathVariable String pv){
        return "boo + "+pv;
    }
}
