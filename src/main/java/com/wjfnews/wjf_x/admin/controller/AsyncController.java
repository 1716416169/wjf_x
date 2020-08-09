package com.wjfnews.wjf_x.admin.controller;

import com.wjfnews.wjf_x.admin.service.AsyncService;
import com.wjfnews.wjf_x.admin.service.impl.AsyncServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Async")
public class AsyncController {
    @Autowired
    AsyncServiceImpl asyncService;

    @PostMapping("mail")
    public String mail() {
        String mail = asyncService.mail();
        return mail;
    }
}
