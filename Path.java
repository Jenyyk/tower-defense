import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Path here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Path extends Actor
{
    /**
     * Act - do whatever the Path wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int[][] pathCoordinates = {
    {50, 50}, {100, 50}, {100, 200}, {450, 200}, {450, 780}
    };
    public void act()
    {
        illustrate_path(this.pathCoordinates);
    }
    private void illustrate_path(int[][] pathCoordinates) {
        ArrayList<Integer> xs = new ArrayList<>();
        ArrayList<Integer> ys = new ArrayList<>();
        for (int i = 0; i < pathCoordinates.length; i++) {
            xs.add(pathCoordinates[i][0]);
            ys.add(pathCoordinates[i][1]);
        }
        for (int i = pathCoordinates.length-1; i > 0; i--) {
            xs.add(pathCoordinates[i][0]);
            ys.add(pathCoordinates[i][1]);
        }
        int[] x = xs.stream().mapToInt(Integer::intValue).toArray();
        int[] y = ys.stream().mapToInt(Integer::intValue).toArray();
        GreenfootImage img = new GreenfootImage(800, 800);
        img.drawPolygon(x, y, x.length);
        this.setImage(img);
    }
}
