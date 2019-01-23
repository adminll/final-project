import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Line of player2
 * 
 * @author Kaden 
 * @version V2 Year 2019
 */
public class Lineplayer2 extends Actor
{
    //used for spawning in the line (looping)
    private int Loopcount;
    
    /**
     * This bit makes the line the same size as the player
     * 
     * @param no params
     * @return no returns
     */
    public Lineplayer2()
    {
        getImage().scale(10,10);
    }
    
    /**
     * This bit makes the line not kill the player its attached to instantly
     * 
     * @param n/a
     * @return n/a
     */
    public void act() 
    {
        //loopcount adds up
        Loopcount++;
        
        //this bit makes it so when player2 touches this line, it deletes player2 and updates the score
        if(isTouching(Player1.class) == true)
        {
            removeTouching(Player1.class);
            Greenfoot.stop();
            ((MyWorld)getWorld()).update();
        }
        
        //this bit makes it so when player1 touches the line and loopcount is over 5, it deletes the actor and updates the score
        if(isTouching(Player2.class) == true && Loopcount > 5)
        {
            removeTouching(Player2.class); 
            Greenfoot.stop();
            ((MyWorld)getWorld()).updated();
        }
    }    
}
