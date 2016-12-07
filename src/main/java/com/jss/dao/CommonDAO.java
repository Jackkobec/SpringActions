package com.jss.dao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.persistence.Query;
import java.util.List;

import static com.jss.factory.LazySingletonEntityManagerfactory.getEntityMangerFactory;

/**
 * Created by Jack on 18.11.2016.
 */
public interface CommonDAO<ENTITY_CLASS, ID_TYPE> {


    Logger LOGGER = Logger.getLogger(CommonDAO.class);

    EntityManagerFactory factory =  getEntityMangerFactory();//new ClassPathXmlApplicationContext("/ioc/app_context.xml").getBean(EntityManagerFactory.class);

    @Transactional
    default ENTITY_CLASS create(ENTITY_CLASS entity) {

        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        try {

            transaction.begin();
            manager.persist(entity);
            transaction.commit();
            LOGGER.info("entity was saved");

        } catch (Exception e) {
            LOGGER.error("entity was not saved", e);
            transaction.rollback();
        } finally {
            manager.close();
        }

        return entity;
    }

    @Transactional
    default ENTITY_CLASS findById(ID_TYPE id, Class<ENTITY_CLASS> entityClass) {

        EntityManager manager = factory.createEntityManager();
        //EntityTransaction transaction = manager.getTransaction();

        try {

            ENTITY_CLASS entity = manager.find(entityClass, id);
            LOGGER.info((null == entity) ? "Cant find " + entityClass.getName() + " with id = " + id
                    : "Finded " + entityClass.getName() + " with id = " + id);


            return entity;

        } finally {
            manager.close();
        }
    }

    @Transactional
    default List<ENTITY_CLASS> getAllByEntityClass(Class<ENTITY_CLASS> entityClass) {

        EntityManager manager = factory.createEntityManager();

        TypedQuery<ENTITY_CLASS> query = manager.createQuery("FROM " + entityClass.getName(), entityClass);//worked
        //TypedQuery<ENTITY_CLASS> query = manager.createQuery("FROM " + manager.unwrap(entityClass), entityClass);//not worked

        try {

            query.setMaxResults(22);
            query.setFirstResult(0);
            LOGGER.info("Entities found by class: " + entityClass.getName());

            return query.getResultList();

        } finally {
            manager.close();
        }
    }

    @Transactional
    default List<ENTITY_CLASS> getAllByEntityClassAndParameter(Class<ENTITY_CLASS> entityClass, String parameter,
                                                               Object valueOfParameter) {

        EntityManager manager = factory.createEntityManager();

        TypedQuery<ENTITY_CLASS> query = manager.createQuery("FROM " + entityClass.getName() + " e " +
                "WHERE " + "e." + parameter + "=:" + parameter, entityClass);//worked

        query.setParameter(parameter, valueOfParameter);//ask what is first arg
        query.setMaxResults(22);
        query.setFirstResult(0);
        LOGGER.info("Entities found by class: " + entityClass.getName() + " and parameter: " + parameter +
                " = " + valueOfParameter.toString());

        return query.getResultList();
    }


    @Transactional
    default boolean removeById(ID_TYPE id, Class<ENTITY_CLASS> entityClass) {

        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        ENTITY_CLASS entity = manager.find(entityClass, id);

        try {

            transaction.begin();
            manager.remove(entity);
            transaction.commit();
            LOGGER.info("entity was removed");
            return true;

        } catch (Exception e) {
            LOGGER.error("entity was not removed", e);
            transaction.rollback();
        } finally {
            manager.close();
        }

        return false;
    }

    @Transactional
    default boolean removeAllByEntityClass(Class<ENTITY_CLASS> entityClass) {

        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        try {

            transaction.begin();

            Query removeAllQuery = manager.createQuery("DELETE FROM " + entityClass.getName());//worked
            removeAllQuery.executeUpdate();

            transaction.commit();
            LOGGER.info("entity was removed");
            return true;

        } catch (Exception e) {
            LOGGER.error("entity was not removed", e);
            transaction.rollback();
        } finally {
            manager.close();
        }

        return false;
    }

    //
//    default boolean removeAllByEntityClassAndParameter(Class<ENTITY_CLASS> entityClass, String parameter,
//                                                       Object valueOfParameter) {
//
//        EntityManager manager = factory.createEntityManager();
//
//        TypedQuery removeAllQuery = manager.createQuery("DELETE FROM " + entityClass.getName() + " e " +
//                "WHERE " + "e." + parameter + "=:" + parameter, entityClass);
//
//        removeAllQuery.setParameter(parameter, valueOfParameter);
//        removeAllQuery.executeUpdate();
//
//        LOGGER.info("Removed by class: " + entityClass.getName() + " and parameter: " + parameter +
//                " = " + valueOfParameter.toString());
//
//        return true;
//    }

    boolean removeAllByEntityClassAndParameter(Class<ENTITY_CLASS> entityClass, String parameter,
                                               Object valueOfParameter);

    boolean addNewEntity(ENTITY_CLASS entity);

    boolean removeAllByEntityClassAndParameter(int group_id);

    //boolean updateEntityInfo(ENTITY_CLASS entity);

}
