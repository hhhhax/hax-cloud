package com.hax.job.config;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * <p>
 * 定时任务配置，配置线程池，使用不同线程执行任务，提升效率
 * </p>
 *
 * @package: com.hax.job.task
 * @description: 定时任务配置，配置线程池，使用不同线程执行任务，提升效率
 * @author: huaxin.chen
 * @date: Created in 2019/12/12
 */
@Configuration
@EnableScheduling
@ComponentScan(basePackages = {"com.hax.job.task"})
public class TaskConfig implements SchedulingConfigurer {
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(taskExecutor());
    }


    @Bean
    public Executor taskExecutor() {
        return new ScheduledThreadPoolExecutor(20, new BasicThreadFactory.Builder().namingPattern("Job-Thread-%d").build());
    }
}
