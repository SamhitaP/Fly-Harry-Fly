import greenfoot.*;

public class MissileFactory extends Creator
{
   public Actor getActor(){
    return new Missile();
    }
}
