import greenfoot.*;

/**
 * Write a description of class Bird here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bird extends Actor
{
    
     int PIPE_SPEED = 4;
   
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
}
