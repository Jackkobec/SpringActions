package com.jss.service;

import com.jss.dao.StudentDAO;
import com.jss.model.Student;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Jack on 03.12.2016.
 */

@org.springframework.stereotype.Service//cause name of file and class equals annotation name
public class Service {


    @Autowired
    private StudentDAO studentDAO;

    public Student getStudentById(int id) {

        return studentDAO.getStudentById(id);
    }

}