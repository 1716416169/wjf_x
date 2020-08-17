package com.wjfnews.wjf_x.test;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    //@Scheduled(cron = "0/3 * * * * 1-7")  //任务调度 不需要被对象调用 自己会运行 每3秒运行一次
    public void Schedulingtest() {
        System.out.println("执行");
    }
}
