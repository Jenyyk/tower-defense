import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Bullet extends Projectile
{
    public Bullet(Enemy enemy, float damage, int spawnX, int spawnY) {
        super(enemy, damage, spawnX, spawnY);
        // renders bullet
        GreenfootImage img = new GreenfootImage(20, 5);
        img.setColor(Color.RED);
        img.fill();
        setImage(img);
    }
    // this method is ran when the bullet meets its target
    public void bulletHit(Enemy target) {
        target.health -= this.damage;
    }
}
