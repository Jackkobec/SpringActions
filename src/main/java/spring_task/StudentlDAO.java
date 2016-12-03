package spring_task;

import model.Student;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import static factory.LazySingletonEntityManagerfactory.getEntityMangerFactory;

/**
 * Created by Jack on 03.12.2016.
 */

@Component
public class StudentlDAO {

    Logger LOGGER = Logger.getLogger(Service.class);
    EntityManagerFactory factory = getEntityMangerFactory();

    public StudentlDAO() {
    }

    public Student getStudentById(int id) {


        EntityManager manager = factory.createEntityManager();
        //EntityTransaction transaction = manager.getTransaction();

        try {

            Student student = manager.find(Student.class, id);
            LOGGER.info("Finded entity with id = " + id);
            return student;

        } finally {
            manager.close();
        }
    }

}
