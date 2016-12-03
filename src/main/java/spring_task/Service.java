package spring_task;

import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Jack on 03.12.2016.
 */

@Component
public class Service {


    @Autowired
    private StudentlDAO studentlDAO;

    public Student getStudentById(int id) {

        return studentlDAO.getStudentById(id);
    }

}