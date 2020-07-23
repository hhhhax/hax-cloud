package com.hax.user.demo;


import com.hax.common.security.annotations.EnableHaxFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * 网关应用
 */
@SpringCloudApplication
@EnableHaxFeignClients
public class HaxUserDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(HaxUserDemoApplication.class, args);
    }

}
