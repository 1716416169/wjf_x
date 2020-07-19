package com.wjfnews.wjf_x.admin.controller;

import com.wjfnews.wjf_x.admin.entity.NewsComment;
import com.wjfnews.wjf_x.admin.service.NewsCommentService;
import com.wjfnews.wjf_x.admin.service.impl.NewsCommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class NewsCommentController {
    @Autowired
    NewsCommentServiceImpl newsCommentService;

    @PutMapping("/insertNewsComment")
    public NewsComment InsertNewsComment(@RequestBody NewsComment newsComment){
        System.out.println("插入的评论："+newsComment);
        NewsComment newsComment1 = newsCommentService.insertNewsComment(newsComment);
        return newsComment1;
    }

    @DeleteMapping("/deleteNewsComment")
    public List<Integer> deleteNewsComment(@RequestBody(required = false) List<Integer> ids){
        List<Integer> list = newsCommentService.deleteNewsComment(ids);
        return list;
    }

    @PostMapping("/updateNewsComment")
    public NewsComment updateNewsComment(@RequestBody NewsComment newsComment){
        NewsComment newsComment1 = newsCommentService.updateNewsComment(newsComment);
        return newsComment1;
    }

    @GetMapping("/getNewsCommentByKey")
    public Page<NewsComment> getNewsCommentByKey(Integer page, Integer size, String key){
        Page<NewsComment> newsComments = newsCommentService.selectNewsCommentByKey(page-1, size, key);
        return newsComments;
    }

    @GetMapping("/getNewsComment")
    public Page<NewsComment> getNewsComment(Integer page, Integer size){
        Page<NewsComment> newsComments = newsCommentService.selectAllNewsComment(page-1, size);
        return newsComments;
    }
}
