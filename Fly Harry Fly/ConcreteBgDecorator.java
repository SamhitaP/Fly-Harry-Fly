import greenfoot.*;
import java.awt.Color;

/**
 * Write a description of class ConcreteBgDecorator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ConcreteBgDecorator extends BgDecorator 
{
    public ConcreteBgDecorator(Background decoratedBg)
    {
        super(decoratedBg);
    }
    
    public void addBgBehaviour()
    {
        decoratedBg.addBgBehaviour();
        setBgBehaviour(decoratedBg);
    }
    
    private void setBgBehaviour(Background decoratedBg)
    {
        GreenfootImage bg1 = new GreenfootImage("images/download.jpg");
      GreenfootImage img1 = new GreenfootImage((new StringBuilder()).append("Score: ").append(TheWorld.score).toString(), 40, Color.WHITE, new Color(0, 0, 0, 0));
      bg1.drawImage(img1, 0, img1.getHeight() / 2);
      setImage(bg1);
    }
}
