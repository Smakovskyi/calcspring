package ua.kpi.controller.commands;

import lombok.Setter;
import ua.kpi.model.Calculator;

@Setter
@CommandName(name = "sub")
public class SubCommand implements Command {

  private Calculator calculator;
  @Override
  public String execute(String[] args) {
    Integer first = Integer.valueOf(args[0]);
    Integer second = Integer.valueOf(args[1]);
    int result = calculator.sub(first, second);
    return Integer.toString(result);
  }
}
