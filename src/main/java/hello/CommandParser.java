package hello;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandParser{
    public static List<ICommand> interpret(String receivedCommands){
        List<ICommand> commands = new ArrayList<>();
        for(String c : Arrays.asList(receivedCommands.split("")) ){            
            if ("M".equals(c)) commands.add(new MoveCommand());
            else if ("L".equals(c))  commands.add(new TurnLeft());
            else if ("R".equals(c))  commands.add(new TurnRigth());               
        }
        return commands;
    }
}