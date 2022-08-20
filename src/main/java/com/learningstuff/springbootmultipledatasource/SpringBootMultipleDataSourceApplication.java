package com.learningstuff.springbootmultipledatasource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringBootMultipleDataSourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMultipleDataSourceApplication.class, args);
    }

}
