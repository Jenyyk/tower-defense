import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Knight extends Enemy
{
    public Knight(Path path, TowerManager manager) {
        super(path, manager);
        this.moveSpeed = (float) 0.8;
        this.health = 200;
        this.worth = 200;
        this.size = 60;
        GreenfootImage img = getImage();
        img.scale(size, size);
        img.mirrorHorizontally();
    }
}
