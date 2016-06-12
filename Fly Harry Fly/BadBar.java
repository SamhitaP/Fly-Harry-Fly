import greenfoot.*;
import java.awt.Color;

public class BadBar extends Actor
{
    int height;   
    
    public BadBar(int height)
    {
        this.height = height;
    }

    public void addedToWorld(World w)
    {
        GreenfootImage img = new GreenfootImage(TheWorld.BAR_WIDTH, height);
        img.setColor(Color.BLUE);
        img.fill();
        setImage(img);
    }
    
    public void act()
    {
        setLocation(getX() - TheWorld.SPEED, getY());
        if(getX() < -TheWorld.BAR_WIDTH / 2)
        {
            getWorld().removeObject(this);
        }
    }
}
