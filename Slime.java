import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Slime extends Enemy
{
    public Slime(Path path, TowerManager manager) {
        super(path, manager);
        this.moveSpeed = (float) 1.4;
        this.health = 40;
        this.worth = 30;
        this.size = 32;
        GreenfootImage img = getImage();
        img.scale(size, size);
    }
}
