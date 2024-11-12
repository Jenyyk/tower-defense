import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Shotgun extends Tower
{
    private int range = 100;
    private int cooldown = 50;
    public Shotgun(MyWorld world) {
        super(world);
    }
    public void attack() {
        for (Enemy enemy : getNeighbours(this.range, true, Enemy.class)) {
            createBullet(enemy);
        }
        sleepFor(cooldown);
    }
}
