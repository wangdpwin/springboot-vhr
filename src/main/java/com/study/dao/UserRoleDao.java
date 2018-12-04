package com.study.dao;

import java.util.List;

public interface UserRoleDao {
    List<Integer> findUserIdByRoleId(Integer roleid);

}
