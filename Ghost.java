import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Ghost extends Enemy
{
    public Ghost(Path path, TowerManager manager) {
        super(path, manager);
        this.moveSpeed = (float) 2.6;
        this.health = 100;
        this.worth = 50;
        this.size = 40;
        GreenfootImage img = getImage();
        img.scale(size, size);
        img.mirrorHorizontally();
    }
}
