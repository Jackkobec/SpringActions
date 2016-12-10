package com.jss.service;

import com.jss.controller.RegisterException;
import com.jss.model.Student;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Jack on 04.12.2016.
 */
@Component("StudentService")
public class StudentService extends ServiceA implements IStudentService {

    public StudentService() {
    }

    public Student register(Student student) throws RegisterException {

        if (student == null) {
            return null;
        }

        return this.saveToDB(student) ? student : null;
    }

    @Override
    public Student login(int id) {

        if (id == 0) {
            return null;
        }


        Student finded = (Student) this.findById(id, Student.class);
//        if (finded))

            return null;
    }

}
