package ba.unsa.pmf.hull.convex.logic;

import ba.unsa.pmf.hull.convex.logic.model.Point3D;

import java.util.ArrayList;

/**
 * Created by Adnan on 17.8.2014.
 */
public class FixPoints {
    public static ArrayList<Point3D> fixPositions(ArrayList<Point3D> listOfPoints, int fixX, int fixY, int fixZ) {
        ArrayList<Point3D> temp = new ArrayList<Point3D>(listOfPoints.size());
        Point3D tempPoint;

        for (int i = 1; i <= listOfPoints.size(); i++) {
            tempPoint = temp.get(i);
            temp.add(i, new Point3D(tempPoint.getX() + fixX, tempPoint.getY() + fixY, tempPoint.getZ() + fixZ));
        }

        return temp;
    }
}
