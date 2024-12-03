import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class SingleShot extends Tower
{
    private int range = 140;
    private int cooldown = 140;
    private float damage = 80;
    private int price = 200;
    public SingleShot(MyWorld world) {
        super(world);
        renderSelf();
    }
    // attacks closest enemy in range
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
        // faces toward target
        turnTowards(target.getX(), target.getY());
        setRotation(getRotation() + 150);
        // creates a new bullet object and launches it
        createBullet(target, this.damage);
        sleepFor(this.cooldown);
    }
    
    // quick function to get distance to another object
    public double getDistanceTo(Enemy enemy) {
        int dx = enemy.getX() - getX();
        int dy = enemy.getY() - getY();
        return Math.sqrt(dx * dx + dy * dy);  // Pythagorean theorem
    }
    
    public int getRange() { return this.range; }
    public int getPrice() { return this.price; }
}
