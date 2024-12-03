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
        // always move to tower
        // realistically only needs to be called once, but how do i implement that??
        setLocation(targetTower.getX(), targetTower.getY());
        // only visible if the tower is hovered
        if (Greenfoot.mouseMoved(targetTower)) {
            setOpacity(255);
        }
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(targetTower)) {
            setOpacity(0);
        }
    }
    private void setOpacity(int opacity) {
        GreenfootImage img = getImage();
        img.setTransparency(opacity);
        setImage(img);
    }
}
