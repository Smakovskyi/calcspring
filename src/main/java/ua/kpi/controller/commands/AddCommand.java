package ua.kpi.controller.commands;

import lombok.Setter;
import ua.kpi.model.Calculator;

@Setter
@CommandName(name="add")
public class AddCommand implements Command {

  private Calculator calculator;

  @Override
  public String execute(String[] args) {
    Integer first = Integer.valueOf(args[0]);
    Integer second = Integer.valueOf(args[1]);
    int result = calculator.add(first, second);
    return Integer.toString(result);
  }
}
