package com.wjfnews.wjf_x.admin.dao;

import com.wjfnews.wjf_x.admin.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository extends JpaSpecificationExecutor<User>, JpaRepository<User, Integer> {
    public User findByUser(String user);
}
