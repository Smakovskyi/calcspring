package ua.kpi;

import java.lang.reflect.Method;
import org.springframework.beans.factory.support.MethodReplacer;
import ua.kpi.model.Calculable;
import ua.kpi.model.Calculator;

public class MethodReplacement implements MethodReplacer {

  private Calculable calculator;

  public MethodReplacement(Calculable calculator) {
    this.calculator = calculator;
  }

  @Override
  public Object reimplement(Object o, Method method, Object[] objects) throws Throwable {
    return calculator.sub((int)objects[0], (int)objects[1]);
  }
}
