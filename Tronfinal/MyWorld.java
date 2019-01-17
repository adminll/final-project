import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is my final Greenfoot project of thus unit. I created Tron Lightbike
 * 
 * @author Kaden
 * @version V1 Year 2019
 */
public class MyWorld extends greenfoot.World
{
    //Boolean created to show starting text on the screen
    private boolean startingText = true;
    
    //sets Scoreboard to score
    private Scoreboard score;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(750, 700, 1); 
        
        //Adds player1 and player2 to the world
        addPlayers();
        
        //start text for the starting text of the world
        startText();
        
        //Used for testing pourposes
        startGame();
        
        //creates the grid of the background
        gridBackground();
        
        //adds the score to the world
        score = new Scoreboard();
        addObject(score,75,25);
        
    }
    
    
    /**
     * Act makes the text of the middle of the world dissapear before the game starts
     * 
     * @param None
     * @return none
     */
    public void act()
    {
        showText("",getWidth()/2,getHeight()/2);
    }
    
    
    /**
     * gridBackgroubd creates the background of the world which is a grid
     * 
     * @param none
     * @return none
     */
    private void gridBackground()
    {
        //Fills the background with a blackbox
        getBackground().setColor(Color.BLACK);
        getBackground().fillRect(0,0,getWidth(),getHeight());
        
        //sets the grid color to gray
        getBackground().setColor(Color.GRAY);
        
        //sets the length of the lines
        int length = 20;
        
        for(int i = 0; i < 60; i++)
        {
            getBackground().fillRect(length,0,2,getHeight());
            length = length+20;
        }
        
        //sets the height of the lines
        int height = 20;
        
        //creates the lines
        for(int i = 0; i < 60;i++)
        {
            getBackground().fillRect(0, height, getWidth(),2);
            height = height+20;
        }
    }
    
    /**
     * shows the text but was also supposed to disable the text when game started
     * 
     * @param none
     * @return none
     */
    private void startText()
    {
        if(startingText == true)
        {
            showText("Double tap the Spacebar to begin", getWidth()/2,getHeight()/2);
        }
        else if(startingText == false)
        {
            showText("",getWidth()/2,getHeight()/2);
        }
    }
    
    /**
     * This bit of code adds the players to the world
     * 
     * @param none
     * @return none
     */
    private void addPlayers()
    {
        addObject(new Player1(), 10, getWidth()/2);
        addObject(new Player2(), 740, getWidth()/2);
    }
    
    //Used for testing ignore this
    private void startGame()
    {
        if(Greenfoot.isKeyDown("enter"))
        {
            Greenfoot.start();
            startingText = false;
        }
    }
    
    //updates the score to end the game and display the message "game over"
    public void update()
    {
        score.addToScore();
    }
}
