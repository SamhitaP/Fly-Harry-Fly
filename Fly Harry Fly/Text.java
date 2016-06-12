import greenfoot.*;
import java.awt.Color;

public class Text extends Actor
{


    public Text()  
    {  
        this("");  
    }  
    
    public Text(String text)
    {
        setText(text);
    }
    
    public void setText(String text)  
    {  
        setImage(new GreenfootImage(text, 24, Color.black, new Color(0, 0, 0, 0)));  
    } 

//     public void addedToWorld(World w)
//     {
//         setImage(new GreenfootImage(text, TheWorld.BIG_HEIGHT / 2, Color.RED, new Color(0, 0, 0, 0)));
//     }

    public void act()
    {
        setLocation(getX() - TheWorld.SPEED, getY());
        if(getX() < -getImage().getWidth() / 2)
        {
            getWorld().removeObject(this);
        }
    }
}
