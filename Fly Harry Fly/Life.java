import greenfoot.*;
import java.awt.Color;
import java.awt.Font;
/**
 * Write a description of class Life here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Life extends Actor
{
    int Health_max=4;
    int health=Health_max;
    int healthbarwidth=80;
    int healthbarheight=15;
    int pixelsperhealth=(int)healthbarwidth/health;
    public Life()
    {
        setLife();
    }
     public void act()
     {
        setLife();
      }
       
    
    public void setLife(){
        
         setImage(new GreenfootImage(healthbarwidth+4,healthbarheight+4));
         GreenfootImage myImage=getImage();
         myImage.setColor(Color.BLACK);
         myImage.drawRect(1,1,healthbarwidth+2,healthbarheight+2);
         myImage.setColor(Color.RED);
         myImage.fillRect(1,1,health*pixelsperhealth,healthbarheight);
       
        
    }
    
    public void loseLife()
    {
       health--; 
       
       
    }
    
}
