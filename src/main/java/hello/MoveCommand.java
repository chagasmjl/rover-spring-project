package hello;

public class MoveCommand implements ICommand{
    
    @Override
    public boolean execute(Rover rover) {
        return rover.move();
    }
    
}