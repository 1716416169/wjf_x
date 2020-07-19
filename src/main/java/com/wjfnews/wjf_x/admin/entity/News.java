package com.wjfnews.wjf_x.admin.entity;

import io.swagger.annotations.ApiModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigInteger;
import java.util.Date;

@Entity
@ApiModel(value="News对象",description="News对象")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;       //id

    private String cateId;  //所属类别
    private String title;        //标题
    private String author;       //作者
    private String summary;     //摘要
    private String content;     //内容
    private String newsStatus;  //状态
    private String picPath;      //图片路径
    private String remark;          //备注
    private Integer newsSort;    //排序
    private Integer newsOffOn; //0为删除，1为存在
    private Integer createBy;    //创建者
    private Integer updateBy;    //更新者
    private String createOn;          //创建时间
    private String updateOn;          //修改时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCateId() {
        return cateId;
    }

    public void setCateId(String cateId) {
        this.cateId = cateId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNewsStatus() {
        return newsStatus;
    }

    public void setNewsStatus(String newsStatus) {
        this.newsStatus = newsStatus;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getNewsSort() {
        return newsSort;
    }

    public void setNewsSort(Integer newsSort) {
        this.newsSort = newsSort;
    }

    public Integer getNewsOffOn() {
        return newsOffOn;
    }

    public void setNewsOffOn(Integer newsOffOn) {
        this.newsOffOn = newsOffOn;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    public String getCreateOn() {
        return createOn;
    }

    public void setCreateOn(String createOn) {
        this.createOn = createOn;
    }

    public String getUpdateOn() {
        return updateOn;
    }

    public void setUpdateOn(String updateOn) {
        this.updateOn = updateOn;
    }

    @Override
    public String toString() {
        return "NewsJpaRepository{" +
                "id=" + id +
                ", cateId=" + cateId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", summary='" + summary + '\'' +
                ", content='" + content + '\'' +
                ", newsStatus='" + newsStatus + '\'' +
                ", picPath='" + picPath + '\'' +
                ", remark='" + remark + '\'' +
                ", newsSort=" + newsSort +
                ", newsOffOn=" + newsOffOn +
                ", createBy=" + createBy +
                ", updateBy=" + updateBy +
                ", createOn=" + createOn +
                ", updateOn=" + updateOn +
                '}';
    }
}
