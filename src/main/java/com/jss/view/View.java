package com.jss.view;

import com.jss.model.Student;
import com.jss.service.ServiceA;

//@Component//create bean
public class View<ENTITY_CLASS, ID_TYPE> {

    //@Autowired//connect with another bean
    //@Qualifier("view")//if we have a few realisations we create the special identificator for use
    private ServiceA service;

    public View() {
    }

   public void showStudentByID(){

       System.out.println(service.getById(7 , Student.class));
   }


}
