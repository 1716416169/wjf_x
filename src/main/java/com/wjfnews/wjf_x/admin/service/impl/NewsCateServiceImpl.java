package com.wjfnews.wjf_x.admin.service.impl;

import com.wjfnews.wjf_x.admin.dao.NewsCateJpaRepository;
import com.wjfnews.wjf_x.admin.dao.NewsCateMapper;
import com.wjfnews.wjf_x.admin.entity.NewsCate;
import com.wjfnews.wjf_x.admin.service.NewsCateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsCateServiceImpl implements NewsCateService {


    @Autowired
    NewsCateJpaRepository newsCateJpaRepository;

    @Autowired
    NewsCateMapper newsCateMapper;



    @Override
    public Page<NewsCate> selectAllNewsCate(Integer page,Integer size) {//查询所有存在的数据
        Sort cateSort = Sort.by(Sort.Direction.DESC, "cateSort");
        Pageable of = PageRequest.of(page, size, cateSort);
        Page<NewsCate> all = newsCateJpaRepository.findAll(of);
        System.out.println("查询出的数据："+all.getContent());
        return  all;
    }

    @Override
    public Page<NewsCate> selectNewsCateByKey(Integer page, Integer size, String key) {//根据key查询所有存在的数据
        Sort cateSort = Sort.by(Sort.Direction.DESC, "cateSort");
        PageRequest of = PageRequest.of(page, size, cateSort);
        Page<NewsCate> all = newsCateJpaRepository.findByCateNameContainingOrCateDescContaining(key,key,of);
        System.out.println("查询出的cate:"+all.getContent());
        return  all;
    }

    @Override
    public NewsCate updateNewsCate(NewsCate newsCate) {
        int i = newsCateMapper.updateNewsCate(newsCate);
        return newsCate;
    }

    @Override
    public NewsCate insertNewsCate(NewsCate newCate) {
        int i = newsCateMapper.insertNewsCate(newCate);
        System.out.println("插入的数据id："+newCate.getId());
        return newCate;
    }

    @Override
    public List<Integer> deleteNewsCate(List<Integer> ids) {
        int i = newsCateMapper.deleteNewsCates(ids);
        return ids;
    }

    @Override
    public List<NewsCate> getAllNewsCate() {//动态添加下拉框
        List<NewsCate> i = newsCateJpaRepository.findAll();
        return i;
    }

    @Override
    public Page<NewsCate> selectNewsCate(Integer page, Integer size) {
        Sort cateSort = Sort.by(Sort.Direction.DESC, "cateSort");
        PageRequest of = PageRequest.of(page, size, cateSort);
        Page<NewsCate> byCateOffOnEquals = newsCateJpaRepository.findByCateOffOnEquals(1, of);
        return byCateOffOnEquals;
    }

    @Override
    public List<NewsCate> getNewsCate() {
        List<NewsCate> byCateOffOnEquals = newsCateJpaRepository.findByCateOffOnEquals(1);
        return byCateOffOnEquals;
    }

    @Override
    public long selectCount() {
        long count = newsCateJpaRepository.count();
        return count;
    }


}
