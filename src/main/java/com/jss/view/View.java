package com.jss.view;

import com.jss.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import com.jss.service.Service;

@Component//create bean
public class View<ENTITY_CLASS, ID_TYPE> {

    @Autowired//connect with another bean
    @Qualifier("service")//if we have a few realisations we create the special identificator for use
    private Service service;

    public View() {
    }

   public void showStudentByID(){

       System.out.println(service.getById(7 , Student.class));
   }


}
