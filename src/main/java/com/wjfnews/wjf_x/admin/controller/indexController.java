package com.wjfnews.wjf_x.admin.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.wjfnews.wjf_x.admin.service.impl.NewsCateServiceImpl;
import com.wjfnews.wjf_x.admin.service.impl.NewsCommentServiceImpl;
import com.wjfnews.wjf_x.admin.service.impl.NewsServiceImpl;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;
import sun.misc.Request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/admin")
@ApiIgnore
public class indexController {

    @Autowired
    NewsCommentServiceImpl newsCommentService;

    @Autowired
    NewsServiceImpl newsService;

    @Autowired
    NewsCateServiceImpl newsCateService;

    @RequestMapping("login")
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/login");
        return modelAndView;
    }

    @RequestMapping("loginOut")
    public ModelAndView loginOut(HttpServletRequest request, HttpServletResponse response){
        request.getSession().setAttribute("user",null);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/login");
        return modelAndView;
    }

    @RequestMapping("loginOn")
    public ModelAndView loginOn(HttpServletRequest request, HttpServletResponse response,String user,String password){
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(user+"   "+password);
        if (user.equals("root") && password.equals("123456")) {
            request.getSession().setAttribute("user",1);
            modelAndView.setViewName("admin/index");
        }else{
            modelAndView.setViewName("admin/error");
        }

        return modelAndView;
    }


    @RequestMapping("index")//主页
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/index");
        return modelAndView;
    }

    @RequestMapping("welcome")
    public ModelAndView welcome(){
        ModelAndView modelAndView = new ModelAndView();
        long l = newsCateService.selectCount();
        long l1 = newsCommentService.selectCount();
        long l2 = newsService.selectConut();
        modelAndView.addObject("newsCount",l2);
        modelAndView.addObject("newsCateCount",l);
        modelAndView.addObject("newsCommentCount",l1);
        modelAndView.setViewName("admin/welcome");
        return modelAndView;
    }

    @RequestMapping("NewsCate")
    public ModelAndView newsCate(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/news_cate");
        return modelAndView;
    }

    @RequestMapping("News")
    public ModelAndView news(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/news");
        return modelAndView;
    }

    @RequestMapping("NewsComment")
    public ModelAndView newsComment(String id){
        ModelAndView modelAndView = new ModelAndView();
        if(id!=null){
            modelAndView.addObject("id",id);
            System.out.println(id);
        }else{
            modelAndView.addObject("id",-1);
        }
        modelAndView.setViewName("admin/news_comment");
        return modelAndView;
    }

    @RequestMapping("NewsCateForm")
    public ModelAndView newsCateForm(String id){
        ModelAndView modelAndView = new ModelAndView();
        if(id!=null){
            modelAndView.setViewName("admin/news_cate_form");
            modelAndView.addObject("id",id);
            System.out.println(id);
        }else{
            modelAndView.setViewName("admin/news_cate_form");
            modelAndView.addObject("id",-1);
        }
        return modelAndView;
    }

    @RequestMapping("NewsCommentForm")
    public ModelAndView newsCommentForm(String id){
        ModelAndView modelAndView = new ModelAndView();
        if(id!=null){
            modelAndView.setViewName("admin/news_comment_form");
            modelAndView.addObject("id",id);
        }else{
            modelAndView.setViewName("admin/news_comment_form");
            modelAndView.addObject("id",-1);
        }
        return modelAndView;
    }

    @RequestMapping("NewsForm")
    public ModelAndView newsForm(String id){
        ModelAndView modelAndView = new ModelAndView();
        if(id!=null){
            modelAndView.setViewName("admin/news_form");
            modelAndView.addObject("id",id);
            System.out.println(id);
        }else{
            modelAndView.setViewName("admin/news_form");
            modelAndView.addObject("id",-1);
        }
        return modelAndView;
    }



}
