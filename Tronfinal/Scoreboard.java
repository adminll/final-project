import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Taken from a prevoius assignment to add into this game
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scoreboard extends Actor
{
    //integer determins if the game has ended if it is over 1
    private int win;
    
    //creates a new font
    private Font myFont = new Font("Arial", true, false, 24);
    
    /**
     * Sets win to 0, creates the "invisible score" in the corner, sets the font to myFont and draws the image in the corner
     * 
     * @param none
     */
    public Scoreboard()
    {
        win = 0;
        GreenfootImage img = new GreenfootImage(150,30);
        img.setFont( myFont );
        img.drawString(" ", 5,25);
        setImage(img);
    }

    /**
     * Makes win count up, sets img to clear from the screen (even though its not there)
     * 
     * @param none
     */
    public void addToScore() 
    {
        win++;
        GreenfootImage img = getImage();
        img.clear();
        
        //if win is below 1 it will keep the invisible score on the screen. If win is over 1 then it will display the message "game over" in the middle of the screen as soon as either player1 or player2 "derezzes"
        if(win < 1) {
            img.drawString(" " + win, 5,25); 
        } else {
            getWorld().showText("Game Over!", getWorld().getWidth()/2,getWorld().getHeight()/2);
            Greenfoot.stop();
        }        
    }    
}
