package com.jss.service;

import java.util.List;

/**
 * Created by Jack on 04.12.2016.
 */
public interface IService<ENTITY_CLASS, ID_TYPE> {


    boolean saveToDB(ENTITY_CLASS entity);

    ENTITY_CLASS getById(ID_TYPE id, Class<ENTITY_CLASS> cl);

    List<ENTITY_CLASS> getAllByEntityClass(Class<ENTITY_CLASS> entityClass);

    List<ENTITY_CLASS> getAllByEntityClassAndParameter(Class<ENTITY_CLASS> entityClass, String parameter,
                                                       Object valueOfParameter);

    boolean removeById(ID_TYPE id, Class<ENTITY_CLASS> entityClass);

    boolean removeAllByEntityClass(Class<ENTITY_CLASS> entityClass);

    boolean removeAllByEntityClassAndParameter(Class<ENTITY_CLASS> entityClass, String parameter,
                                               Object valueOfParameter);
}
