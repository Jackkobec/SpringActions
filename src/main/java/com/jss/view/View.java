package com.jss.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import com.jss.service.Service;

@Component//create bean
public class View {

    @Autowired//connect with another bean
    @Qualifier("service")//if we have a few realisations we create the special identificator for use
    private Service service;

    public View() {
    }

   public void showStudent(){

       System.out.println(service.getStudentById(2));
   }


}
