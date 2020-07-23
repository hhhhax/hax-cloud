package com.hax.system.demo;


import com.hax.common.security.annotations.EnableHaxFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**

 * 网关应用
 */
@SpringBootApplication
@EnableHaxFeignClients
public class HaxSystemDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HaxSystemDemoApplication.class, args);
	}

}
