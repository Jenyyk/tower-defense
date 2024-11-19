import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class TowerManager extends Actor
{
    private MyWorld world;
    public int money = 300;
    public TowerManager(MyWorld world) {
        this.world = world;
        // create buying buttons
        world.addObject(new Button("singleShot", this), 50, 750);
        world.addObject(new Button("shotgun", this), 150, 750);
    }
    public void act()
    {
        world.showText("Money: " + money, 50, 20);
        // if in building process, waits for inputs
        if (buildingTower) {
            makeTower(lastType);
        }
    }
    // check if in the building process
    private boolean buildingTower = false;
    private String lastType;
    // method for building towers
    public void makeTower(String type) {
        if (money < 200) { return; }
        buildingTower = true;
        lastType = type;
        // waits for mouse click
        if (!Greenfoot.mousePressed(null)) {
            return;
        }
        buildingTower = false;
        // creates tower based on type
        Tower tower;
        switch (type) {
            case "shotgun":
                tower = new Shotgun(world);
                break;
            case "singleShot":
                tower = new SingleShot(world);
                break;
            default:
                return;
        }
        // creates tower and range indicator
        MouseInfo mouse = Greenfoot.getMouseInfo();
        world.addObject(tower, mouse.getX(), mouse.getY());
        world.addObject(new RangeIndicator(tower), 0, 0);
        money -= 200;
    }
}
