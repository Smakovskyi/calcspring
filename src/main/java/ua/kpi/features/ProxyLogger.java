package ua.kpi.features;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyLogger implements InvocationHandler {

  Object source;

  private ProxyLogger(Object source) {
    this.source = source;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println("Method " + method.getName() + " is called");
    Object result = method.invoke(source, args);
    return result;
  }

  public static <T> T create(T source){

    return (T)Proxy.newProxyInstance(source.getClass().getClassLoader(), source.getClass().getInterfaces(),
        new ProxyLogger(source));
  }
}
