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
    private String type;
    private int price;
    private TowerManager manager;
    public Button(String type, int price, TowerManager manager) {
        // creates image and outline
        GreenfootImage img = new GreenfootImage("images/" + type + ".png");
        img.scale(scale, scale);
        int[] xs = {0, scale - 1, scale - 1, 0};
        int[] ys = {0, 0, scale - 1, scale - 1};
        img.drawPolygon(xs, ys, 4);
        setImage(img);
        
        this.price = price;
        this.manager = manager;
        this.type = type;
    }
    public void act()
    {
        ((MyWorld) getWorld()).showText("BUY\n\n" + price, getX(), getY());
        // waits until clicked, then starts building process in tower manager
        if (Greenfoot.mouseClicked(this)) {
            manager.makeTower(type);
        }
    }
}
