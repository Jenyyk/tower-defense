import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    private int scale = 40;
    private TowerManager manager;
    private String type;
    public Button(String type, TowerManager manager) {
        // creates image and outline
        GreenfootImage img = new GreenfootImage("images/" + type + ".png");
        img.scale(scale, scale);
        int[] xs = {0, scale - 1, scale - 1, 0};
        int[] ys = {0, 0, scale - 1, scale - 1};
        img.drawPolygon(xs, ys, 4);
        setImage(img);
        this.manager = manager;
        this.type = type;
    }
    public void act()
    {
        // checks if was clicked
        ((MyWorld) getWorld()).showText("BUY\n\n200", getX(), getY());
        if (Greenfoot.mouseClicked(this)) {
            manager.makeTower(type);
        }
    }
}
