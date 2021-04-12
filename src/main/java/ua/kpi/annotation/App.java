package ua.kpi.annotation;

import java.io.IOException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.kpi.controller.Controller;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        ApplicationContext context = new AnnotationConfigApplicationContext("ua.kpi");
        Controller controller = context.getBean(Controller.class);
        controller.handleUserInput();
    }
}
