import greenfoot.*;

public class GhostFactory extends Creator
{
   public Actor getActor(){
    return new Ghost();
    }
}

