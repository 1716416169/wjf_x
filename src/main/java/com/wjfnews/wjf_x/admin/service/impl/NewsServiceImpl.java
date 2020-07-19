package com.wjfnews.wjf_x.admin.service.impl;

import com.wjfnews.wjf_x.admin.dao.NewsJpaRepository;
import com.wjfnews.wjf_x.admin.dao.NewsMapper;
import com.wjfnews.wjf_x.admin.entity.News;
import com.wjfnews.wjf_x.admin.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    NewsJpaRepository newsJpaRepository;

    @Autowired
    NewsMapper newsMapper;

    @Override
    public Page<News> selectAllNews(Integer page, Integer size) {
        Sort newsSort = Sort.by(Sort.Direction.DESC, "newsSort");
        Pageable of = PageRequest.of(page, size, newsSort);
        Page<News> all = newsJpaRepository.findAll(of);
        return all;
    }

    @Override
    public Page<News> selectNewsByKey(Integer page, Integer size, String key) {
        Sort newsSort = Sort.by(Sort.Direction.DESC, "newsSort");
        Pageable of = PageRequest.of(page, size, newsSort);
        Page<News> byTitleContainingOrSummaryContainingOrAuthorContaining = newsJpaRepository.findByTitleContainingOrSummaryContainingOrAuthorContaining(key, key, key, of);
        return byTitleContainingOrSummaryContainingOrAuthorContaining;
    }

    @Override
    public News updateNews(News news) {
        int i = newsMapper.updateNews(news);
        return news;
    }

    @Override
    public News insertNews(News news) {
        int i = newsMapper.insertNews(news);
        return news;
    }

    @Override
    public List<Integer> deleteNews(List<Integer> ids) {
        int i = newsMapper.deleteNews(ids);
        return ids;
    }

    @Override
    public Page<News> selectNews(Integer page, Integer size) {
        Sort newsSort = Sort.by(Sort.Direction.DESC, "newsSort");
        Pageable of = PageRequest.of(page, size, newsSort);
        Page<News> byNewsOffOnEquals = newsJpaRepository.findByNewsOffOnEquals(1, of);
        return byNewsOffOnEquals;
    }

    @Override
    public News selectNewsById(Integer id) {
        Optional<News> byId = newsJpaRepository.findById(id);
        return byId.get();
    }

    @Override
    public Page<News> selectNewsByCate(Integer page, Integer size, String cate) {
        Sort newsSort = Sort.by(Sort.Direction.DESC, "newsSort");
        Pageable of = PageRequest.of(page, size, newsSort);
        Page<News> byNewsOffOnEqualsAndCateIdContaining = newsJpaRepository.findByNewsOffOnEqualsAndCateIdContaining(1, cate, of);
        return byNewsOffOnEqualsAndCateIdContaining;
    }

    @Override
    public long selectConut() {
        long count = newsJpaRepository.count();
        return count;
    }
}
