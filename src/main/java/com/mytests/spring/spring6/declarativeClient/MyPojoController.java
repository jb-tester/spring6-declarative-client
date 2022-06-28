package com.mytests.spring.spring6.declarativeClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * *
 * <p>Created by irina on 5/13/2022.</p>
 * <p>Project: spring-declarative-client</p>
 * *
 */
@RestController
public class MyPojoController {

    @Autowired
    private MyPojoService pojoService;

    @GetMapping("/pojos")
    public List<MyPojo> getAllPojos(){
        return pojoService.findAll();
    }

    @GetMapping("/pojos/byId/{id}")
    public MyPojo byId(@PathVariable("id") int id) {
        return pojoService.getById(id);
    }

    @GetMapping("/pojos/byProp3/{p3}")
    public List<MyPojo> byProp3(@PathVariable("p3") Boolean p3) {
        return pojoService.getByProp3(p3);
    }
    @GetMapping("/pojos/byProp3/foo")
    public List<MyPojo> byProp3_1() {
        return pojoService.getByProp3(true);
    }
    @GetMapping("/pojos/byProp3/bar")
    public List<MyPojo> byProp3_2() {
        return pojoService.getByProp3(false);
    }
    @GetMapping(value= "/pojos/byProp1", params = "p1")
    public List<MyPojo> byProp1LikePassedReqParameter(@RequestParam("p1") String p1) {
        return pojoService.getByProp1Like(p1);
    }
    @GetMapping(path= "/pojos/byProp1", params = {"p2","p3"})
    public List<MyPojo> byProp1LikeOneOfPassedParams(@RequestParam("p2") String p2, @RequestParam("p3") String p3) {
        return pojoService.getByProp1LikeOneOfParams(p2,p3);
    }
    @PostMapping(path = "/pojos/add")
    public MyPojo addPojo(@RequestBody MyPojo pojo){
        pojoService.add(pojo);
        return pojo;
    }
}
