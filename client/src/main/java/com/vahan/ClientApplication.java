package com.vahan;

/**
 * Created by TCE\vahany on 3/30/17.
 */

import com.vahan.domain.User5;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ClientApplication {

    private static final Logger log = LoggerFactory.getLogger(ClientApplication.class);

    public static void main(String args[]) {
        SpringApplication.run(ClientApplication.class);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {

            /*User5 user5 = restTemplate.getForObject("http://localhost:8080/posts/3",User5.class);

            System.out.println(user5.getName());*/

            User5 user5 = new User5();
            user5.setName("Mojoj");
            user5.setPassword("888");

            restTemplate.postForObject("http://localhost:8080/posts/userAdd",user5,User5.class);



        };
    }
}