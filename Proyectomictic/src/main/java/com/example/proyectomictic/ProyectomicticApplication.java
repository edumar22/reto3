package com.example.proyectomictic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

import javax.persistence.Entity;
/*
@SpringBootApplication(scanBasePackages = "com.example.proyectomictic")
@EntityScan("com.example.proyectomictic.entities")
@EnableJdbcRepositories("com.example.proyectomictic.repository")

 */
//@EnableConfigurationProperties

@SpringBootApplication
public class ProyectomicticApplication {

    public static void main(String[] args) {

        SpringApplication.run(ProyectomicticApplication.class, args);
    }

}



