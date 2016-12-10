package com.jss.controller;

import com.jss.model.Student;
import com.jss.service.StudentService;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// register

@WebServlet(urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(RegisterServlet.class);

    private ApplicationContext applicationContext;
    private StudentService studentService;

    @Override
    public void init() throws ServletException {
        applicationContext =
                (ApplicationContext) getServletContext().getAttribute("ioc/app_context.xml");
        studentService = applicationContext.getBean(StudentService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  some action
        // just redirect to register.jsp
        req.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // waiting data from the form
        String name = req.getParameter("name");
        String groupId = req.getParameter("groupId");

        if(name == null || groupId == null){
            // redirect
            resp.sendRedirect("http/error.jsp");
            //current localhost:8080/testio/register
            // Absolute path  = /http/error.jsp localhost:8080/http/error
            // Relative path = http/error.jsp localhost:8080/testio/http/error.jsp
        } else {
            Integer group_id = Integer.parseInt(groupId);

            Student student = new Student("Serhii", 22);
            try {
                Student created = studentService.register(student);
                req.setAttribute("student", created);
                req.getRequestDispatcher("/WEB-INF/pages/student-info.jsp").forward(req,resp);
            } catch (RegisterException e) {
                LOG.error(e);
                // forward to a error page
            }
        }



    }
}
