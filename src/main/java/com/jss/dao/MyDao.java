package com.jss.dao;

import org.springframework.stereotype.Component;

/**
 * Created by Jack on 07.12.2016.
 */
@Component("myDao")
public class MyDao extends GeneralDAO {


    @Override
    public boolean removeAllByEntityClassAndParameter(Class entityClass, String parameter, Object valueOfParameter) {
        return false;
    }

    @Override
    public boolean addNewEntity(Object entity) {
        return false;
    }

    @Override
    public boolean removeAllByEntityClassAndParameter(int group_id) {
        return false;
    }
}
