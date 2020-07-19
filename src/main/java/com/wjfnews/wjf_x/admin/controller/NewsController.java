package com.wjfnews.wjf_x.admin.controller;

import com.wjfnews.wjf_x.admin.entity.News;
import com.wjfnews.wjf_x.admin.service.impl.NewsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class NewsController {

    @Autowired
    NewsServiceImpl newsService;

    @PutMapping("/insertNews")
    public News InsertNews(@RequestBody News news){
        System.out.println("时间："+news.getCreateOn());
        System.out.println("时间："+news.getUpdateOn());
        News news1 = newsService.insertNews(news);
        return news1;
    }

    @DeleteMapping("/deleteNews")
    public List<Integer> deleteNews(@RequestBody(required = false) List<Integer> ids){
        List<Integer> list = newsService.deleteNews(ids);
        return list;
    }

    @PostMapping("/updateNews")
    public News updateNews(@RequestBody News news){
        News news1 = newsService.updateNews(news);
        return news1;
    }

    @GetMapping("/getNewsByKey")
    public Page<News> getNewsByKey(Integer page, Integer size, String key){
        Page<News> news = newsService.selectNewsByKey(page-1, size, key);
        return news;
    }

    @GetMapping("/getNews")
    public Page<News> getNews(Integer page, Integer size){
        Page<News> news = newsService.selectAllNews(page-1, size);
        return news;
    }
}
