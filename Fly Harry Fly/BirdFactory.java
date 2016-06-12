import greenfoot.*;

public class BirdFactory extends Creator
{
   public Actor getActor(){
    return new Bird();
    }
}
