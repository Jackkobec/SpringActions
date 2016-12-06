package com.jss.service;

import com.jss.dao.GeneralDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Jack on 03.12.2016.
 */

/**
 * @Service - (Сервис-слой приложения) Аннотация обьявляющая, что этот класс представляет собой сервис – компонент сервис-слоя.
 * Сервис является подтипом класса @Component. Использование данной аннотации позволит искать бины-сервисы автоматически.
 */
//instead
@Component
//@org.springframework.stereotype.Service//cause name of file and class equals annotation name
public class Service<ENTITY_CLASS, ID_TYPE> implements IService<ENTITY_CLASS, ID_TYPE> {


//    @Autowired
//    private StudentDAO studentDAO;
//
//    public Student getStudentById(int id) {
//
//        return studentDAO.getStudentById(id);
//    }


    public Service() {
    }

    @Autowired
    //@Qualifier("generalDAO")
    private GeneralDAO generalDAO;

    @Override
    public boolean saveToDB(ENTITY_CLASS entity) {

        return generalDAO.create(entity).equals(entity) ? true : false;
    }


    @Override
    public ENTITY_CLASS getById(ID_TYPE id, Class<ENTITY_CLASS> cl) {

        return (ENTITY_CLASS) generalDAO.findById(id, cl);
    }

    @Override
    public List<ENTITY_CLASS> getAllByEntityClass(Class<ENTITY_CLASS> entityClass) {

        return generalDAO.getAllByEntityClass(entityClass);
    }

    @Override
    public List<ENTITY_CLASS> getAllByEntityClassAndParameter(Class<ENTITY_CLASS> entityClass, String parameter,
                                                              Object valueOfParameter) {

        return generalDAO.getAllByEntityClassAndParameter(entityClass, parameter, valueOfParameter);
    }

    @Override
    public boolean removeById(ID_TYPE id, Class<ENTITY_CLASS> entityClass) {

        return generalDAO.removeById(id, entityClass);
    }

    @Override
    public boolean removeAllByEntityClass(Class<ENTITY_CLASS> entityClass) {

        return generalDAO.removeAllByEntityClass(entityClass);
    }

    @Override
    public boolean removeAllByEntityClassAndParameter(Class<ENTITY_CLASS> entityClass, String parameter,
                                                      Object valueOfParameter) {

        return generalDAO.removeAllByEntityClassAndParameter(entityClass, parameter, valueOfParameter);
    }


}