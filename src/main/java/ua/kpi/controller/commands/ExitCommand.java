package ua.kpi.controller.commands;

import org.springframework.stereotype.Component;

@Component("exit")
public class ExitCommand implements Command{


  @Override
  public String execute(String[] args) {
    System.exit(0);
    return null;
  }
}
