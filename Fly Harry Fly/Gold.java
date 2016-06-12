import greenfoot.*;

public class Gold extends Actor
{
    public void act() 
    {
        setLocation(getX()- TheWorld.SPEED, getY());
        turn(-5);
    }
}
