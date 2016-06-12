import greenfoot.*;

/**
 * Write a description of class ButtonBack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ButtonBack extends Button 
{
    private Actor actor;
    /**
     * Constructor de la clase Back.
     */
    public ButtonBack(Actor a)
    {
        actor = a;
    }
    
    /**
     * Act - do whatever the Back wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        this.click();
    }    
    
    /**
     * Cierra la ventana para ver nuevamente el menu.
     */
    public void click()
    {
        if(Greenfoot.mouseClicked(this)){
            
            getWorld().removeObject(actor);
            getWorld().removeObject(this);
        }
    }   
}
