package hello;
public enum Orientation{
    N (0,1), 
    S (0,-1),
    W (-1,0),
    E (1,0);
    
    private int xStep;
    private int yStep;

    private Orientation(int xStep, int yStep){
        this.xStep = xStep;
        this.yStep = yStep;
    }
    public int getXStep(){
        return this.xStep;
    }
    public int getYStep(){
        return this.yStep;
    }
    
}