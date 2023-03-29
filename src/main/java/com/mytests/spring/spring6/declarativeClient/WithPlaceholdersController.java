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
@RequestMapping("/${spring.application.name}")
public class WithPlaceholdersController {


    @RequestMapping("/home")
    public String homeMapping() {
        return "home";
    }

    @GetMapping("/test${foo.bar}")
    public String fooBarMapping(){
        return "bar";
    }


    // completion and folding - fixed
    @GetMapping("/${foo.bar}/${foo.buzz}")
    public String multiPropsMapping(){
        return "buzz-and-bar";
    }

    // completion doesn't work
    @GetMapping("/${foo.bar}/${foo.buzz}-${foo.boo}")
    public String multiPropsInSameSegmentMapping(){
        return "bar-and-buzz-boo";
    }



    @GetMapping("/${foo.boo}-and-{pv}")
    public String pathVarsMapping(@PathVariable String pv){
        return "boo + "+pv;
    }




    @GetMapping("/second/test-${foo.boo}-and-{pv}")
    public String pathVarsMapping2(@PathVariable String pv){
        return "boo + "+pv;
    }

    @GetMapping("${url.with.pathvars}")
    public String pathVarsConsumedInPropertyUrl(@PathVariable String pv1,@PathVariable String pv2 ){
        return "all in property test with path vars "+pv1+" and "+pv2;
    }
}
