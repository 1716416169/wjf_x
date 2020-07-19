package com.wjfnews.wjf_x.admin.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.wjfnews.wjf_x.admin.entity.News;
import com.wjfnews.wjf_x.admin.entity.NewsCate;
import com.wjfnews.wjf_x.admin.service.impl.NewsCateServiceImpl;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("admin")
public class NewsCateController {//新闻管理

    @Autowired
    NewsCateServiceImpl newsCateService;

    @PutMapping("/insertNewsCate")
    public NewsCate InsertNewsCate(@RequestBody NewsCate newsCate){
        System.out.println(newsCate);
        NewsCate newsCate1 = newsCateService.insertNewsCate(newsCate);
        return newsCate1;
    }

    @DeleteMapping("/deleteNewsCates")
    public List<Integer> deleteNewsCates(@RequestBody(required = false) List<Integer> ids){
        List<Integer> list = newsCateService.deleteNewsCate(ids);
        return list;
    }

    @PostMapping("/updateNewsCate")
    public NewsCate updateNewsCate(@RequestBody NewsCate newsCate){
        NewsCate newsCate1 = newsCateService.updateNewsCate(newsCate);
        return newsCate1;
    }

    @GetMapping("/getNewsCateByKey")
    public Page<NewsCate> getNewsCateByKey(Integer page, Integer size, String key){
        Page<NewsCate> newsCates = newsCateService.selectNewsCateByKey(page-1, size, key);
        return newsCates;
    }

    @GetMapping("/getNewsCate")
    public Page<NewsCate> getNewsCate(Integer page, Integer size){
        Page<NewsCate> newsCates = newsCateService.selectAllNewsCate(page-1, size);
        return newsCates;
    }

    @GetMapping("/getAllNewsCate")
    public List<NewsCate> getAllNewsCate(Integer page, Integer size){
        List<NewsCate> allNewsCate = newsCateService.getAllNewsCate();
        return allNewsCate;
    }
}
