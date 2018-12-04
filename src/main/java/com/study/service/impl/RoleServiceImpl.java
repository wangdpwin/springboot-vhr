package com.study.service.impl;

import com.study.dao.RoleDao;
import com.study.dao.RoleResourcesDao;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.model.Role;
import com.study.model.RoleResources;
import com.study.service.RoleService;

@Service("roleService")
public class RoleServiceImpl extends BaseService<Role> implements RoleService{

    @Resource
    private RoleDao roleDao;
    @Resource
    private RoleResourcesDao roleResourcesDao;

    @Override
    public List<Role> queryRoleListWithSelected(Integer uid) {
        return roleDao.queryRoleListWithSelected(uid);
    }

    @Override
    public PageInfo<Role> selectByPage(Role role, int start, int length) {
       return null;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
    public void delRole(Integer roleid) {

    }
}
