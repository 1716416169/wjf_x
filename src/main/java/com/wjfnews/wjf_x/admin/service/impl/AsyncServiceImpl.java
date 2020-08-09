package com.wjfnews.wjf_x.admin.service.impl;

import com.wjfnews.wjf_x.admin.service.AsyncService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncServiceImpl implements AsyncService {

    @Async   /*开启异步任务，自动创建线程池，不会让前端挂起白屏等待  */
    @Override
    public String mail() {
        try {
            Thread.sleep(5000);
            System.out.println("正在处理中·······");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "异步发送邮件";
    }
}
