import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class BuildingIndicator extends Actor
{
    public BuildingIndicator(String type) {
        GreenfootImage img = new GreenfootImage("images/" + type + ".png");
        img.scale(50, 50);
        img.setTransparency(100);
        setImage(img);
    }
    public void act()
    {
        // always moves to mouse on a set grid
        MouseInfo mouse = Greenfoot.getMouseInfo();
        // avoids crashing when mouse is not in game window
        if (mouse == null) { return; }
        double x = (Math.round(mouse.getX()/ 50) + 0.5) * 50;
        double y = (Math.round(mouse.getY() / 50) + 0.5) * 50;
        setLocation((int) x, (int) y);
    }
}
