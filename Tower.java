import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

abstract class Tower extends Actor
{
    // will always keep a refference to world
    public MyWorld world;
    public Tower(MyWorld world) {
        this.world = world;
    }
    // each tower has a different attack function
    public void act() {
        attack();
    }
    
    // method for towers to create bullets
    public void createBullet(Enemy target, float damage) {
        Bullet bullet = new Bullet(target, damage, getX(), getY());
        world.addObject(bullet, getX(), getY());
    }
    // method for towers to scale their own images
    public void renderSelf() {
        GreenfootImage img = getImage();
        img.scale(50, 50);
        setImage(img);
    }
    
    // every tower needs an attack method
    public abstract void attack();
    // every tower has an attack getter, for the RangeIndicator class
    public abstract int getRange();
}
