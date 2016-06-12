import greenfoot.*;
public class ChangedState implements State 
{
   Harry copter;
    
    public ChangedState(Harry newCopter)
    {
       copter = newCopter;
    }
    
    @Override
    public void setHarryImage()
    {
        GreenfootImage img= new GreenfootImage("Snake.png");
        copter.setImage("Snake.png");
    }
}


