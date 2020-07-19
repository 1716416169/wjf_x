package com.wjfnews.wjf_x.admin.dao;

import com.wjfnews.wjf_x.admin.entity.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface NewsJpaRepository extends JpaRepository<News,Integer>, JpaSpecificationExecutor<Integer> {
    public Page<News> findByNewsOffOnEquals(Integer newsOffOn, Pageable pageable);
    public Page<News> findByNewsOffOnEqualsAndTitleContainingOrSummaryContainingOrAuthorContaining(Integer newsOffOn,String title,String summary,String author,Pageable pageable);
    public Page<News> findByTitleContainingOrSummaryContainingOrAuthorContaining(String title,String summary,String author,Pageable pageable);
    public Page<News> findByNewsOffOnEqualsAndCateIdContaining(Integer newsOffOn,String cateId,Pageable pageable);
}
