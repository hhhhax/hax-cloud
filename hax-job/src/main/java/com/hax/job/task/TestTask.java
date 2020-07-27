package com.hax.job.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 订单支付信息上链定时任务
 * </p>
 */
@Component
@Slf4j
public class TestTask {



    //每分钟一次
    @Scheduled(cron = "0 0/1 * * * ? ")
    public void job() {
      System.out.println("我开始执行了嘻嘻");
    }


}