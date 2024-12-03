import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class TowerManager extends Actor
{
    private MyWorld world;
    public int money = 300;
    public TowerManager(MyWorld world) {
        this.world = world;
        // create buying buttons
        world.addObject(new Button("singleShot", 200, this), 50, 750);
        world.addObject(new Button("shotgun", 300, this), 150, 750);
    }
    public void act()
    {
        world.showText("Money: " + money, 50, 20);
        // calls building tower while in building process
        if (buildingTower) {
            makeTower(lastType);
        }
    }
    // check if in the building process
    private boolean buildingTower = false;
    private String lastType;
    private BuildingIndicator indicator = null;
    // method for building towers
    public void makeTower(String type) {
        Tower tower;
        // hardcoded switch for types
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
        if (money < tower.getPrice()) { return; }
        // enters building process, which makes it run forever until a tower is built
        buildingTower = true;
        // creates an indicator if it does not exist
        if (indicator == null) { 
            indicator = new BuildingIndicator(type);
            world.addObject(indicator, -10, -10);
        }
        lastType = type;
        // is called over and over until mouse is clicked
        if (!Greenfoot.mousePressed(null)) {
            return;
        }
        // exit building process to stop calling this function
        buildingTower = false;
        world.removeObject(indicator);
        indicator = null;
        
        // creates tower and range indicator objects
        // snaps them to a 50*50 grid
        MouseInfo mouse = Greenfoot.getMouseInfo();
        double x = (Math.round(mouse.getX()/ 50) + 0.5) * 50;
        double y = (Math.round(mouse.getY() / 50) + 0.5) * 50;
        world.addObject(tower, (int) x, (int) y);
        world.addObject(new RangeIndicator(tower), 0, 0);
        money -= tower.getPrice();
    }
}
