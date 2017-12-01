package hello;

public class Rover {

    private Position position;
    private Orientation  orientation;
    private Terrain terrain;
    
   public Rover(Terrain terrain, Orientation orientation){
       this.terrain = terrain;
       this.orientation = orientation;
       this.position = new Position();
       this.position.setX(0);
       this.position.setY(0);
   }

   public boolean move(){
       if( calcNextStepX() < 0 
           || calcNextStepY() < 0
           || calcNextStepX() > terrain.getX() 
           || calcNextStepY() > terrain.getY()){
        return false;
       }else{
        this.position.setX(calcNextStepX()); 
        this.position.setY(calcNextStepY());
       }
       return true;
   }
   private int calcNextStepX(){
        return this.position.getX() + orientation.getXStep();
   }
   private int calcNextStepY(){
       return this.position.getY() + orientation.getYStep();
   }
   public void turnLeft(){
    if (this.orientation == Orientation.N) this.orientation = Orientation.W;
    else if (this.orientation == Orientation.W) this.orientation = Orientation.S;
    else if (this.orientation == Orientation.S) this.orientation = Orientation.E;
    else if (this.orientation == Orientation.E) this.orientation = Orientation.N;
}
public void turnRigth(){
    if (this.orientation == Orientation.N) this.orientation = Orientation.E;
    else if (this.orientation == Orientation.E) this.orientation = Orientation.S;
    else if (this.orientation == Orientation.S) this.orientation = Orientation.W;
    else if (this.orientation == Orientation.W) this.orientation = Orientation.N;
}
   public String getLocationInfo(){
        return "(" + position.getX() + "," + position.getY() + "," + orientation.toString() + ")";
   }
   
}