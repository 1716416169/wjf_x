package com.wjfnews.wjf_x.admin.configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.Md4PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests() /*认证请求*/
                .antMatchers("/admin/login").permitAll()    /*匹配模式，允许所有人访问，有顺序分别，从上到下*/
                .antMatchers("/admin/**").hasRole("user");  /*可以查看源码的注释（需要下载）*/
        http.formLogin().loginPage("/admin/login") /*开启登录页面并指定登录页面*/
                .failureUrl("/admin/login")  /*登录失败返回的页面*/
                .usernameParameter("user")    /*需要指定账号密码的参数名，否则登录会失败，默认码源码里有*/
                .passwordParameter("password")
                .successForwardUrl("/admin/index")
        /* .loginProcessingUrl("")*/; /*登陆成功后跳转的页面*/
        http.csrf().disable();  /*关闭跨域攻击防御*/
        http.headers().frameOptions().disable();/*不写会让前端报错*/
        http.logout().logoutUrl("/logout").logoutSuccessUrl("/admin/login");  /*登出使用的url和成功登出后跳转的界面*/

        //http.rememberMe(); /*开启cookie（记住用户登录的状态）*/
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new Md4PasswordEncoder())   /*设定编码、解码方式*/
                .withUser("root").password(new Md4PasswordEncoder().encode("123456")).roles("user"); /*可以查看源码的注释（需要下载）*/

    }
}
