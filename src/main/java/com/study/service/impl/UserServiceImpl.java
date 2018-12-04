package com.study.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.dao.UserDao;
import com.study.dao.UserRoleDao;
import com.study.model.User;
import com.study.model.UserRole;
import com.study.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yangqj on 2017/4/21.
 */
@Service("userService")
public class UserServiceImpl extends BaseService<User> implements UserService{
    @Resource
    private UserRoleDao userRoleDao;

    @Resource
    private UserDao userDao;

    @Override
    public PageInfo<User> selectByPage(User user, int start, int length) {
        return null;
    }

    @Override
    public User selectByUsername(String username) {
        User user = userDao.findByUsername(username);
        return user;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
    public void delUser(Integer userid) {
    }
}
