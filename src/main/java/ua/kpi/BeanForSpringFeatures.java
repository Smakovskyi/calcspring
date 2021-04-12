package ua.kpi;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.kpi.model.Calculator;

public class BeanForSpringFeatures implements ApplicationContextAware {

  private ApplicationContext applicationContext;

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.applicationContext = applicationContext;
  }

  protected Calculator createCalculator(){
    throw new RuntimeException();
    //return applicationContext.getBean(Calculator.class);
  }

  public int executeAdd(int a, int b){
    Calculator calculator = createCalculator();
    return calculator.add(a,b);
  }

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext(
        "context.xml");
    BeanForSpringFeatures sample = context.getBean(BeanForSpringFeatures.class);
    System.out.println(sample.executeAdd(2,3));
    System.out.println(sample.executeAdd(4,5));
    ((ClassPathXmlApplicationContext) context).close();

  }


}
