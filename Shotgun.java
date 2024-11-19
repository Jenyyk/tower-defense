import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Shotgun extends Tower
{
    private int range = 100;
    private int cooldown = 50;
    private float damage = 20;
    public Shotgun(MyWorld world) {
        super(world);
        renderSelf();
    }
    // attacks all enemies in range at the same time
    public void attack() {
        for (Enemy enemy : getObjectsInRange(this.range, Enemy.class)) {
            createBullet(enemy, this.damage);
        }
        sleepFor(this.cooldown);
    }
    
    public int getRange() { return range; }
}
