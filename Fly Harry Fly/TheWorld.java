import greenfoot.*;
import java.awt.Color;

public class TheWorld extends World
{
    static int timers[][];
    static int score;
    //int lastYPos;
    int freq;
    boolean stopped;
     Life life=null;

   
  // GreenfootSound backgroundMusic = new GreenfootSound("audio.mp3");
   
    static int BEST_SCORE = 0;
    static int SPEED = 5;
    static int BAR_WIDTH = 100;
    static int SMALL_FREQ = 8 ;
    
    static ScoreSubject subject; 
    Creator creator;
    
    Speed gSpeed;
    Speed gObj;

    public TheWorld()
    {
        super(1200, 720, 1, false);
    //    backgroundMusic.playLoop();
        timers = new int[1][2];
        stopped = false;
        
         life=new Life();
        
        addObject(new Harry(), getWidth() / 2, getHeight() / 2);
        
        setBackground("images/GameBackground.jpg");
        
        setPaintOrder(new Class[] {
            Harry.class, Text.class, BadBar.class
        });
 
        timers[0][1] = BAR_WIDTH / SPEED;
        
        //Score Observer Implementation
        subject = new ScoreSubject();
        new ConcreteScoreObserver(subject);
        
        gSpeed = new ConcreteSpeedDecorator(new Potion()); 
        
        SPEED = 5;
        score = 0;
        Potion.PIPE_SPEED = 5;
        GreenfootImage bg6 = new GreenfootImage("images/GameBackground.jpg");  
        GreenfootImage img6 = new GreenfootImage((new StringBuilder()).append("Score: ").append(score).toString(), 40, Color.WHITE, new Color(0, 0, 0, 0));
        bg6.drawImage(img6, 0, img6.getHeight() / 2);
        setBackground(bg6); 
     
    }
   
    public Life getLife(){
    return life;
}
    
    public void act()
    {
        
        addObject(life,50,80);
        
        // logic for creating random rectangles
        if(!stopped)
        {
      
           if(timers[0][0] >= timers[0][1])
            {
               timers[0][0] = 0;  
             
                if(freq % SMALL_FREQ == 0)
                {
                     
                   Creator c1 = new GoldFactory(); 
                   addGold(c1);
                   
                }
                
                if(freq % 14 == 0)
                {
                   
                    Creator c2 = new BirdFactory();
                    addBird(c2);
                   
                }
                
                if(freq  % 10 == 0)
                {
                   Creator c4=new GhostFactory();
                   addGhost(c4);            
                }
                
                if(freq  % 29 == 0 )
                {
                    Creator c3 = new PotionFactory();
                    addPotionToWorld(c3);
                }
                freq++;
            }
          
          displayScore();
   
          gSpeed.addBehaviour(); 
    
        } else
        {
            Greenfoot.stop();
        }
    }
    
    public void addPotionToWorld(Creator c){
       addObject(c.getActor(), getWidth(), Greenfoot.getRandomNumber(67));
    }
    
    public void addGold(Creator c){
        addObject(c.getActor(), getWidth(), Greenfoot.getRandomNumber(670));
    }
    
    public void addBird(Creator c){
        Bird s3 = (Bird) c.getActor(); // getting a sword as an actor and casting it into a sword.
       addObject(s3, getWidth(), Greenfoot.getRandomNumber(100));
       s3.setImage("flying_bird.png"); 
         Bird s4 = (Bird) c.getActor(); 
       addObject(s4, getWidth() + Greenfoot.getRandomNumber(100), Greenfoot.getRandomNumber(300));
       s4.setImage("dove.gif");
     
    }
    
    public void addGhost(Creator c){
        Ghost s1 = (Ghost) c.getActor();
        addObject(s1, getWidth(), Greenfoot.getRandomNumber(670));    
    }
    
    private void displayScore()
    {
        //logic for displaying the score on the screen
        GreenfootImage bg = new GreenfootImage("images/GameBackground.jpg");  
        GreenfootImage img = new GreenfootImage((new StringBuilder()).append("Score: ").append(score).toString(), 40, Color.WHITE, new Color(0, 0, 0, 0));
        bg.drawImage(img, 0, img.getHeight() / 2);
        setBackground(bg);  
        bgChange();
        timers[0][0]++;
    }

    private void bgChange()
    {
            if (score > 10 && score < 21)
            {
                    GreenfootImage bg1 = new GreenfootImage("images/back4.jpg");
                    GreenfootImage img1 = new GreenfootImage((new StringBuilder()).append("Score: ").append(score).toString(), 40, Color.WHITE, new Color(0, 0, 0, 0));
                    bg1.drawImage(img1, 0, img1.getHeight() / 2);
                    setBackground(bg1);
            }
            
            if (score > 20 && score < 36)
            {
                    GreenfootImage bg2 = new GreenfootImage("images/back3.jpg");
                    GreenfootImage img2 = new GreenfootImage((new StringBuilder()).append("Score: ").append(score).toString(), 40, Color.WHITE, new Color(0, 0, 0, 0));
                    bg2.drawImage(img2, 0, img2.getHeight() / 2);
                    setBackground(bg2);
            }
            
            if (score > 35 && score < 51)
            {
                    GreenfootImage bg3 = new GreenfootImage("images/back2.jpg");
                    GreenfootImage img3 = new GreenfootImage((new StringBuilder()).append("Score: ").append(score).toString(), 40, Color.WHITE, new Color(0, 0, 0, 0));
                    bg3.drawImage(img3, 0, img3.getHeight() / 2);
                    setBackground(bg3);
            }
            
            if (score > 50)
            {
                    GreenfootImage bg4 = new GreenfootImage("images/back1.png");
                    GreenfootImage img4 = new GreenfootImage((new StringBuilder()).append("Score: ").append(score).toString(), 40, Color.WHITE, new Color(0, 0, 0, 0));
                    bg4.drawImage(img4, 0, img4.getHeight() / 2);
                    setBackground(bg4);
            }
        
    }
        
    public void end()
    {
        
        //logic for game end and saving the high score
        if(score > BEST_SCORE)
        {
            BEST_SCORE = score;
        }
        
        removeObjects(getObjects(null));
        GreenfootImage bg = getBackground();
        GreenfootImage img = new GreenfootImage("You died! :(", 100, Color.WHITE, new Color(0, 0, 0, 0));
        GreenfootImage img2 = new GreenfootImage((new StringBuilder()).append("Best: ").append(BEST_SCORE).toString(), 100, Color.WHITE, new Color(0, 0, 0, 0));
        GreenfootImage img3 = new GreenfootImage((new StringBuilder()).append("Score: ").append(score).toString(), 100, Color.WHITE, new Color(0, 0, 0, 0));
        bg.drawImage(img3, getWidth() / 2 - img3.getWidth() / 2, getHeight() / 2 - img3.getHeight() / 2);
        bg.drawImage(img, getWidth() / 2 - img.getWidth() / 2, getHeight() / 4 - img.getHeight() / 2);
        bg.drawImage(img2, getWidth() / 2 - img2.getWidth() / 2, (getHeight() / 4) * 3 - img2.getHeight() / 2);
        setBackground(bg);
        stopped = true;
        Greenfoot.stop();
        SPEED = 5;
        score = 0;
        Potion.PIPE_SPEED = 5;
        GreenfootImage bg6 = new GreenfootImage("images/GameBackground.jpg");  
        GreenfootImage img6 = new GreenfootImage((new StringBuilder()).append("Score: ").append(score).toString(), 40, Color.WHITE, new Color(0, 0, 0, 0));
        bg6.drawImage(img6, 0, img6.getHeight() / 2);
        setBackground(bg6); 
 
    }
    
}
