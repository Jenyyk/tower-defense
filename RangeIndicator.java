import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class RangeIndicator extends Actor
{
    private Tower targetTower;
    public RangeIndicator(Tower targetTower) {
        // creates image as big as target towers range
        GreenfootImage img = getImage();
        int targetRange = targetTower.getRange() * 2;
        img.scale(targetRange, targetRange);
        setImage(img);
        setLocation(targetTower.getX(), targetTower.getY());
        this.targetTower = targetTower;
    }
    // moves to owner tower
    public void act() {
        setLocation(targetTower.getX(), targetTower.getY());
    }
}
