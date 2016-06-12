    import greenfoot.*;
    import java.awt.Color;

/**
 * Write a description of class Bird here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ghost extends Actor
{
public Ghost(){
        setImage( new GreenfootImage("dementor.png"));
        GreenfootImage i=getImage();
        //i.scale(i.getWidth()-440,i.getHeight()-440);
        setImage(i);
        
    }
    
    
     //int PIPE_SPEED = 4;
   
    public void act() 
    {
     
      //System.out.println("pipe showed");
      //Slide the pipe to the left by 4 every act step 
      //setLocation(getX() - PIPE_SPEED , getY());
      setLocation(getX() - TheWorld.SPEED, getY());
        if(getX() < -TheWorld.BAR_WIDTH / 2)
        {
            getWorld().removeObject(this);
        }
    }
    
    
}
