package com.jss.service;

import com.jss.controller.RegisterException;
import com.jss.model.Student;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Jack on 04.12.2016.
 */
@Component
public class StudentService extends ServiceA {

    public Student register(Student student) throws RegisterException {

        if(student == null){
            return null;
        }

         return this.saveToDB(student) ? student : null;
    }

}
