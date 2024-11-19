import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    public Button(String type) {
        GreenfootImage img = new GreenfootImage("images/" + type + ".png");
        img.scale(30, 30);
        setImage(img);
    }
    public void act()
    {
        ((MyWorld) getWorld()).showText("200", getX(), getY());
    }
}
