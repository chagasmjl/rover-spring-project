package hello;

public class TurnRigth implements ICommand{
    @Override
    public boolean execute(Rover rover) {
        rover.turnRigth();
        return true;
    }
}