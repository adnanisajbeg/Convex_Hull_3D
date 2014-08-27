package ba.unsa.pmf.hull.convex.logic.model;

import ba.unsa.pmf.hull.convex.components.PicturePanel;

import java.util.Comparator;

/**
 * Created by Adnan on 17.8.2014.
 */
public class Point3D implements Comparable<Point3D> {
    private Double originalX;
    private Double originalY;
    private Double originalZ;
    private Double rotatedX;
    private Double rotatedY;
    private Double rotatedZ;

    public Point3D() {
        originalX = ((double) PicturePanel.POINT_SIZE) / 2;
        originalY = ((double) PicturePanel.POINT_SIZE) / 2;
        originalZ = ((double) PicturePanel.POINT_SIZE) / 2;
        rotatedX = ((double) PicturePanel.POINT_SIZE) / 2;
        rotatedY = ((double) PicturePanel.POINT_SIZE) / 2;
        rotatedZ = ((double) PicturePanel.POINT_SIZE) / 2;
    }

    public Point3D(double x, double y, double z) {
        if (x < - (PicturePanel.PANEL_SIZE / 2)) {
            originalX = - ((double) PicturePanel.POINT_SIZE) / 2;
            rotatedX = - ((double) PicturePanel.POINT_SIZE) / 2;
        } else if (x > (PicturePanel.PANEL_SIZE / 2)) {
            originalX = ((double) PicturePanel.PANEL_SIZE - PicturePanel.POINT_SIZE) / 2;
            rotatedX = ((double) PicturePanel.PANEL_SIZE - PicturePanel.POINT_SIZE) / 2;
        } else {
            originalX = x;
            rotatedX = x;
        }

        if (y < - (PicturePanel.PANEL_SIZE / 2)) {
            originalY = ((double) PicturePanel.POINT_SIZE) / 2;
            rotatedY = ((double) PicturePanel.POINT_SIZE) / 2;
        } else if (y > (PicturePanel.PANEL_SIZE / 2)) {
            originalY = ((double) PicturePanel.PANEL_SIZE - PicturePanel.POINT_SIZE) / 2;
            rotatedY = ((double) PicturePanel.PANEL_SIZE - PicturePanel.POINT_SIZE) / 2;
        } else {
            originalY = y;
            rotatedY = y;
        }

        if (z < - (PicturePanel.PANEL_SIZE / 2)) {
            originalZ = ((double) PicturePanel.POINT_SIZE) / 2;
            rotatedZ = ((double) PicturePanel.POINT_SIZE) / 2;
        } else if (z > (PicturePanel.PANEL_SIZE / 2)) {
            originalZ = ((double) PicturePanel.PANEL_SIZE - PicturePanel.POINT_SIZE) / 2;
            rotatedZ = ((double) PicturePanel.PANEL_SIZE - PicturePanel.POINT_SIZE) / 2;
        } else {
            originalZ = z;
            rotatedZ = z;
        }
    }

    public Double getOriginalX() {
        return originalX;
    }

    public void setOriginalX(Double x) {
        originalX = x;
    }

    public Double getOriginalY() {
        return originalY;
    }

    public void setOriginalY(Double y) {
        originalY = y;
    }

    public Double getOriginalZ() {
        return originalZ;
    }

    public void setOriginalZ(Double z) {
        originalZ = z;
    }

    public Double getRotatedX() {
        return rotatedX;
    }

    public void setRotatedX(Double rotatedX) {
        this.rotatedX = rotatedX;
    }

    public Double getRotatedY() {
        return rotatedY;
    }

    public void setRotatedY(Double rotatedY) {
        this.rotatedY = rotatedY;
    }

    public Double getRotatedZ() {
        return rotatedZ;
    }

    public void setRotatedZ(Double rotatedZ) {
        this.rotatedZ = rotatedZ;
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

        return Math.sqrt(Math.pow((A.getOriginalX() - B.getOriginalX()), 2) + Math.pow((A.getOriginalY() - B.getOriginalY()), 2) + Math.pow((A.getOriginalZ() - B.getOriginalZ()), 2));
    }

    public boolean isNull() {
        if (originalX == null || originalY == null || originalZ == null) {
            return true;
        }

        else return false;
    }

    @Override
    public String toString() {
        return "Point3D[" +
                "X=" + originalX +
                ", Y=" + originalY +
                ", Z=" + originalZ +
                ']';
    }

    @Override
    public int hashCode() {
        int result = originalX.intValue();
        result = result + originalY.intValue() * 1000;
        result = result + originalZ.intValue() * 1000000;
        return result;
    }

    @Override
    public int compareTo(Point3D o) {
        // FIXME: use compare from Double
        if (originalX < o.getOriginalX()) {
            return -1;
        } else {
            return 1;
        }
    }
}
