import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * World
 * 
 * @author Jenyyk
 */
public class MyWorld extends World
{
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 800, 1, false);
        // creates a path for all enemies to follow
        Path global_path = new Path();
        addObject(global_path, 400, 400);
        
        // create and add the managers for towers and enemies
        TowerManager manager_tower = new TowerManager(this);
        addObject(manager_tower, -10, -10);
        Spawner spawner = new Spawner(this, global_path, manager_tower);
        addObject(spawner, -10, -10);
        Base base = new Base(this, manager_tower);
        // last coordinates of path (end of path)
        int baseX = global_path.pathCoordinates[global_path.pathCoordinates.length - 1][0];
        int baseY = global_path.pathCoordinates[global_path.pathCoordinates.length - 1][1];
        addObject(base, baseX, baseY);
        
        
        
        // important in order to detect hovering over towers
        // used for the opacity of range indicators
        setPaintOrder(Tower.class);
        
        // spawns one enemy to start the game
        addObject(new Slime(global_path, manager_tower), 0, 0);
    }
}
