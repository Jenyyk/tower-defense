import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Enemy extends Actor
{
    private Path path;
    private int pathStage = 0;
    public Enemy(Path path) {
        this.path = path;
    }
    
    // precise positions for diagonal moving capability
    private float preciseX = 0;
    private float preciseY = 0;
    // can be set to anything in children
    public float moveSpeed = 1;
    
    public float health = 200;
    public void act()
    {   
        // handle dying
        if (this.health <= 0) {
            getWorld().removeObject(this);
            return;
        }
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
        
        // move in precise units, with a lot of Math
        turnTowards(targetX, targetY);
        int rotation = getRotation();
        this.preciseX += moveSpeed * Math.cos(Math.toRadians(rotation));
        this.preciseY += moveSpeed * Math.sin(Math.toRadians(rotation));
        setLocation((int) preciseX, (int) preciseY);
    }
}
