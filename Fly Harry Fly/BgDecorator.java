import greenfoot.*;

/**
 * Write a description of class BgDecorator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BgDecorator extends Actor implements Background
{
    /**
     * Act - do whatever the BgDecorator wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
     protected Background decoratedBg;
    
    public BgDecorator(Background decoratedBg)
    {
        this.decoratedBg = decoratedBg;
    }
    
    public void addBgBehaviour()
    {
        decoratedBg.addBgBehaviour();
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
