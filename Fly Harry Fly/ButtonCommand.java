import greenfoot.*;

/**
 * Write a description of class Command here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface ButtonCommand
{
    /**
     * Act - do whatever the Command wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void executeCommand();
    public void setReceiver(Receiver newRec);
    
    
}
