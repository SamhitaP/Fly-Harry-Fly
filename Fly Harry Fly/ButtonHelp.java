import greenfoot.*;

/**
 * Write a description of class HelpButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ButtonHelp extends Button implements ButtonInvoker
{
    /**
     * Act - do whatever the HelpButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private ButtonCommand newCommand;
    private Help help;
    
    public ButtonHelp()
    {
    help = new Help();
    }
    
    public Help getHelp()
    {
    return help;
    }
    public void act() 
    {
        // Add your action code here.
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
