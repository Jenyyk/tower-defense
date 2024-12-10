import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Splash extends Tower
{   
    private int range = 120;
    private int cooldown = 100;
    private float damage = 30;
    private int price = 400;
    public Splash(MyWorld world) {
        super(world);
        renderSelf();
    }
    public void attack() {
        // gets all enemies in range
        java.util.List<Enemy> inRange = getObjectsInRange(this.range, Enemy.class);
        if (inRange.isEmpty()) { return; }
        // gets closest enemy
        Enemy closest = inRange.get(0);
        for (Enemy target : inRange) {
            if (getDistanceTo(closest) > getDistanceTo(target)) {
                closest = target;
            }
        }
        Enemy target = (Enemy) closest;
        // creates a new bullet object and launches it
        createBullet(target, this.damage, "grenade");
        sleepFor(this.cooldown);
    }
    
    public int getRange() { return this.range; }
    public int getPrice() { return this.price; }
}
