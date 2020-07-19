package com.wjfnews.wjf_x.admin.dao;

import com.wjfnews.wjf_x.admin.entity.NewsCate;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface NewsCateMapper {

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("insert into NewsCate(cateDesc,cateName,cateOffOn,cateSort,cateStatus,createBy,createOn,updateBy,updateOn) values(#{cateDesc},#{cateName},#{cateOffOn},#{cateSort},#{cateStatus},#{createBy},#{createOn},#{updateBy},#{updateOn})")
    public int insertNewsCate(NewsCate newsCate);

    @Update("update NewsCate set cateDesc = #{cateDesc},cateName=#{cateName},cateOffOn=#{cateOffOn},cateSort=#{cateSort},cateStatus=#{cateStatus},createBy=#{createBy},createOn=#{createOn},updateBy=#{updateBy},updateOn=#{updateOn} where id=#{id}")
    public int updateNewsCate(NewsCate newsCate);

    public int deleteNewsCates(List<Integer> list);
}
