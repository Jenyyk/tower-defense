import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

public class Path extends Actor
{
    // define the path here
    // todo! tool for defining paths
    public int[][] pathCoordinates = {
    {50, 50}, {100, 50}, {100, 200}, {400, 300}, {450, 780}
    };
    public Path() {
        illustrate_path(this.pathCoordinates);
    }
    public void act()
    {
        // todo
    }
    
    // builds a polygon image
    private void illustrate_path(int[][] pathCoordinates) {
        // makes two lists of coordinates
        ArrayList<Integer> xs = new ArrayList<>();
        ArrayList<Integer> ys = new ArrayList<>();
        // adds from coordinate lists
        for (int i = 0; i < pathCoordinates.length; i++) {
            xs.add(pathCoordinates[i][0]);
            ys.add(pathCoordinates[i][1]);
        }
        // adds again in backwards order
        for (int i = pathCoordinates.length-1; i > 0; i--) {
            xs.add(pathCoordinates[i][0]);
            ys.add(pathCoordinates[i][1]);
        }
        // maps to simple array
        int[] x = xs.stream().mapToInt(Integer::intValue).toArray();
        int[] y = ys.stream().mapToInt(Integer::intValue).toArray();
        // draws image
        GreenfootImage img = new GreenfootImage(800, 800);
        img.drawPolygon(x, y, x.length);
        this.setImage(img);
    }
}
