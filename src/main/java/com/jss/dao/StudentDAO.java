package com.jss.dao;

import com.jss.model.Student;
import com.jss.service.Service;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

import static com.jss.factory.LazySingletonEntityManagerfactory.getEntityMangerFactory;

/**
 * Created by Jack on 03.12.2016.
 */

/**
 * @Repository - (Доменный слой) Аннотация показывает, что класс функционирует как репозиторий и требует наличия прозрачной трансляции исключений.
 * Преимуществом трансляции исключений является то, что слой сервиса будет иметь дело с общей иерархией исключений от Spring (DataAccessException)
 * вне зависимости от используемых технологий доступа к данным в слое данных.
 */
@Repository
public class StudentDAO extends GeneralDAO implements CommonDAO<Student, Integer>{

    Logger LOGGER = Logger.getLogger(Service.class);
    EntityManagerFactory factory = getEntityMangerFactory();

    public StudentDAO() {
    }

    public Student getStudentById(int id) {


        EntityManager manager = factory.createEntityManager();
        //EntityTransaction transaction = manager.getTransaction();

        try {

            Student student = manager.find(Student.class, id);
            LOGGER.info("Finded entity with id = " + id);
            return student;

        } finally {
            manager.close();
        }
    }


    @Override
    public List<Student> findAllByParam(Object param) {
        return null;
    }

    @Override
    public boolean removeById(Integer id) {
        return false;
    }

    @Override
    public boolean addNewEntity(Student entity) {
        return false;
    }

    @Override
    public boolean updateEntityInfo(Student entity) {
        return false;
    }
}
