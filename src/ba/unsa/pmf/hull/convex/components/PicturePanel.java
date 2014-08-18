package ba.unsa.pmf.hull.convex.components;

import ba.unsa.pmf.hull.convex.logic.FixPoints;
import ba.unsa.pmf.hull.convex.logic.GeneratePoints;
import ba.unsa.pmf.hull.convex.logic.model.Point3D;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Adnan on 17.8.2014.
 */
public class PicturePanel extends JPanel {
    public static final Integer POINT_SIZE = new Integer("5");
    public static final Integer PANEL_SIZE = new Integer("500");
    private Integer numberOfPoints = new Integer("10"); // DEFAULT FOR TESTING
    private static Graphics2D g2d;
    private ArrayList<Point3D> startArrayOfPoints;
    private ArrayList<Point3D> arrayOfFixedPositionsOfPoints;

    public Integer getNumberOfPoints() {
        return numberOfPoints;
    }

    public void setNumberOfPoints(Integer numberOfPoints) {
        this.numberOfPoints = numberOfPoints;
    }

    public PicturePanel() {
        this.setVisible(true);
        this.setSize(PANEL_SIZE, PANEL_SIZE);
        numberOfPoints = new Integer("100");

        startArrayOfPoints = GeneratePoints.generateList(100);
        arrayOfFixedPositionsOfPoints = FixPoints.fixPositions(startArrayOfPoints, 0, 0, 0);
    }

    public void paintComponent(Graphics g) {
        g2d = (Graphics2D) g;
        super.paintComponent(g2d);

        g2d.setColor(Color.BLUE);
        System.out.println("Added g2d");    // BRISATI
        // BEGIN TEST  - BRISATI
        for (Point3D point : arrayOfFixedPositionsOfPoints) {
            System.out.println(point.toString());
            drawPoint(g2d, point.getX(), point.getY());
        }
        // END TEST
    }

    public static void drawPoint(Graphics2D g, int x, int y) {
        System.out.println("DrawPoint: X=" + x + ", Y=" + y);
        x = x - POINT_SIZE;
        y = y - POINT_SIZE;
        g.fillOval(x, y, POINT_SIZE, POINT_SIZE);
    }
}
