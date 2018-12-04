package com.study.dao;

import com.study.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserDao extends JpaRepository<User,Long> {

    User findById(Long id);

    User findByUsername(String username);

//    @Query("select user from User where username = :username")
//    Page findUserPage(Pageable pageable, @Param("username") String username);

}
