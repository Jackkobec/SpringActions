package com.jss.service;

import com.jss.controller.RegisterException;
import com.jss.model.Student;

/**
 * Created by Jack on 04.12.2016.
 */
public interface IStudentService{

     Student register(Student student) throws RegisterException;

     Student login(int id);

}
