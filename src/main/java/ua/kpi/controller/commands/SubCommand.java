package ua.kpi.controller.commands;

import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.kpi.model.Calculable;
import ua.kpi.model.Calculator;

@Setter
@Component("sub")
public class SubCommand implements Command {

  @Autowired
  private Calculable calculator;
  @Override
  public String execute(String[] args) {
    Integer first = Integer.valueOf(args[0]);
    Integer second = Integer.valueOf(args[1]);
    int result = calculator.sub(first, second);
    return Integer.toString(result);
  }
}
