package com.wjfnews.wjf_x.admin.entity;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Entity
public class NewsCate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;               //id
    private String cateName;            //名称
    private String cateDesc;            //描述
    private Integer cateSort;        //排序
    private Integer cateOffOn;      //0为删除 1为加入
    private String cateStatus;          //状态
    private String createOn;               //创建时间
    private String updateOn;               //更新时间
    private Integer createBy;         //创建者
    private Integer updateBy;         //更新者

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getCateDesc() {
        return cateDesc;
    }

    public void setCateDesc(String cateDesc) {
        this.cateDesc = cateDesc;
    }

    public Integer getCateSort() {
        return cateSort;
    }

    public void setCateSort(Integer cateSort) {
        this.cateSort = cateSort;
    }

    public Integer getCateOffOn() {
        return cateOffOn;
    }

    public void setCateOffOn(Integer cateOffOn) {
        this.cateOffOn = cateOffOn;
    }

    public String getCateStatus() {
        return cateStatus;
    }

    public void setCateStatus(String cateStatus) {
        this.cateStatus = cateStatus;
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

    @Override
    public String toString() {
        return "NewsCate{" +
                "id=" + id +
                ", cateName='" + cateName + '\'' +
                ", cateDesc='" + cateDesc + '\'' +
                ", cateSort=" + cateSort +
                ", cateOffOn=" + cateOffOn +
                ", cateStatus='" + cateStatus + '\'' +
                ", createOn=" + createOn +
                ", updateOn=" + updateOn +
                ", createBy=" + createBy +
                ", updateBy=" + updateBy +
                '}';
    }
}
