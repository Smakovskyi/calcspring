package ua.kpi.view;

import org.springframework.stereotype.Component;

@Component
public class View implements Viewable {
  public void print(String text){
    System.out.println(text);
  }
}
