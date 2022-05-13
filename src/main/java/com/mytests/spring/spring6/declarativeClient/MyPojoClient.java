package com.mytests.spring.spring6.declarativeClient;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.util.List;

/**
 * *
 * <p>Created by irina on 5/13/2022.</p>
 * <p>Project: spring-declarative-client</p>
 * *
 */
@HttpExchange("/pojos")
public interface MyPojoClient {
    @PostExchange("/add")
    MyPojo addPojo(@RequestBody MyPojo pojo);

    @GetExchange
    List<MyPojo> getAllPojos();

    @GetExchange("/byProp3/{flag}")
    List<MyPojo> getPojosByProp3(@PathVariable("flag") boolean p3);

    @GetExchange(url = "/byId/{id}")
    MyPojo getPojoById(@PathVariable int id);

    @GetExchange("/byProp1")
    List<MyPojo> getPojosByProp1(@RequestParam("p1") String prop1);
}
