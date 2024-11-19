import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author Jenyyk
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 800, 1, false);
        // creates a path for all enemies to follow
        Path global_path = new Path();
        addObject(global_path, 400, 400);
        
        // debug
        addObject(new SingleShot(this), 140, 150);
        addObject(new Shotgun(this), 300, 300);
        
        addObject(new Enemy(global_path), 0, 0);
        addObject(new TowerManager(this), -10, -10);
        
        // will be moved to tower manager
        for (Tower tower : getObjects(Tower.class)) {
            addObject(new RangeIndicator(tower), tower.getX(), tower.getY());
        }
    }
}
