package com.mx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.context.web.SpringBootServletInitializer

@SpringBootApplication
public class AppWebApplication extends SpringBootServletInitializer{

    public static void main(String[] args) {
        SpringApplication.run(AppWebApplication.class, args);
    }

    SpringApplicationBuilder configure(SpringApplicationBuilder application) {
      application.source(AppWebApplication.class)
    }
}
