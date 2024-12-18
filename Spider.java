import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Spider extends Enemy
{
    public Spider(Path path, TowerManager manager) {
        super(path, manager);
        this.moveSpeed = (float) 1.0;
        this.health = 90;
        this.worth = 50;
        this.size = 40;
        GreenfootImage img = getImage();
        img.scale(size, size);
        img.mirrorHorizontally();
    }
}
