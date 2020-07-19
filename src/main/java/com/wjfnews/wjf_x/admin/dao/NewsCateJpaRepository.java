package com.wjfnews.wjf_x.admin.dao;

import com.wjfnews.wjf_x.admin.entity.NewsCate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface NewsCateJpaRepository extends JpaSpecificationExecutor<NewsCate>, JpaRepository<NewsCate, Integer> {
    public Page<NewsCate> findByCateOffOnEquals(Integer cateOffOn, Pageable pageable);
    public Page<NewsCate> findByCateNameContainingOrCateDescContaining(String cateName,String cateDesc, Pageable pageable);
    public Page<NewsCate> findByCateOffOnEqualsAndCateNameContainingOrCateDescContaining(Integer cateOffOn,String cateName,String cateDesc, Pageable pageable);
    public List<NewsCate> findByCateOffOnEquals(Integer cateOffOn);

}

