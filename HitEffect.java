import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class HitEffect extends Actor
{
    public HitEffect(String type, int scale) {
        GreenfootImage img = new GreenfootImage("images/" + type + ".png");
        img.scale(scale, scale);
        setImage(img);
    }
    private int counter = 0;
    public void act()
    {
        // stays on screen for 20 act cycles
        if (counter < 20) {
            counter++;
            return;
        }
        getWorld().removeObject(this);
        return;
    }
}
