import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player1 extends Actor
{
    //booleans are used for making the character travel in one of the four directions at all times
    private boolean wIsDown = false;
    private boolean aIsDown = false;
    private boolean sIsDown = false;
    private boolean dIsDown = false;
    
    //Starts to move the characters when true
    private boolean isStarted = false;
    
    
    /**
     * Sets the size of the lightbike
     * 
     * @param none
     */
    public Player1()
    {
        getImage().scale(10,10);
    }
    
    /**
     * Act - do whatever the Player1 wants to do. This method is called whenever
     * 
     * @param none
     * @returns none
     */
    public void act() 
    {
        //activates isTouchingPlayer2
        isTouchingPlayer2();
        
        //activates keys to move
        isWASDDown();
        
        //spawns line behind player
        if(isStarted == true)
        {
            getWorld().addObject(new Lineplayer1(),getX(),getY());
        }
        
        //all four of these move the character
        if(wIsDown == true)
        {
            setLocation(getX(),getY()-4);
        }
        
        if(aIsDown == true)
        {
            setLocation(getX()-4,getY());
        }
        
        if(sIsDown == true)
        {
            setLocation(getX(),getY()+4);
        }
        
        if(dIsDown == true)
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
    private void isWASDDown()
    {
        //all four below are assigned keys to make the chatacter move
        if(Greenfoot.isKeyDown("w"))
        {
            wIsDown = true;
            aIsDown = false;
            sIsDown = false;
            dIsDown = false;
        }
        
        if(Greenfoot.isKeyDown("a"))
        {
            wIsDown = false;
            aIsDown = true;
            sIsDown = false;
            dIsDown = false;
        }
        
        if(Greenfoot.isKeyDown("s"))
        {
            wIsDown = false;
            aIsDown = false;
            sIsDown = true;
            dIsDown = false;
        }
        
        if(Greenfoot.isKeyDown("d"))
        {
            wIsDown = false;
            aIsDown = false;
            sIsDown = false;
            dIsDown = true;
        }
        
        //makes the character move forward while spawning the line behind the character
        if(Greenfoot.isKeyDown("space"))
        {
            wIsDown = false;
            aIsDown = false;
            sIsDown = false;
            dIsDown = true;
            isStarted = true;
        }
    }
    
    //if the player touches the other player, the game stops
    //@param none and @return none
    private void isTouchingPlayer2()
    {
        if(isTouching(Player2.class) == true)
        {
            removeTouching(Player2.class);
            Greenfoot.stop();
            ((MyWorld)getWorld()).update();
        }
        
        //if the character touches the wall the game stops
        if(isAtEdge() == true)
        {
            wIsDown = false;
            aIsDown = false;
            sIsDown = false;
            dIsDown = false;
            ((MyWorld)getWorld()).update();
            Greenfoot.stop();
        }
    }
}
