package com.example.proyectomictic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

import javax.persistence.Entity;
/*
@SpringBootApplication(scanBasePackages = "com.example.proyectomictic")
@EntityScan(basePackages={"com.example.proyectomictic.entities"})
@EnableJdbcRepositories("com.example.proyectomictic.repository")


@SpringBootApplication
@EntityScan(basePackages={"com.example.retobicicleta.Model" })
//@EnableJpaRepositories("Repository")


 */
//@EnableConfigurationProperties

@SpringBootApplication
@EntityScan(basePackages={"com.example.proyectomictic.entities"})
//@EnableJdbcRepositories("com.example.proyectomictic.repository")
public class ProyectomicticApplication {

    public static void main(String[] args) {

        SpringApplication.run(ProyectomicticApplication.class, args);
    }

}



