package com.wjfnews.wjf_x.admin.service;

import com.wjfnews.wjf_x.admin.entity.NewsCate;
import org.springframework.data.domain.Page;

import java.util.List;

public interface NewsCateService {
    public Page<NewsCate> selectAllNewsCate(Integer page,Integer size);
    public Page<NewsCate> selectNewsCateByKey(Integer page,Integer size,String key);
    public NewsCate updateNewsCate(NewsCate newsCate);
    public NewsCate insertNewsCate(NewsCate newCate);
    public List<Integer> deleteNewsCate(List<Integer> ids);
    public List<NewsCate> getAllNewsCate();
    public Page<NewsCate> selectNewsCate(Integer page,Integer size);
    public List<NewsCate> getNewsCate();
    public long selectCount();
}
