package com.wjfnews.wjf_x.admin.service;

import com.wjfnews.wjf_x.admin.entity.News;
import org.springframework.data.domain.Page;

import java.util.List;

public interface NewsService {
    public Page<News> selectAllNews(Integer page, Integer size);
    public Page<News> selectNewsByKey(Integer page,Integer size,String key);
    public News updateNews(News news);
    public News insertNews(News news);
    public List<Integer> deleteNews(List<Integer> ids);
    public Page<News> selectNews(Integer page, Integer size);
    public News selectNewsById(Integer id);
    public Page<News> selectNewsByCate(Integer page,Integer size,String cate);
    public long selectConut();
}
