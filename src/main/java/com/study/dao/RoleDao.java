package com.study.dao;

import com.study.model.Role;
import java.util.List;

public interface RoleDao {
    List<Role> queryRoleListWithSelected(Integer uid);
}
