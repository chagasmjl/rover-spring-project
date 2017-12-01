package hello;

public class TurnLeft implements ICommand{
    @Override
    public boolean execute(Rover rover) {
        rover.turnLeft();
        return true;
    }
}