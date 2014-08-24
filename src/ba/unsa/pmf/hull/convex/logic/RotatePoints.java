package ba.unsa.pmf.hull.convex.logic;

import ba.unsa.pmf.hull.convex.components.PicturePanel;
import ba.unsa.pmf.hull.convex.logic.model.Point3D;

import java.util.ArrayList;

/**
 * Created by Adnan on 23.8.2014.
 */
public class RotatePoints {
    public static ArrayList<Point3D> rotateByX(ArrayList<Point3D> points, int angle) {
        ArrayList<Point3D> newPoints = new ArrayList<Point3D>(points);

        return newPoints;
    }

    public static ArrayList<Point3D> rotateByY(ArrayList<Point3D> points, int angle) {
        double sinAngle = Math.sin(angle * Math.PI / 180);
        double cosAngle = Math.cos(angle * Math.PI / 180);

        for (Point3D point : points) {
            Double x = point.getRotatedZ() * sinAngle + point.getRotatedX() * cosAngle;
            Double z = point.getRotatedZ() * cosAngle - point.getRotatedX() * sinAngle;

            point.setRotatedX(x);
            point.setRotatedZ(z);
        }

        return points;
    }

    public static ArrayList<Point3D> rotateByZ(ArrayList<Point3D> points, int angle) {
        ArrayList<Point3D> newPoints = new ArrayList<Point3D>(points);


        return newPoints;
    }

    public static void rotate(ArrayList<Point3D> points, int angleX, int angleY, int angleZ) {
        rotateByX(rotateByY(rotateByZ(points, angleZ), angleY), angleX);
        // TODO: implement formula for rotating around a default vector
        /*ArrayList<Point3D> newPoints = new ArrayList<Point3D>(points.size());


        return newPoints;*/
    }
}
