package com.hax.job;

import com.hax.common.security.annotations.EnableHaxFeignClients;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * <p>
 * 定时任务模块启动器
 * </p>
 *
 */
@SpringCloudApplication
@EnableHaxFeignClients
public class HaxTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(HaxTaskApplication.class, args);
    }
}
