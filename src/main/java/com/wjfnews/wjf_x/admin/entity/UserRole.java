package com.wjfnews.wjf_x.admin.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import springfox.documentation.annotations.ApiIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    //@Column(name = "user_role_id")
    private int id;

    @ApiModelProperty(name = "角色", dataType = "string")
    //@Column(name = "user_role_role")
    private String role;

    @ManyToOne(targetEntity = User.class, optional = false)
    @JoinColumn(name = "user_userRole_id", referencedColumnName = "id")
    //name:外键字段是框架帮忙创建，不需要自己创建，只需要取个名字 referencedColumnName:依赖主表的id
    @ApiModelProperty(hidden = true)
    //@JsonIgnoreProperties(value = {"roles"}) //防止嵌套死循环 当json字段里有user.roles时不读取
    private User user;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {

        setUser(null);  //重点 防止无限嵌套
        return "UserRole{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", user=" + user +
                '}';
    }
}
