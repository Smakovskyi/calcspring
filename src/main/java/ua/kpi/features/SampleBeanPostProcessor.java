package ua.kpi.features;

import java.util.Properties;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import ua.kpi.controller.Controller;

@Component
public class SampleBeanPostProcessor implements BeanPostProcessor {
  public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
    return bean;
  }

  @Nullable
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    if(bean.getClass() == Controller.class){
      return bean;
    }
    Object wrappedBean = ProxyLogger.create(bean);
    return wrappedBean;
  }
}
