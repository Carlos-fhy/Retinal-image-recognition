package com.yian.sportplay2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.yian.sportplay2.dao")
@SpringBootApplication
public class Sportplay2Application {

    public static void main(String[] args) {
        SpringApplication.run(Sportplay2Application.class, args);
    }

}
