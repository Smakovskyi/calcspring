package ua.kpi.controller.commands;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.kpi.model.Calculator;

@Setter
@CommandName(name="add")
@Component
public class AddCommand implements Command {

  @Autowired
  private Calculator calculator;

  @Override
  public String execute(String[] args) {
    Integer first = Integer.valueOf(args[0]);
    Integer second = Integer.valueOf(args[1]);
    int result = calculator.add(first, second);
    return Integer.toString(result);
  }
}
