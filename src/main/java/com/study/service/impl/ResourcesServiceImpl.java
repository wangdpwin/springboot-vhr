package com.study.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.study.dao.ResourcesDao;
import com.study.model.Resources;
import com.study.model.User;
import com.study.service.ResourcesService;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by yangqj on 2017/4/25.
 */
@Service("resourcesService")
public class ResourcesServiceImpl extends BaseService<Resources> implements ResourcesService {
   @Resource
    private ResourcesDao resourcesDao;

    @Override
    public PageInfo<Resources> selectByPage(Resources resources, int start, int length) {
       return null;
    }

    @Override
    public List<Resources> queryAll(){
        return resourcesDao.queryAll();
    }

    @Override
//    @Cacheable(cacheNames="resources",key="#map['userid'].toString()+#map['type']")
    public List<Resources> loadUserResources(Map<String, Object> map) {
        return resourcesDao.loadUserResources(map);
    }

    @Override
    public List<Resources> queryResourcesListWithSelected(Integer rid) {
        return resourcesDao.queryResourcesListWithSelected(rid);
    }

}
