package com.capone.decrypto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.capone.decrypto")
public class DecryptoCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(DecryptoCrudApplication.class, args);
    }
}
