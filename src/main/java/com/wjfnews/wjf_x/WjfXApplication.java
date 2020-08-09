package com.wjfnews.wjf_x;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAsync(proxyTargetClass = true)
public class WjfXApplication {

    public static void main(String[] args) {
        SpringApplication.run(WjfXApplication.class, args);
    }

}
