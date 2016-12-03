package com.jss.service;

import com.jss.model.Student;

import java.util.List;

/**
 * Created by Jack on 04.12.2016.
 */
public class StudentService implements IStudentService {
    @Override
    public boolean saveToDB(Student entity) {
        return false;
    }

    @Override
    public Student getById(Integer id, Class<Student> cl) {
        return null;
    }

    @Override
    public List<Student> getAllByEntityClass(Class<Student> entityClass) {
        return null;
    }

    @Override
    public List<Student> getAllByEntityClassAndParameter(Class<Student> entityClass, String parameter, Object valueOfParameter) {
        return null;
    }

    @Override
    public boolean removeById(Integer id, Class<Student> entityClass) {
        return false;
    }

    @Override
    public boolean removeAllByEntityClass(Class<Student> entityClass) {
        return false;
    }

    @Override
    public boolean removeAllByEntityClassAndParameter(Class<Student> entityClass, String parameter, Object valueOfParameter) {
        return false;
    }
}
