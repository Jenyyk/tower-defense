import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class TowerManager extends Actor
{
    private MyWorld world;
    public TowerManager(MyWorld world) {
        this.world = world;
        // create buying buttons
        world.addObject(new Button("singleShot"), 50, 750);
        world.addObject(new Button("shotgun"), 150, 750);
    }
    public void act()
    {
        
    }
}
