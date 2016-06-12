import greenfoot.*;
/**
 * Write a description of class SpeedDecorator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class SpeedDecorator implements Speed
{
    protected Speed decoratedSpeed;
    
    public SpeedDecorator(Speed decoratedSpeed)
    {
        this.decoratedSpeed = decoratedSpeed;
    }
    
    public void addBehaviour()
    {
        decoratedSpeed.addBehaviour();
    }
}
