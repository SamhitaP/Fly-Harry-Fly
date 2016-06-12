import greenfoot.*;

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{
     
    /**
     * Constructor for objects of class Menu.
     * 
     */
    private ButtonPlay buttonPlay;
    private ButtonHelp buttonHelp;
    private PlayCommand playCmd;
    private HelpCommand helpCmd;
    
    protected GreenfootSound clickSound;
    public Menu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 720, 1); 
        buttonPlay = new ButtonPlay();
        buttonHelp = new ButtonHelp();
        playCmd = new PlayCommand();
        helpCmd = new HelpCommand();
        
        prepare();
    }
    
    public void act()
    {
    }
    
    public void prepare()
    {
        
        addObject(buttonPlay, getWidth()/2, 150);
        addObject(buttonHelp,getWidth()/2,300);
        clickSound = new GreenfootSound("buttonSound.wav");
        buttonPlay.setCommand(playCmd);
        buttonHelp.setCommand(helpCmd);
        playCmd.setReceiver(
          new Receiver(){
             public void performAction()
             {
                if(Greenfoot.mouseClicked(buttonPlay))
                {
                  clickSound.play();  
                  Greenfoot.setWorld(new TheWorld());
             }
            
            
            }
        });
        
         helpCmd.setReceiver(
          new Receiver(){
             public void performAction()
             {
                if(Greenfoot.mouseClicked(buttonHelp))
                {
                    clickSound.play();
                    Help help = buttonHelp.getHelp();
                   addObject(help,getWidth()/2,getHeight()/2);
                   addObject(new ButtonBack(help), help.getX() - help.getImage().getWidth()/2,
                                help.getY() - help.getImage().getHeight()/2);
                  
             }
            
            
            }
        });
        

        
        
        
      
    }
}
