package spring_task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class View {

    @Autowired
    @Qualifier("service")
    private Service service;

    public View() {
    }

   public void showStudent(){

       System.out.println(service.getStudentById(2));
   }


}
