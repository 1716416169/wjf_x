package com.wjfnews.wjf_x.admin.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    //@Column(name = "user_id")
    private int id;

    @ApiModelProperty(name = "账号", dataType = "String")
    //@Column(name = "user_user")
    private String user;

    @ApiModelProperty(name = "密码", dataType = "String")
    //@Column(name = "user_password")
    private String password;

    //@OneToMany(targetEntity = UserRole.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    //@JoinColumn(name = "user_userRole_id",referencedColumnName = "id")
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //mappedby：放弃维护权，以对方属性的配置来操作,可以避免生成中间表  cascade:级联，不可写在副表 fetch：是否为懒加载
    @ApiModelProperty(hidden = true)
    @JsonIgnoreProperties(value = {"user"})  //防止嵌套死循环 当json字段里有roles.user时不读取
    private List<UserRole> roles;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public List<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(List<UserRole> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }
}
