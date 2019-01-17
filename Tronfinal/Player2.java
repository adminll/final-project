import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Player2 of tron
 * 
 * @author Kaden 
 * @version V3 Year 2019
 */
public class Player2 extends Actor
{
    //booleans are used for making the character travel in one of the four directions at all times
    private boolean uIsDown = false;
    private boolean lIsDown = false;
    private boolean dIsDown = false;
    private boolean rIsDown = false;
    
    //Starts to move the characters when true
    private boolean isStarted = false;
    
    /**
     * Sets the size of the lightbike
     * 
     * @param none
     */
    public Player2()
    {
        getImage().scale(10,10);
    }
    
    /**
     * Act - do whatever the Player2 wants to do. This method is called whenever
     * 
     * @param none
     * @returns none
     */
    public void act() 
    {
        //activates isTouchingPlayer2
        isTouchingPlayer1();
        
        //activates keys to move
        isARROWDown();
        
        //spawns line behind player
        if(isStarted == true)
        {
            getWorld().addObject(new Lineplayer2(),getX(),getY());
        }
        
        //all four of these move the character
        if(uIsDown == true && isStarted == true)
        {
            setLocation(getX(),getY()-4);
        }
        
        if(lIsDown == true && isStarted == true)
        {
            setLocation(getX()-4,getY());
        }
        
        if(dIsDown == true && isStarted == true)
        {
            setLocation(getX(),getY()+4);
        }
        
        if(rIsDown == true && isStarted == true)
        {
            setLocation(getX()+4,getY());
        }
    }    
    
    /**
     * makes it so you can move the player
     * 
     * @return none
     * @param none
     */
    private void isARROWDown()
    {
        //all four below are assigned keys to make the chatacter move
        if(Greenfoot.isKeyDown("up"))
        {
            uIsDown = true;
            lIsDown = false;
            dIsDown = false;
            rIsDown = false;
        }
        
        if(Greenfoot.isKeyDown("left"))
        {
            uIsDown = false;
            lIsDown = true;
            dIsDown = false;
            rIsDown = false;
        }
        
        if(Greenfoot.isKeyDown("down"))
        {
            uIsDown = false;
            lIsDown = false;
            dIsDown = true;
            rIsDown = false;
        }
        
        if(Greenfoot.isKeyDown("right"))
        {
            uIsDown = false;
            lIsDown = false;
            dIsDown = false;
            rIsDown = true;
        }
        
        //makes the character move forward while spawning the line behind the character
        if(Greenfoot.isKeyDown("space"))
        {
            uIsDown = false;
            lIsDown = true;
            dIsDown = false;
            rIsDown = false;
            isStarted = true;
        }
    }
    
    //if the player touches the other player, the game stops
    //@param none and @return none
    private void isTouchingPlayer1()
    {
        if(isTouching(Player1.class) == true)
        {
            removeTouching(Player1.class);
            Greenfoot.stop();
            ((MyWorld)getWorld()).update();
        }
        
        //if the character touches the wall the game stops
        if(isAtEdge() == true)
        {
            uIsDown = false;
            lIsDown = false;
            dIsDown = false;
            rIsDown = false;
            ((MyWorld)getWorld()).update();
            Greenfoot.stop();
        }
    }
}
