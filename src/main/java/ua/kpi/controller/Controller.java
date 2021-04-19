package ua.kpi.controller;


import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.kpi.controller.commands.Command;
import ua.kpi.controller.commands.CommandFactory;
import ua.kpi.controller.commands.CommandName;
import ua.kpi.controller.commands.DefaultCommand;
import ua.kpi.view.Viewable;


@Setter
@AllArgsConstructor( access = AccessLevel.PRIVATE)
@Builder
@Component
public class Controller {

  private Viewable view;

  private InputStream in = System.in;
  private BufferedReader reader = new BufferedReader(
      new InputStreamReader(in));

  private CommandFactory commandFactory = CommandFactory.getInstance();

  @Inject
  private Map<String, Command> commands = new HashMap<>();

  @Autowired
  public Controller(Viewable view/*, List<Command> commands*/) {
    this.view = view;
   /* for(Command command: commands){
      String name = command.getClass().getAnnotation(CommandName.class).name();
      this.commands.put(name, command);
    }*/

  }

  // add 2 3
  // exit
  public void handleUserInput() throws IOException {

    while (true) {
      String line = reader.readLine();
      if("exit".equalsIgnoreCase(line.trim())){
        return;
      }
      String[] args = line.split("\\s");
      String commandName = args[0];
      Command command = commands.getOrDefault(commandName,
          DefaultCommand.getInstance());
      String result = command.execute(
          Arrays.copyOfRange(args,1, args.length ));
      view.print(result);
    }

  }
}
