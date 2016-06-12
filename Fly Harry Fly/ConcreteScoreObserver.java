import greenfoot.*;
public class ConcreteScoreObserver extends ScoreObserver{
    
   public ConcreteScoreObserver(ScoreSubject subject){
      this.subject = subject;
      this.subject.attach(this);
   }

   @Override
   public void update() {
     TheWorld.score = subject.getScore();
   }
}