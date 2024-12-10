import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Grenade extends Projectile
{
    private int splashRange = 80;
    public Grenade(Enemy enemy, float damage, int spawnX, int spawnY) {
        super(enemy, damage, spawnX, spawnY);
        // renders grenade
        GreenfootImage img = new GreenfootImage(20, 15);
        img.setColor(new Color(10, 120, 20));
        img.fill();
        setImage(img);
    }
    
    public void bulletHit(Enemy target) {
        GreenfootImage img = new GreenfootImage("images/explosion.png");
        img.scale(splashRange, splashRange);
        setImage(img);
        setRotation(0);
        setLocation(target.getX(), target.getY());
        for (Enemy enemy : getObjectsInRange(splashRange, Enemy.class)) {
            enemy.health -= this.damage;            
        }
        Greenfoot.delay(5);
    }
}
