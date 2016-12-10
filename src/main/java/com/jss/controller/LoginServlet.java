//package com.jss.controller;
//
//import com.jss.model.Student;
//import com.jss.service.StudentService;
//import org.apache.log4j.Logger;
//import org.springframework.context.ApplicationContext;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//@WebServlet(urlPatterns = {"/login"})
//public class LoginServlet extends HttpServlet {
//
//    private static final Logger LOG = Logger.getLogger(RegisterServlet.class);
//
//    private ApplicationContext applicationContext;
//    private StudentService studentService;
//
//    @Override
//    public void init() throws ServletException {
//        applicationContext =
//                (ApplicationContext) getServletContext().getAttribute("app_context");
//        studentService = applicationContext.getBean(StudentService.class);
//    }
//
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        //String name = req.getParameter("name");
//        String studentId = req.getParameter("name");
//
//        try {
//            int id = Integer.parseInt(studentId);
//            Student found = studentService.login(id);
//
//            HttpSession session = req.getSession(true);
//            session.setAttribute("inSystem", true);
//            session.setAttribute("currentUserName",found.getName());
//
//            resp.sendRedirect("index.jsp");
//        } catch (NoStudentFoundException e) {
//            req.setAttribute("errorTitle", "Login Error");
//            req.setAttribute("errorMessage", "invalid name");
//            req.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(req, resp);
//        }
//        // redirect
//    }
//}
