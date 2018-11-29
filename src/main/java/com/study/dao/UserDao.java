package com.study.dao;

import com.study.model.mongoDB.UserEntity;
import java.util.List;

public interface UserDao {

    public void save(UserEntity user);

    public UserEntity get(String userName);

    public void update(UserEntity user);

    public void delete(Long id);

    public List<UserEntity> query(String keyword);

}
