package com.mytests.spring.spring6.declarativeClient;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@SpringBootApplication
public class SpringDeclarativeClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDeclarativeClientApplication.class, args);
    }

    @Bean
    public MyPojoClient myPojoClient() {
        WebClient web_client = WebClient.builder()
                .baseUrl("http://localhost:8080")
                .build();
        HttpServiceProxyFactory proxyFactory =
                HttpServiceProxyFactory.builder(new WebClientAdapter(web_client)).build();

        return proxyFactory.createClient(MyPojoClient.class);
    }

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
}
