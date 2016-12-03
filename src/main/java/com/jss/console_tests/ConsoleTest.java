package com.jss.console_tests;

import com.jss.dao.CommonDAO;
import com.jss.dao.StudentDAO;
import com.jss.model.Student;
import com.jss.service.Service;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.jss.view.View;


import java.util.ArrayList;

/**
 * Created by Jack on 03.12.2016.
 */
public class ConsoleTest {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("/ios/app_context.xml");
        View view = context.getBean(View.class);

        CommonDAO commonDAO = context.getBean(StudentDAO.class);

        Service service = context.getBean(Service.class);

        //commonDAO.create(new Student("Kolyan", 7));

        //view.showStudentByID();


        //System.out.println(commonDAO.getAllByEntityClassAndParameter(Student.class, "group_id", 7));
        System.out.println(service.saveToDB(new Student("Serhii", 22)));


    }
}
