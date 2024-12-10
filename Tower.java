import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

abstract class Tower extends Actor
{
    // will always keep a refference to world
    public MyWorld world;
    public int price;
    public Tower(MyWorld world) {
        this.world = world;
    }
    // each tower has a different attack function
    public void act() {
        attack();
    }
    
    // method for towers to create bullets
    // passes the target parameter to bullets for targeting
    public void createBullet(Enemy target, float damage, String type) {
        Projectile projectile;
        switch (type) {
            case "bullet":
                projectile = new Bullet(target, damage, getX(), getY());
                break;
            case "grenade":
                projectile = new Grenade(target, damage, getX(), getY());
                break;
            default:
                return;
        }
        
        world.addObject(projectile, getX(), getY());
    }
    // method for towers to scale their own images
    public void renderSelf() {
        GreenfootImage img = getImage();
        img.scale(50, 50);
        setImage(img);
    }
    
    // quick function to get distance to another object
    public double getDistanceTo(Enemy enemy) {
        int dx = enemy.getX() - getX();
        int dy = enemy.getY() - getY();
        return Math.sqrt(dx * dx + dy * dy);  // Pythagorean theorem
    }
    
    // every tower needs an attack method
    public abstract void attack();
    // every tower has an attack getter, for the RangeIndicator class
    public abstract int getRange();
    // every tower has a price getter, for the tower manager
    public abstract int getPrice();
}
