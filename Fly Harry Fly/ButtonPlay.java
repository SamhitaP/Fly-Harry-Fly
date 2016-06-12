import greenfoot.*;

/**
 * Write a description of class ButtonPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ButtonPlay extends Button implements ButtonInvoker
{
    /**
     * Act - do whatever the ButtonPlay wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private ButtonCommand newCommand;
    /**
     * Act - do whatever the PlayButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        click();
    } 
    
    
    public void click()
    {
       newCommand.executeCommand();

		
    }
    
    public void setCommand(ButtonCommand newCmd)
    {
    
    this.newCommand = newCmd;
    }
    
   
}
