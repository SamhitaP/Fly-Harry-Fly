import java.util.ArrayList;
import java.util.List;

public class ScoreSubject  
{
    private List<ScoreObserver> observers = new ArrayList<ScoreObserver>();
    private int score;
    
    public int getScore() {
      return score;
   }

   public void setScore(int score) {
      this.score = score;
      notifyAllObservers();
   }

   public void attach(ScoreObserver observer){
      observers.add(observer);		
   }

   public void notifyAllObservers(){
      for (ScoreObserver observer : observers) {
         observer.update();
      }
   } 	

}
