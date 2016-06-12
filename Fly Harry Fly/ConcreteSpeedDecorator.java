import greenfoot.*;
/**
 * Write a description of class HighSpeedDecorator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ConcreteSpeedDecorator extends SpeedDecorator 
{
    public ConcreteSpeedDecorator(Speed decoratedSpeed)
    {
        super(decoratedSpeed);
    }
    
    @Override
    public void addBehaviour()
    {
        decoratedSpeed.addBehaviour();
        setSpeedBehaviour(decoratedSpeed);
    }
    
    private void setSpeedBehaviour(Speed decoratedSpeed)
    {
        switch(TheWorld.score)
        {
            case 5:
                TheWorld.SPEED = 6;
                break;
                
            case 10:
                TheWorld.SPEED = 7;
                break;
                
            case 20:
                TheWorld.SPEED = 8;
                break;
                
            case 50:
                TheWorld.SPEED = 10;
                break;
        }
    }
}
