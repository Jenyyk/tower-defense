import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

abstract class Tower extends Actor
{
    public MyWorld world;
    public Tower(MyWorld world) {
        this.world = world;
    }
    public void act() {
        attack();
    }
    
    // method for towers to create bullets
    public void createBullet(Enemy target) {
        Bullet bullet = new Bullet(target, getX(), getY());
        world.addObject(bullet, getX(), getY());
    }
    
    // every tower needs an attack method
    public abstract void attack();
}
