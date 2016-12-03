package com.jss.console_tests;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.jss.view.View;

/**
 * Created by Jack on 03.12.2016.
 */
public class ConsoleTest {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("/ios/app_context.xml");
        View view = context.getBean(View.class);

        view.showStudent();
    }
}
