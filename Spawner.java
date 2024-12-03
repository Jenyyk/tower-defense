import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Spawner extends Actor
{
    private MyWorld world;
    private Path path;
    private TowerManager manager;
    public Spawner(MyWorld world, Path path, TowerManager manager_tower) {
        this.world = world;
        this.path = path;
        this.manager = manager_tower;
    }
    private int wave = 1;
    private boolean spawning = false;
    private int enemyCounter = 1;
    public void act()
    {
        // checks if current wave is defeated
        if (world.getObjects(Enemy.class).size() != 0 && !spawning) { 
            enemyCounter = 0;
            return; 
        }
        // only increments the wave on wave end
        if (!spawning) {
            wave += 1;
        }
        // called repeatedly to space out enemies
        // idk man it just works okay?
        spawning = true;
        Enemy enemy = createEnemy(wave);
        world.addObject(enemy, 0, 0);
        enemyCounter++;
        sleepFor(30);
        if (enemyCounter >= wave) { spawning = false; }
    }
    
    private Enemy createEnemy(int wave) {
        Enemy enemy;
        int random = (int) Math.min(Math.floor(Math.random()* (wave / 3)), 3);
        switch (random) {
            case 0:
                enemy = new Slime(path, manager);
                break;
            case 1:
                enemy = new Spider(path, manager);
                break;
            case 2:
                enemy = new Knight(path, manager);
                break;
            case 3:
                enemy = new Ghost(path, manager);
                break;
            default:
                enemy = new Slime(path, manager);
        }
        return enemy;
    }
}
