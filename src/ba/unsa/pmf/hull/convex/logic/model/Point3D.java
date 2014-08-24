package ba.unsa.pmf.hull.convex.logic.model;

import ba.unsa.pmf.hull.convex.components.PicturePanel;

import java.util.Comparator;

/**
 * Created by Adnan on 17.8.2014.
 */
public class Point3D implements Comparable<Point3D> {
    private Double X;
    private Double Y;
    private Double Z;

    public Point3D() {
        X = ((double) PicturePanel.POINT_SIZE) / 2;
        Y = ((double) PicturePanel.POINT_SIZE) / 2;
        Z = ((double) PicturePanel.POINT_SIZE) / 2;
    }

    public Point3D(double x, double y, double z) {
        if (x < 0) {
            X = ((double) PicturePanel.POINT_SIZE) / 2;
        } else if (x > PicturePanel.PANEL_SIZE) {
            X = ((double) PicturePanel.PANEL_SIZE - PicturePanel.POINT_SIZE) / 2;
        } else {
            X = x;
        }

        if (y < 0) {
            Y = ((double) PicturePanel.POINT_SIZE) / 2;
        } else if (y > PicturePanel.PANEL_SIZE) {
            Y = ((double) PicturePanel.PANEL_SIZE - PicturePanel.POINT_SIZE) / 2;
        } else {
            Y = y;
        }

        if (z < 0) {
            Z = ((double) PicturePanel.POINT_SIZE) / 2;
        } else if (z > PicturePanel.PANEL_SIZE) {
            Z = ((double) PicturePanel.PANEL_SIZE - PicturePanel.POINT_SIZE) / 2;
        } else {
            Z = z;
        }
    }

    public Double getX() {
        return X;
    }

    public void setX(Double x) {
        X = x;
    }

    public Double getY() {
        return Y;
    }

    public void setY(Double y) {
        Y = y;
    }

    public Double getZ() {
        return Z;
    }

    public void setZ(Double z) {
        Z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point3D)) return false;

        Point3D point3D = (Point3D) o;

        if (distanceFromPoint(this, point3D) <= (PicturePanel.POINT_SIZE / 2)) return false;

        return true;
    }

    public static Double distanceFromPoint(Point3D A, Point3D B) {
        if (A == null || B == null) return 0.0;
        if (B == A) return 0.0;
        if (!(A instanceof Point3D) || !(B instanceof Point3D)) return 0.0;
        if (A.isNull() || B.isNull()) return 0.0;

        return Math.sqrt(Math.pow((A.getX() - B.getX()), 2) + Math.pow((A.getY() - B.getY()), 2) + Math.pow((A.getZ() - B.getZ()), 2));
    }

    public boolean isNull() {
        if (X == null || Y == null || Z == null) {
            return true;
        }

        else return false;
    }

    @Override
    public String toString() {
        return "Point3D[" +
                "X=" + X +
                ", Y=" + Y +
                ", Z=" + Z +
                ']';
    }

    @Override
    public int hashCode() {
        int result = X.intValue();
        result = result + Y.intValue() * 1000;
        result = result + Z.intValue() * 1000000;
        return result;
    }

    @Override
    public int compareTo(Point3D o) {
        if (X < o.getX()) {
            return -1;
        } else {
            return 1;
        }
    }
}
