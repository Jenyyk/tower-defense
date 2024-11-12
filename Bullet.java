import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Bullet extends Actor
{
    private Enemy target;
    public Bullet(Enemy target, int spawnX, int spawnY) {
        this.target = target;
        GreenfootImage img = new GreenfootImage(20, 5);
        img.setColor(Color.RED);
        img.fill();
        setImage(img);
        this.preciseX = (float) spawnX;
        this.preciseY = (float) spawnY;
    }
    private float preciseX;
    private float preciseY;
    private float moveSpeed = (float) 1.5;
    public void act() {
        turnTowards(target.getX(), target.getY());
        int rotation = getRotation();
        this.preciseX += moveSpeed * Math.cos(Math.toRadians(rotation));
        this.preciseY += moveSpeed * Math.sin(Math.toRadians(rotation));
        setLocation((int) preciseX, (int) preciseY);
        if (intersects(target)) {
            getWorld().removeObject(this);
        }
        this.moveSpeed += 0.05;
    }
}
