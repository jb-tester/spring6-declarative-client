package com.mytests.spring.spring6.declarativeClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.EmbeddedValueResolver;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;


@SpringBootApplication
public class SpringDeclarativeClientApplication {



    public static void main(String[] args) {
        SpringApplication.run(SpringDeclarativeClientApplication.class, args);
    }


    // ======== Run all clients: =========

    @Bean
    public ApplicationRunner applicationRunner(MyPojoClient client) {
        return args -> {
            System.out.println("------ all pojos test:");
            for (MyPojo p : client.getAllPojos()) {
                System.out.println(p);
            }
            System.out.println("------ pojoById test:");
            System.out.println("pojo with id==3: "+client.getPojoById(3));
            System.out.println("prop1 of pojo with id==4: "+client.getPojoById(4).getProp1());
            System.out.println("------ pojosByProp3 test:");
            for (MyPojo p : client.getPojosByProp3(true)) {
                System.out.println(p);
            }
            System.out.println("------ pojosByProp1 test: by single request parameter 'p1'");
            for (MyPojo p : client.getPojosByProp1("bar")) {
                System.out.println(p);
            }
            System.out.println("------ pojosByProp1 test: by 2 request parameters 'p2' and 'p3'");
            for (MyPojo p : client.getPojosByProp1Alt("2","3")) {
                System.out.println(p);
            }
            System.out.println("------ addPojo test:");
            MyPojo rez = client.addPojo(new MyPojo(8, "some_value", 8, true));
            System.out.println("add pojo:"+ rez);
            System.out.println("return the just-added pojo by its id :"+ client.getPojoById(rez.getId()).getProp1());
            System.out.println("------ all pojos after adding test:");
            for (MyPojo p : client.getAllPojos()) {
                System.out.println(p);
            }

        };
    }

    @Bean
    public ApplicationRunner appRunner2(SimplePostGetClient client) {
        return args -> {

            System.out.println("simple get:");
            System.out.println(client.foo());
            System.out.println("simple post and get:");
            client.postFoo("foo");
            System.out.println(client.foo());
        };
    }
    @Bean
    public ApplicationRunner appRunner3(VerySimplePostGetClient client) {
        return args -> {

            System.out.println("very simple get:");
            System.out.println(client.getString());
            System.out.println("very simple post and get:");
            client.postString("hello");
            System.out.println(client.getString());
        };
    }
    @Bean
    public ApplicationRunner appRunner4(EmptyPathClient client) {
        return args -> {

            System.out.println(" get from '/':");
            System.out.println(client.getFromHome());
            System.out.println(" post and get from '/':");
            client.postToHome("hello");
            System.out.println(client.getFromHome());
        };
    }

    @Bean
    public ApplicationRunner appRunner5(WithPlaceholdersClient client) {
        return args -> {
            System.out.println("with placeholders test: ");

            System.out.println(" get from with pp and pv:");
            System.out.println(client.getBooPlusPathVar("ppp"));
            System.out.println(" get from url that is pp:");
            System.out.println(client.pathVarsConsumedInPropertyUrl("p1","p2"));
        };
    }
}
