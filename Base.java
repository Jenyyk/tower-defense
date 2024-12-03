import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Base extends Actor
{
    private MyWorld world;
    private TowerManager manager;
    public Base(MyWorld world, TowerManager manager) {
        this.world = world;
        this.manager = manager;
    }
    public void act()
    {
        Actor reachedEnemy = getOneIntersectingObject(Enemy.class);
        if (reachedEnemy != null) {
            manager.health--;
            world.removeObject(reachedEnemy);
        }
    }
}
