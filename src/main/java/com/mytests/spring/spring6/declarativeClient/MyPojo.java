package com.mytests.spring.spring6.declarativeClient;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * *
 * <p>Created by irina on 5/13/2022.</p>
 * <p>Project: spring-declarative-client</p>
 * *
 */
public class MyPojo  {
    int id;
    String prop1;
    int prop2;
    Boolean prop3;



    public MyPojo(@JsonProperty("id") int id, @JsonProperty("prop1") String prop1, @JsonProperty("prop2") int prop2, @JsonProperty("prop3") Boolean prop3) {
        this.id = id;
        this.prop1 = prop1;
        this.prop2 = prop2;
        this.prop3 = prop3;
    }

    public String getProp1() {
        return prop1;
    }

    public void setProp1(String prop1) {
        this.prop1 = prop1;
    }

    public int getProp2() {
        return prop2;
    }

    public void setProp2(int prop2) {
        this.prop2 = prop2;
    }

    public Boolean getProp3() {
        return prop3;
    }

    public void setProp3(Boolean prop3) {
        this.prop3 = prop3;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MyPojo{" +
                "id=" + id +
                ", prop1='" + prop1 + '\'' +
                ", prop2=" + prop2 +
                ", prop3=" + prop3 +
                '}';
    }
}
