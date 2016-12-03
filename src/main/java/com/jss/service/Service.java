package com.jss.service;

import com.jss.dao.GeneralDAO;
import com.jss.dao.StudentDAO;
import com.jss.model.Student;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.GeneratedValue;
import java.util.List;

/**
 * Created by Jack on 03.12.2016.
 */

/**
 * @Service - (Сервис-слой приложения) Аннотация обьявляющая, что этот класс представляет собой сервис – компонент сервис-слоя.
 * Сервис является подтипом класса @Component. Использование данной аннотации позволит искать бины-сервисы автоматически.
 */
//instead @Component
@org.springframework.stereotype.Service//cause name of file and class equals annotation name
public class Service<ENTITY_CLASS, ID_TYPE> {


//    @Autowired
//    private StudentDAO studentDAO;
//
//    public Student getStudentById(int id) {
//
//        return studentDAO.getStudentById(id);
//    }

    @Autowired
    private GeneralDAO generalDAO;

    public boolean saveToDB(ENTITY_CLASS entity){

        return generalDAO.create(entity).equals(entity) ? true : false;
    }


    public ENTITY_CLASS getById(ID_TYPE id, Class<ENTITY_CLASS> cl) {

        return (ENTITY_CLASS) generalDAO.findById(id, cl);
    }

    public List<ENTITY_CLASS> getAllByEntityClass(Class<ENTITY_CLASS> entityClass) {

        return generalDAO.getAllByEntityClass(entityClass);
    }

    public List<ENTITY_CLASS> getAllByEntityClassAndParameter(Class<ENTITY_CLASS> entityClass, String parameter,
                                                       Object valueOfParameter) {

        return generalDAO.getAllByEntityClassAndParameter(entityClass, parameter, valueOfParameter);
    }





}