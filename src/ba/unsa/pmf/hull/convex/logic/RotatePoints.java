package ba.unsa.pmf.hull.convex.logic;

import ba.unsa.pmf.hull.convex.components.PicturePanel;
import ba.unsa.pmf.hull.convex.logic.model.Point3D;

import java.util.ArrayList;

/**
 * Created by Adnan on 23.8.2014.
 */
public class RotatePoints {
    public static void rotateByX(ArrayList<Point3D> points, int angle) {
        double sinAngle = Math.sin(angle * 0.2 * Math.PI / 180);
        double cosAngle = Math.cos(angle * 0.2 * Math.PI / 180);

        for (Point3D point : points) {
            Double y = point.getRotatedY() * cosAngle - point.getRotatedZ() * sinAngle;
            Double z = point.getRotatedY() * sinAngle + point.getRotatedZ() * cosAngle;

            point.setRotatedY(y);
            point.setRotatedZ(z);
        }
    }

    public static void rotateByY(ArrayList<Point3D> points, int angle) {
        double sinAngle = Math.sin(angle * 0.2 * Math.PI / 180);
        double cosAngle = Math.cos(angle * 0.2 * Math.PI / 180);

        for (Point3D point : points) {
            Double x = point.getRotatedZ() * sinAngle + point.getRotatedX() * cosAngle;
            Double z = point.getRotatedZ() * cosAngle - point.getRotatedX() * sinAngle;

            point.setRotatedX(x);
            point.setRotatedZ(z);
        }
    }

    public static void rotateByZ(ArrayList<Point3D> points, int angle) {
        double sinAngle = Math.sin(angle * 0.2 * Math.PI / 180);
        double cosAngle = Math.cos(angle * 0.2 * Math.PI / 180);

        for (Point3D point : points) {
            Double x = point.getRotatedX() * cosAngle - point.getRotatedY() * sinAngle;
            Double y = point.getRotatedX() * sinAngle + point.getRotatedY() * cosAngle;

            point.setRotatedX(x);
            point.setRotatedY(y);
        }
    }

    public static void rotate(ArrayList<Point3D> points, int angleX, int angleY, int angleZ) {
        rotateByX(points, angleX);
        rotateByY(points, angleY);
        rotateByZ(points, angleZ);
        // TODO: implement formula for rotating around a default vector
    }
}
