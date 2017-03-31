package com.vahan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by TCE\vahany on 3/29/17.
 */
/*@EnableMongoRepositories("com.vahan.repository")*/

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class ApiApplication {
    public static void main(String[] args) throws Exception {

        /*ConfigurableApplicationContext context =*/
        SpringApplication.run(ApiApplication.class, args);
/*
        User user = new User();
        user.setId(2);
        user.setName("sos");
        user.setPassword("789");
        UserRepository repository = context.getBean(UserRepository.class);
        repository.save(user);*/
    }


}
