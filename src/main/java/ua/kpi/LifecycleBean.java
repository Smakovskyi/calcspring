package ua.kpi;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import lombok.Setter;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import ua.kpi.model.Calculator;

@Setter
public class LifecycleBean implements InitializingBean, DisposableBean {

  Calculator calculator;

  @Override
  public void destroy() throws Exception {
    System.out.println("destroying");
  }

  @PostConstruct
  public  void init(){
    System.out.println("init");
  }

  @PreDestroy
  public void destroying(){
    System.out.println("destroying with @PreDestroy");
  }


  @Override
  public void afterPropertiesSet() throws Exception {
    System.out.println("properties are set " + calculator);
  }
}
