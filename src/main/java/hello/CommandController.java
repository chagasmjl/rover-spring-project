package hello;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CommandController {


    @RequestMapping("/rest/mars")
    public String receiveCommand(@RequestParam(value="commands") String commands) {
        Rover unamedRover = new Rover(new Terrain(5,5), Orientation.N);
        List<ICommand> commandList = CommandParser.interpret(commands);
        
        if (commandList.isEmpty()) throw new BadRequestException();

        for(ICommand c : commandList ){
            if (!c.execute(unamedRover)) throw new BadRequestException();
        }
        return unamedRover.getLocationInfo();
    }
}
