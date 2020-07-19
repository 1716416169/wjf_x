package com.wjfnews.wjf_x.admin.service;

import com.wjfnews.wjf_x.admin.entity.NewsComment;
import org.springframework.data.domain.Page;

import java.util.List;

public interface NewsCommentService {
    public Page<NewsComment> selectAllNewsComment(Integer page, Integer size);
    public Page<NewsComment> selectNewsCommentByKey(Integer page,Integer size,String key);
    public NewsComment updateNewsComment(NewsComment newsComment);
    public NewsComment insertNewsComment(NewsComment newsComment);
    public List<Integer> deleteNewsComment(List<Integer> ids);
    public Page<NewsComment> selectNewsComment(Integer page,Integer size);
    public Page<NewsComment> selectNewsCommentByIdFromNews(Integer page,Integer size,Integer ipFromNews);
    public long selectCount();
}
