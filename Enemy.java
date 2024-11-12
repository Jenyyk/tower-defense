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
    
    public void act()
    {
        int[][] coordinates = path.pathCoordinates;
        if (pathStage > coordinates.length - 1) { return; }
        int targetX = coordinates[pathStage][0];
        int targetY = coordinates[pathStage][1];
        if (getX() == targetX && getY() == targetY) {
            pathStage++;
            return;
        }
        turnTowards(targetX, targetY);
        move(1);
    }
}
