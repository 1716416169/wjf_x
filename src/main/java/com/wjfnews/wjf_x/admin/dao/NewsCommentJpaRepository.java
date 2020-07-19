package com.wjfnews.wjf_x.admin.dao;

import com.wjfnews.wjf_x.admin.entity.NewsCate;
import com.wjfnews.wjf_x.admin.entity.NewsComment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.math.BigInteger;

public interface NewsCommentJpaRepository extends JpaRepository<NewsComment, Integer> , JpaSpecificationExecutor<NewsComment> {
    public Page<NewsComment> findByCommentOnOffEquals(Integer commentOnOff, Pageable pageable);
    public Page<NewsComment> findByContentContainingOrAuthorContaining(String content,String author, Pageable pageable);
    public Page<NewsComment> findByCommentOnOffEqualsAndContentContainingOrAuthorContaining(Integer commentOffOn,String content,String author, Pageable pageable);
    public Page<NewsComment> findByCommentOnOffEqualsAndIdOfNews(Integer commentOffOn,Integer idOfNews,Pageable pageable);
}
