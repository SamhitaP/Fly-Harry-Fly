import greenfoot.*;
public class InitialState implements State 
{
   Harry harry;
    
    public InitialState(Harry newHarry)
    {
        harry = newHarry;
    }
    
    @Override
    public void setHarryImage()
    {
        GreenfootImage img= new GreenfootImage("Harry.png");
        harry.setImage("Harry.png");
    } 
}
