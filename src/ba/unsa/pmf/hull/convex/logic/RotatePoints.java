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
        ArrayList<Point3D> newPoints = new ArrayList<Point3D>(points.size());

        int fixer = + PicturePanel.PANEL_SIZE / 2;
        fixer = 0; // BRISATI

        double sinAngle = Math.sin(angle * Math.PI / 180);
        double cosAngle = Math.cos(angle * Math.PI / 180);

        for (Point3D point : points) {
            Point3D newPoint = new Point3D();

            System.out.println("point.getZ(): " + point.getZ());
            System.out.println("sinAngle: " + sinAngle);
            System.out.println("point.getX(): " + point.getX());
            System.out.println("cosAngle: " + cosAngle);
            System.out.println("point.getZ() * sinAngle : " + (point.getZ() * sinAngle));
            System.out.println("point.getX()) * cosAngle: " + (point.getX() * cosAngle));
            System.out.println("(point.getZ() * sinAngle + (point.getX()) * cosAngle: " + ((point.getZ() * sinAngle + (point.getX()) * cosAngle)));

            System.out.println("new X = " + ((point.getZ() * sinAngle + (point.getX()) * cosAngle)));

            newPoint.setX(point.getZ() * sinAngle + point.getX() * cosAngle);
            newPoint.setZ(point.getZ() * cosAngle - point.getX() * sinAngle);
            newPoint.setY(point.getY());

            newPoints.add(newPoint);
        }

        return newPoints;
    }

    public static ArrayList<Point3D> rotateByZ(ArrayList<Point3D> points, int angle) {
        ArrayList<Point3D> newPoints = new ArrayList<Point3D>(points);


        return newPoints;
    }

    public static ArrayList<Point3D> rotate(ArrayList<Point3D> points, int angleX, int angleY, int angleZ) {
        return rotateByX(rotateByY(rotateByZ(points, angleZ), angleY), angleX);
        // TODO: implement formula for rotating around a default vector
        /*ArrayList<Point3D> newPoints = new ArrayList<Point3D>(points.size());


        return newPoints;*/
    }
}
