package com.wjfnews.wjf_x.admin.service.impl;

import com.wjfnews.wjf_x.admin.dao.NewsCommentJpaRepository;
import com.wjfnews.wjf_x.admin.dao.NewsCommentMapper;
import com.wjfnews.wjf_x.admin.entity.NewsComment;
import com.wjfnews.wjf_x.admin.service.NewsCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsCommentServiceImpl implements NewsCommentService {

    @Autowired
    NewsCommentJpaRepository newsCommentJpaRepository;

    @Autowired
    NewsCommentMapper newsCommentMapper;

    @Override
    public Page<NewsComment> selectAllNewsComment(Integer page, Integer size) {
        Sort commentSort = Sort.by(Sort.Direction.DESC, "id");
        Pageable of = PageRequest.of(page, size, commentSort);
        Page<NewsComment> all = newsCommentJpaRepository.findAll(of);
        return all;
    }

    @Override
    public Page<NewsComment> selectNewsCommentByKey(Integer page, Integer size, String key) {
        Sort commentSort = Sort.by(Sort.Direction.DESC, "id");
        Pageable of = PageRequest.of(page, size, commentSort);
        Page<NewsComment> byContentContainingOrAuthorContaining = newsCommentJpaRepository.findByContentContainingOrAuthorContaining(key, key, of);
        return byContentContainingOrAuthorContaining;
    }

    @Override
    public NewsComment updateNewsComment(NewsComment newsComment) {
        int i = newsCommentMapper.updateNewsComment(newsComment);
        return newsComment;
    }

    @Override
    public NewsComment insertNewsComment(NewsComment newsComment) {
        int i = newsCommentMapper.insertNewsComment(newsComment);
        return newsComment;
    }

    @Override
    public List<Integer> deleteNewsComment(List<Integer> ids) {
        int i = newsCommentMapper.deleteNewsComments(ids);
        return ids;
    }

    @Override
    public Page<NewsComment> selectNewsComment(Integer page, Integer size) {
        Sort commentSort = Sort.by(Sort.Direction.DESC, "id");
        Pageable of = PageRequest.of(page, size, commentSort);
        Page<NewsComment> byCommentOnOffEquals = newsCommentJpaRepository.findByCommentOnOffEquals(1, of);
        return byCommentOnOffEquals;
    }

    @Override
    public Page<NewsComment> selectNewsCommentByIdFromNews(Integer page, Integer size, Integer idFromNews) {
        Sort commentSort = Sort.by(Sort.Direction.DESC, "id");
        Pageable of = PageRequest.of(page, size, commentSort);
        Page<NewsComment> byCommentOnOffEqualsAndIdOfNews = newsCommentJpaRepository.findByCommentOnOffEqualsAndIdOfNews(1, idFromNews, of);
        return byCommentOnOffEqualsAndIdOfNews;
    }

    @Override
    public long selectCount() {
        long count = newsCommentJpaRepository.count();
        return count;
    }

}
