package com.wjfnews.wjf_x.admin.dao;

import com.wjfnews.wjf_x.admin.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRoleRepository extends JpaSpecificationExecutor<UserRole>, JpaRepository<UserRole, Integer> {
}
