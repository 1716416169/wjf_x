package com.wjfnews.wjf_x.admin.dao;

import com.sun.istack.Interned;
import com.wjfnews.wjf_x.admin.entity.NewsComment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface NewsCommentMapper {
    public int deleteNewsComments(List<Integer> ids);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("insert into newscomment(updateOn,author,commentOnOff,commentSort,commentStatus,content,createBy,createOn,fromIp,idOfNews,remark,updateBy) values(#{updateOn},#{author},#{commentOnOff},#{commentSort},#{commentStatus},#{content},#{createBy},#{createOn},#{fromIp},#{idOfNews},#{remark},#{updateBy})")
    public int insertNewsComment(NewsComment newsComment);

    @Update("update newscomment set updateOn=#{updateOn},author=#{author},commentOnOff=#{commentOnOff},commentSort=#{commentSort},commentStatus=#{commentStatus},content=#{content},createBy=#{createBy},createOn=#{createOn},fromIp=#{fromIp},idOfNews=#{idOfNews},remark=#{remark},updateBy=#{updateBy} where id=#{id}")
    public int updateNewsComment(NewsComment newsComment);

}
