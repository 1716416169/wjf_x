package com.wjfnews.wjf_x.admin.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.crypto.Data;
import java.math.BigInteger;
import java.util.Date;

@Entity
public class NewsComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer idOfNews; //所属新闻id
    private String content;  //评论内容
    private String author;   //评论作者
    private String fromIp;   //来源ip
    private String commentStatus; //状态
    private String remark; //备注
    private Integer commentSort; //排序
    private Integer commentOnOff; //0为删除 1为存在
    private Integer createBy;  //创建者
    private Integer updateBy; //更新者
    private String createOn; //创建时间
    private String updateOn; //更新时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdOfNews() {
        return idOfNews;
    }

    public void setIdOfNews(Integer idOfNews) {
        this.idOfNews = idOfNews;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFromIp() {
        return fromIp;
    }

    public void setFromIp(String fromIp) {
        this.fromIp = fromIp;
    }

    public String getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(String commentStatus) {
        this.commentStatus = commentStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getCommentSort() {
        return commentSort;
    }

    public void setCommentSort(Integer commentSort) {
        this.commentSort = commentSort;
    }

    public Integer getCommentOnOff() {
        return commentOnOff;
    }

    public void setCommentOnOff(Integer commentOnOff) {
        this.commentOnOff = commentOnOff;
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
        return "NewsComment{" +
                "id=" + id +
                ", idOfNews=" + idOfNews +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", fromIp='" + fromIp + '\'' +
                ", commentStatus='" + commentStatus + '\'' +
                ", remark='" + remark + '\'' +
                ", commentSort=" + commentSort +
                ", commentOnOff=" + commentOnOff +
                ", createBy=" + createBy +
                ", updateBy=" + updateBy +
                ", createOn=" + createOn +
                ", updateOn=" + updateOn +
                '}';
    }
}
