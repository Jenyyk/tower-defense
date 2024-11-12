import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private Path path;
    private int pathStage = 0;
    public Enemy(Path path) {
        this.path = path;
    }
    
    private float preciseX = 0;
    private float preciseY = 0;
    public float moveSpeed = 1;
    
    public void act()
    {
        // gets coordinate array from path
        int[][] coordinates = path.pathCoordinates;
        // cancels if reached end
        if (pathStage > coordinates.length - 1) { return; }
        // gets target X and Y coordinates
        int targetX = coordinates[pathStage][0];
        int targetY = coordinates[pathStage][1];
        // moves on to next stage if finished
        if (getX() == targetX && getY() == targetY) {
            pathStage++;
            return;
        }
        
        turnTowards(targetX, targetY);
        int rotation = getRotation();
        this.preciseX += moveSpeed * Math.cos(Math.toRadians(rotation));
        this.preciseY += moveSpeed * Math.sin(Math.toRadians(rotation));
        setLocation((int) preciseX, (int) preciseY);
    }
}
