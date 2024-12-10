import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public abstract class Projectile extends Actor
{
    protected float damage;
    private Enemy target;
    public Projectile(Enemy target, float damage, int spawnX, int spawnY) {
        this.target = target;
        // initializes precise position
        this.preciseX = (float) spawnX;
        this.preciseY = (float) spawnY;
        // sets bullet damage
        this.damage = damage;
    }
    private float preciseX;
    private float preciseY;
    private float moveSpeed = (float) 1.5;
    public void act() {
        // prevents crashing from target dying before bullet reaches it
        if (target == null || target.getWorld() == null) {
            getWorld().removeObject(this);
            return;
        }
        // continuously moves towards target
        turnTowards(target.getX(), target.getY());
        int rotation = getRotation();
        this.preciseX += moveSpeed * Math.cos(Math.toRadians(rotation));
        this.preciseY += moveSpeed * Math.sin(Math.toRadians(rotation));
        setLocation((int) preciseX, (int) preciseY);
        // bulletHit is an abstract method, used for different bullet types
        if (intersects(target)) {
            bulletHit(target);
            getWorld().removeObject(this);
        }
        // ramp up speed to catch fast enemies
        // otherwise bullets would never hit
        this.moveSpeed += 0.05;
    }
    abstract void bulletHit(Enemy target);
}
