package com.hjwzyy;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;
import org.springframework.context.annotation.Configuration;

//@EnableTurbine
@EnableDiscoveryClient
//@EnableTurbineStream    //使用rabbitmq添加
@Configuration
@EnableAutoConfiguration
@EnableTurbineStream
@SpringBootApplication
public class MicroserviceHystrixTurbineApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceHystrixTurbineApplication.class, args);
	}
}
