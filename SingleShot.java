import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class SingleShot extends Tower
{
    private int range = 140;
    private int cooldown = 140;
    public SingleShot(MyWorld world) {
        super(world);
    }
    public void attack() {
        // gets all enemies in range
        java.util.List<Enemy> inRange = getNeighbours(this.range, true, Enemy.class);
        if (inRange.isEmpty()) { return; }
        Enemy closest = inRange.get(0);
        for (Enemy target : inRange) {
            if (getDistanceTo(closest) > getDistanceTo(target)) {
                closest = target;
            }
        }
        // creates a new bullet object and launches it
        createBullet((Enemy) closest);
        sleepFor(cooldown);
    }
    
    // quick function to get distance to another object
    public double getDistanceTo(Enemy enemy) {
        int dx = enemy.getX() - getX();
        int dy = enemy.getY() - getY();
        return Math.sqrt(dx * dx + dy * dy);  // Pythagorean theorem
    }
}
