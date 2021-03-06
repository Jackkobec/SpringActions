package com.jss.console_tests;

import com.jss.controller.RegisterException;
import com.jss.model.Student;
import com.jss.service.IService;
import com.jss.service.ServiceA;
import com.jss.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Jack on 03.12.2016.
 */
public class ConsoleTest {

    public static void main(String[] args) throws RegisterException {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("ioc/app_context.xml");


//        CommonDAO commonDAO = context.getBean(StudentDAO.class);

        IService iservice = (IService) context.getBean("ServiceA");
        StudentService studentService = context.getBean(StudentService.class);

        //commonDAO.create(new Student("Kolyan", 7));

        //view.showStudentByID();


        //System.out.println(commonDAO.getAllByEntityClassAndParameter(Student.class, "group_id", 7));
        //System.out.println(service.saveToDB(new Student("Serhii", 22)));
        //System.out.println(service.removeById(11, Student.class));
        //System.out.println(service.getById(11, Student.class));
//        for (int i = 0; i < 12; i++) {
//
//            System.out.println(iservice.saveToDB(new Student("Serhii", 22)));
//        }
        System.out.println(iservice.saveToDB(new Student("Serhii", 22)));
        //System.out.println(iservice.removeAllByEntityClass(Student.class));
        System.out.println(iservice.getAllByEntityClass(Student.class));


        System.out.println(studentService.register(new Student("Vasa", 25)));

    }
}
