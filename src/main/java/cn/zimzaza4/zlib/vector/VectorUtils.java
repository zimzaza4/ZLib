package cn.zimzaza4.zlib.vector;

import org.bukkit.Location;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;

public class VectorUtils {
    public static List<Location> line(Location locA, Location locB, double rate) {
        rate = Math.abs(rate);
        Vector vectorAB = locB.clone().subtract(locA).toVector();
        double vectorLength = vectorAB.length();
        vectorAB.normalize();
        List<Location> points = new ArrayList<>();
        for (double i = 0; i < vectorLength; i += rate) {
            Vector vector = vectorAB.clone().multiply(i);
            locA.add(vector);
            points.add(locA.clone());
            locA.subtract(vector);
        }

        return points;
    }

    public static List<Location> getRing(Location o, int point, double radius){
        float f = 360f/point;
        List<Location> locations = new ArrayList<>();
        Location clone = o.clone();
        for (int i = 1 ; i < point ; i++ ){
            clone.setYaw(f * i);
            Location p = clone.clone().add(clone.getDirection().multiply(radius));
            locations.add(p);
        }
        return locations;
    }
}
