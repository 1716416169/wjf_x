package com.wjfnews.wjf_x.admin.dao;

import com.wjfnews.wjf_x.admin.entity.News;
import com.wjfnews.wjf_x.admin.entity.NewsComment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Update;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface NewsMapper {
    public int deleteNews(List<Integer> ids);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("insert into news(updateOn,author,newsOffOn,newsSort,newsStatus,content,createBy,createOn,picPath,remark,title,cateId,summary,updateBy) values(#{updateOn},#{author},#{newsOffOn},#{newsSort},#{newsStatus},#{content},#{createBy},#{createOn},#{picPath},#{remark},#{title},#{cateId},#{summary},#{updateBy})")
    public int insertNews(News news);

    @Update("update news set updateOn=#{updateOn},author=#{author},newsOffOn=#{newsOffOn},newsSort=#{newsSort},title=#{title},cateId=#{cateId},newsStatus=#{newsStatus},content=#{content},createBy=#{createBy},createOn=#{createOn},picPath=#{picPath},remark=#{remark},summary=#{summary},updateBy=#{updateBy} where id=#{id}")
    public int updateNews(News news);
}
