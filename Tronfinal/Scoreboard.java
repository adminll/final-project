import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Scoreboard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scoreboard extends Actor
{
    private int win;
    
    
    private Font myFont = new Font("Arial", true, false, 24);
    
    public Scoreboard()
    {
        win = 0;
        GreenfootImage img = new GreenfootImage(150,30);
        img.setFont( myFont );
        img.drawString(" " + win, 5,25);
        setImage(img);
    }

    public void addToScore() 
    {
        win++;
        GreenfootImage img = getImage();
        img.clear();
        if(win < 1) {
            img.drawString(" " + win, 5,25); 
        } else {
            getWorld().showText("Game Over!", getWorld().getWidth()/2,getWorld().getHeight()/2);
            Greenfoot.stop();
        }        
    }    
}
