package com.hjwzyy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceConsumerMovieRibbonApplication {

	/**
	 * @Bean 是一个方法注解，作用是实例化一个Bean并使用该方法的名称命名。在本例中，添加@Bean注解的restTemplate()方法，等价于RestTemplate restTemplate = new RestTemplate();
	 * @LoadBalanced 可以为RestTemplate整合Ribbon 使其具备负载均衡的能力。
	 * @return
	 */
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceConsumerMovieRibbonApplication.class, args);
	}
}
