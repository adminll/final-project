import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Player1 of tron
 * 
 * @author Kaden 
 * @version V4 Year 2019 (Bug fixes and commenting)
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
    
    //booleans that are used to stop making you die when you got backwards
    private boolean isPressedW = false;
    private boolean isPressedA = false;
    private boolean isPressedS = false;
    private boolean isPressedD = false;
    
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
        
        //all four of these move the character when a key is down plus the game is started && sets the "not die when go backwards" booleans to true or false depending on the key that is pressed
        
        
        if(wIsDown == true && isStarted == true)
        {
            setLocation(getX(),getY()-4);
            isPressedW = false;
            isPressedA = false;
            isPressedS = true;
            isPressedD = false;
        }
        
        
        
        if(aIsDown == true && isStarted == true)
        {
            setLocation(getX()-4,getY());
            isPressedW = false;
            isPressedA = false;
            isPressedS = false;
            isPressedD = true;
        }
        
        
        
        
        if(sIsDown == true && isStarted == true)
        {
            setLocation(getX(),getY()+4);
            isPressedW = true;
            isPressedA = false;
            isPressedS = false;
            isPressedD = false;
        }
        
        
        
        
        if(dIsDown == true && isStarted == true)
        {
            setLocation(getX()+4,getY());
            isPressedW = false;
            isPressedA = true;
            isPressedS = false;
            isPressedD = false;
        }
        
        //Below is for backup just incase something goes oopsy
        //if(dIsDown == true & isStarted == true)
        //{
        //    setLocation(getX()+4,getY());
        //}
    }    
    
    /**
     * makes it so you can move the player
     * 
     * @return none
     * @param none
     */
    private void isWASDDown()
    {
        //all four below are assigned keys to make the chatacter move && makes the player not move when a key is pressed
        if(Greenfoot.isKeyDown("w") && isPressedW == false)
        {
            wIsDown = true;
            aIsDown = false;
            sIsDown = false;
            dIsDown = false;
        }
        
        if(Greenfoot.isKeyDown("a") && isPressedA == false)
        {
            wIsDown = false;
            aIsDown = true;
            sIsDown = false;
            dIsDown = false;
        }
        
        if(Greenfoot.isKeyDown("s") && isPressedS == false)
        {
            wIsDown = false;
            aIsDown = false;
            sIsDown = true;
            dIsDown = false;
        }
        
        if(Greenfoot.isKeyDown("d") && isPressedD == false)
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
            
            //???
            isPressedA = true;
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
