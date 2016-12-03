package com.jss.console_tests;

import com.jss.dao.CommonDAO;
import com.jss.dao.StudentDAO;
import com.jss.model.Student;
import com.jss.service.IService;
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

        IService iservice = context.getBean(Service.class);

        //commonDAO.create(new Student("Kolyan", 7));

        //view.showStudentByID();


        //System.out.println(commonDAO.getAllByEntityClassAndParameter(Student.class, "group_id", 7));
        //System.out.println(service.saveToDB(new Student("Serhii", 22)));
        //System.out.println(service.removeById(11, Student.class));
        //System.out.println(service.getById(11, Student.class));
//        for (int i = 0; i < 12; i++) {
//
//            System.out.println(service.saveToDB(new Student("Serhii", 22)));
//        }
        System.out.println(iservice.removeAllByEntityClassAndParameter(Student.class, "group_id", 22));


    }
}
