package ba.unsa.pmf.hull.convex.logic.model;

/**
 * Created by Adnan on 28.8.2014.
 */
public class Triangle {
    Point3D point1;
    Point3D point2;
    Point3D point3;
    Point3D middle;
    Triangle triangle12;
    Triangle triangle13;
    Triangle triangle23;

    public Triangle(Point3D point1, Point3D point2, Point3D point3) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;

        double x = (point1.getOriginalX() + point2.getOriginalX() + point3.getOriginalZ()) / 3;
        double y = (point1.getOriginalY() + point2.getOriginalY() + point3.getOriginalY()) / 3;
        double z = (point1.getOriginalZ() + point2.getOriginalZ() + point3.getOriginalZ()) / 3;

        middle = new Point3D(x, y, z);
    }

    public Point3D getPoint1() {
        return point1;
    }
    public Point3D getPoint2() {
        return point2;
    }
    public Point3D getPoint3() {
        return point3;
    }
    public Point3D getMiddle() { return middle; }

    public Triangle getTriangle12() {
        return triangle12;
    }

    public void setTriangle12(Triangle triangle12) {
        this.triangle12 = triangle12;
    }

    public Triangle getTriangle13() {
        return triangle13;
    }

    public void setTriangle13(Triangle triangle13) {
        this.triangle13 = triangle13;
    }

    public Triangle getTriangle23() {
        return triangle23;
    }

    public void setTriangle23(Triangle triangle23) {
        this.triangle23 = triangle23;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "point1=" + point1 +
                ", point2=" + point2 +
                ", point3=" + point3 +
                '}';
    }
}
