package com.wjfnews.wjf_x.user.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.wjfnews.wjf_x.admin.entity.News;
import com.wjfnews.wjf_x.admin.entity.NewsCate;
import com.wjfnews.wjf_x.admin.entity.NewsComment;
import com.wjfnews.wjf_x.admin.service.impl.NewsCateServiceImpl;
import com.wjfnews.wjf_x.admin.service.impl.NewsCommentServiceImpl;
import com.wjfnews.wjf_x.admin.service.impl.NewsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@Controller
@ApiIgnore
@RequestMapping("/user")
public class UserIndexController {

    @Autowired
    NewsServiceImpl newsService;

    @Autowired
    NewsCateServiceImpl newsCateService;

    @Autowired
    NewsCommentServiceImpl newsCommentService;

    @RequestMapping("index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        Page<News> news = newsService.selectNews(1, 3);
        modelAndView.addObject("news",news);
        modelAndView.setViewName("user/index");
        return modelAndView;
    }

    @RequestMapping("news")
    public ModelAndView news(Integer page, Integer size,@RequestParam(value = "cateName",required = false) String cateName){
        System.out.println(page+"       "+size);
        System.out.println("查找的类型："+cateName);
        ModelAndView modelAndView = new ModelAndView();
        if(page==null&&size==null){
            page=1;
            size=8;
        }
        Page<News> news;
        if(cateName!=null){
            news = newsService.selectNewsByCate(page - 1, size, cateName);
            modelAndView.addObject("cateName",cateName);
        }else{
            news = newsService.selectNews(page-1,size);
            modelAndView.addObject("cateName",-1);
        }
        List<NewsCate> newsCate = newsCateService.getNewsCate();
        System.out.println("查出来的数据："+news.getContent());
        modelAndView.setViewName("user/news");
        modelAndView.addObject("news",news);
        modelAndView.addObject("newsCate",newsCate);
        return modelAndView;
    }

    @RequestMapping("singleNews/{id}")
    public ModelAndView singleNews(Integer page, Integer size,@PathVariable("id") Integer id,@RequestParam(value = "idOfNews",required = false)Integer idOfNews,@RequestParam(value = "author",required = false)String author,@RequestParam(value = "content",required = false)String content){
        System.out.println("选中的文章："+id);
        if(page==null&&size==null){
            page=1;
            size=4;
        }
        if(idOfNews!=null||author!=null||content!=null){
            NewsComment newsComment = new NewsComment();
            newsComment.setAuthor(author);
            newsComment.setIdOfNews(idOfNews);
            newsComment.setContent(content);
            newsComment.setCommentOnOff(1);
            NewsComment newsComment1 = newsCommentService.insertNewsComment(newsComment);
            System.out.println("插入的评论："+newsComment);
        }
        Page<NewsComment> newsComments = newsCommentService.selectNewsCommentByIdFromNews(page - 1, size, id);
        News news = newsService.selectNewsById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/single_news");
        modelAndView.addObject("news",news);
        modelAndView.addObject("newsComments",newsComments);
        System.out.println("文章："+news);
        return modelAndView;
    }
}
