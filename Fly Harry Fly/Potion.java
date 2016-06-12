import greenfoot.*;
import java.awt.Color;

/**
 * Write a description of class Missile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Potion extends Actor implements Speed
{
   static int PIPE_SPEED = 5;
 public Potion(){
        setImage( new GreenfootImage("potion.png"));
        GreenfootImage i=getImage();
        i.scale(i.getWidth()-450,i.getHeight()-450);
        setImage(i);
        
    }
    public void act() 
    {
           //System.out.println("pipe showed");
       //Slide the pipe to the left by 4 every act step 
      setLocation(getX() - PIPE_SPEED , getY());
    }
    
    public String toString()
    {
        return "Pipe at X: " + getX() + " Y: "+getY();
    }
    
    @Override    
    public void addBehaviour()
    {
        if (TheWorld.score > 15)
        {
            PIPE_SPEED = 7;
        }
    }
}
