import greenfoot.*;

public class Harry extends Actor
{
   /*BirdState angryBirdState;
    BirdState flappyBirdState;
    BirdState birdState;*/
    State changedState;
    State initialState;
    State state;
    Actor potionIntersection=null;
    Actor ghostIntersection=null;
    double yInc,xInc;
    double boost;
    private Actor goldEnergy;
    
     boolean touchpipe=false;
    int power=0;
    boolean highPowerState = false;
    
    boolean powerIntState = false;
    
    GreenfootSound sound = new GreenfootSound("harry.mp3");
    GreenfootSound coin = new GreenfootSound("bonus.wav");
    GreenfootSound healthbar = new GreenfootSound("life.wav"); 
    GreenfootSound health = new GreenfootSound("health.wav"); 
    GreenfootSound big = new GreenfootSound("big.wav"); 
     
    public Harry()
    {
        sound.play();
        getImage().scale(133, 85);
        setImage(getImage());
        changedState=new ChangedState(this);
        initialState=new InitialState(this);
        state = initialState;
    }

    private GreenfootImage flip(GreenfootImage img)
    {
        GreenfootImage img2 = new GreenfootImage(img.getWidth(), img.getHeight());
        for(int x = 0; x < img.getWidth(); x++)
        {
            for(int y = 0; y < img.getHeight(); y++)
            {
                img2.setColorAt(x, y, img.getColorAt(img.getWidth() - 1 - x, y));
            }
        }
        return img2;
    }

    
     public void setState(State newBirdState)
    {
        state = newBirdState;
    }
    
    public void setHarryImage()
    {
        state.setHarryImage();
    }
    
    public State getInitialState()
    {
       return initialState;
    }
    
    public State getChangedState()
    {
       return changedState;
    }
    
    public void act()
    {
        movement();
        getGold();
        checkCollision();
        
        potionIntersection = getOneIntersectingObject(Potion.class);
        if(potionIntersection!=null)
            {
               power++;
                powerIntState = true;
                if(power >= 1)
                {
                    //potion sound
                    big.play();
                    highPowerState = true;
                   // this.setImage("snake.png");
                   this.setState(getChangedState());
                   this.setHarryImage();
                }
                 getWorld().removeObject(potionIntersection);
            }
            
       if(getY()>getWorld().getHeight())
       {
           GameOver game=new GameOver();
           getWorld().addObject(game,500,300    );
           Greenfoot.stop();
           sound.stop();
        }
    }

    private void movement()
    {
        yInc += 0.29999999999999999D;
        if(Greenfoot.isKeyDown("up")||Greenfoot.isKeyDown("space"))
        {
            yInc -= boost;
            boost *= 0.96999999999999997D;
        } else
        {
            boost = 1.0D;
        }
        setLocation(getX(), getY() + (int)Math.round(yInc));
    }

    private void getGold()
    {
       goldEnergy = getOneIntersectingObject(Gold.class);
       if(goldEnergy != null)
        {
          getWorld().removeObject(goldEnergy); 
          coin.play();
          int score = TheWorld.subject.getScore();
          TheWorld.subject.setScore(score + 2);
           
           //increase score.
           
        }
    }
    
    
    private void getPotion()
    {
       goldEnergy=getOneIntersectingObject(Gold.class);
       if(goldEnergy != null)
        {
           getWorld().removeObject(goldEnergy);                     
        }
    }
    
    
    private void checkCollision()
    {
        //ends the game when actor collides with the wall     
        if(getOneIntersectingObject(Ghost.class) != null)
        {
            ghostIntersection = getOneIntersectingObject(Ghost.class);
            if(highPowerState == true){                    
                this.setState(getInitialState());
                this.setHarryImage();
                //loose shield sound
                health.play();
                highPowerState = false;
                ghostIntersection= null;
                setLocation(600,200);
            }
            else{     
            //loose life sound.
            healthbar.play();
            World myWorld=getWorld();
            TheWorld w=(TheWorld)myWorld;
            Life l=w.getLife(); 
            if(touchpipe==false)
            {       
               touchpipe=true;
               if(l.health <= 0)
               {
                  //((TheWorld)getWorld()).end();
                   GameOver game=new GameOver();
                   getWorld().addObject(game,500,300    );
                   Greenfoot.stop();
                   sound.stop();
                 
                }
                else
                l.loseLife(); 
            }
        }  
        }else {
          touchpipe=false;  
        }
    
        
           //life decrease logic
    }
    
  
}
