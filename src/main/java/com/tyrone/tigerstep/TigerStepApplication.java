package com.tyrone.tigerstep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class TigerStepApplication {

    public static void main(String[] args) {
        SpringApplication.run(TigerStepApplication.class, args);
    }

}
