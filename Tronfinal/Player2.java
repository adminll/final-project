import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Player2 of tron
 * 
 * @author Kaden 
 * @version V4 Year 2019 (Bug fixes and commenting)
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
        
        //all four of these move the character when a key is down plus the game is started && sets the "not die when go backwards" booleans to true or false depending on the key that is pressed
        if(uIsDown == true && isStarted == true)
        {
            setLocation(getX(),getY()-4);
            isPressedW = false;
            isPressedA = false;
            isPressedS = true;
            isPressedD = false;
        }
        
        if(lIsDown == true && isStarted == true)
        {
            setLocation(getX()-4,getY());
            isPressedW = false;
            isPressedA = false;
            isPressedS = false;
            isPressedD = true;
        }
        
        if(dIsDown == true && isStarted == true)
        {
            setLocation(getX(),getY()+4);
            isPressedW = true;
            isPressedA = false;
            isPressedS = false;
            isPressedD = false;
        }
        
        if(rIsDown == true && isStarted == true)
        {
            setLocation(getX()+4,getY());
            isPressedW = false;
            isPressedA = true;
            isPressedS = false;
            isPressedD = false;
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
        //all four below are assigned keys to make the chatacter move && makes the player not move when a key is pressed
        if(Greenfoot.isKeyDown("up") && isPressedW == false)
        {
            uIsDown = true;
            lIsDown = false;
            dIsDown = false;
            rIsDown = false;
        }
        
        if(Greenfoot.isKeyDown("left") && isPressedA == false)
        {
            uIsDown = false;
            lIsDown = true;
            dIsDown = false;
            rIsDown = false;
        }
        
        if(Greenfoot.isKeyDown("down") && isPressedS == false)
        {
            uIsDown = false;
            lIsDown = false;
            dIsDown = true;
            rIsDown = false;
        }
        
        if(Greenfoot.isKeyDown("right") && isPressedD == false)
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
