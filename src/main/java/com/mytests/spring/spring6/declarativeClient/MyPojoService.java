package com.mytests.spring.spring6.declarativeClient;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * *
 * <p>Created by irina on 5/13/2022.</p>
 * <p>Project: spring-declarative-client</p>
 * *
 */
@Service
public class MyPojoService {
    List<MyPojo> pojos = new ArrayList<>();

    @PostConstruct
    public void init(){
       pojos.add(new MyPojo(1, "p1_value1foo", 100, true));
       pojos.add(new MyPojo(2, "p1_foovalue2", 200, false));
       pojos.add(new MyPojo(3, "p1_value3bar", 50, false));
       pojos.add(new MyPojo(4, "p1_valuebar4", -2, true));
       pojos.add(new MyPojo(5, "p1_barvalue5", 1000, false));
    }

    public MyPojo getById(int id) {
        for (MyPojo pojo : pojos) {
            if(pojo.getId() == id) { return pojo;}
        }
        return null;
    }

    public List<MyPojo> getByProp3(Boolean p3) {
        List<MyPojo> rez = new ArrayList<>();
        for (MyPojo pojo : pojos) {
            if(pojo.getProp3().equals(p3)) { rez.add(pojo);}
        }
        return rez;
    }

    public List<MyPojo> findAll() {
        return pojos;
    }

    public void add(MyPojo pojo) {
        this.pojos.add(pojo);
    }

    public List<MyPojo> getByProp1Like(String p1) {
        List<MyPojo> rez = new ArrayList<>();
        for (MyPojo pojo : pojos) {
            if(pojo.getProp1().contains(p1)) { rez.add(pojo);}
        }
        return rez;
    }

    public List<MyPojo> getByProp1LikeOneOfParams(String p2, String p3) {
        List<MyPojo> rez = new ArrayList<>();
        for (MyPojo pojo : pojos) {
            if(pojo.getProp1().contains(p2)||pojo.getProp1().contains(p3)) { rez.add(pojo);}
        }
        return rez;
    }
}
