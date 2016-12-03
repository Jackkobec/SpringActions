package com.jss.dao;

import com.jss.model.Student;
import com.jss.service.Service;
import lombok.Data;
import org.apache.log4j.Logger;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
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
@Data
@Repository//instead @Component
public class StudentDAO extends GeneralDAO<Student, Integer> implements CommonDAO<Student, Integer>{

    Logger LOGGER = Logger.getLogger(Service.class);
    EntityManagerFactory factory = getEntityMangerFactory();


    @org.springframework.data.jpa.repository.Query("select form Student s where b.group_id = :group_id ")
    @Override
    public boolean removeAllByEntityClassAndParameter(@Param("group_id") int group_id) {


        return false;
    }

    @Override
    public boolean removeAllByEntityClassAndParameter(Class<Student> entityClass, String parameter, Object valueOfParameter) {
        return false;
    }

    @Override
    public boolean addNewEntity(Student entity) {
        return false;
    }

}
