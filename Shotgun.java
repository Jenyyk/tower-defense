import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Shotgun extends Tower
{
    private int range = 100;
    private int cooldown = 50;
    private float damage = 20;
    public int price = 300;
    public Shotgun(MyWorld world) {
        super(world);
        renderSelf();
    }
    // attacks all enemies in range at the same time
    public void attack() {
        for (Enemy enemy : getObjectsInRange(this.range, Enemy.class)) {
            createBullet(enemy, this.damage, "bullet");
        }
        sleepFor(this.cooldown);
    }
    
    public int getRange() { return this.range; }
    public int getPrice() { return this.price; }
}
