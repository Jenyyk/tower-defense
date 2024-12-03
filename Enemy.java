import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Enemy extends Actor
{
    private Path path;
    private int pathStage = 0;
    private TowerManager manager;
    public Enemy(Path path, TowerManager manager) {
        this.path = path;
        this.manager = manager;
    }
    
    // precise positions for diagonal moving capability
    private float preciseX = 0;
    private float preciseY = 0;
    
    // can be set to anything in children
    protected float moveSpeed = 1;
    protected float health = 50;
    protected int worth = 50;
    protected int size = 30;
    public void act()
    {   
        // handle dying
        if (this.health <= 0) {
            manager.money += worth;
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
