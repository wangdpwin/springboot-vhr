package com.study.dao;

import com.study.model.Resources;
import java.util.List;
import java.util.Map;

public interface ResourcesDao {
    List<Resources> queryAll();

    List<Resources> loadUserResources(Map<String,Object> map);

    List<Resources> queryResourcesListWithSelected(Integer rid);
}
