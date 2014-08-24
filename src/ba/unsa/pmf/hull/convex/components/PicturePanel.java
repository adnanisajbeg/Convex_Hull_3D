package ba.unsa.pmf.hull.convex.components;

import ba.unsa.pmf.hull.convex.logic.FixPoints;
import ba.unsa.pmf.hull.convex.logic.GeneratePoints;
import ba.unsa.pmf.hull.convex.logic.RotatePoints;
import ba.unsa.pmf.hull.convex.logic.model.Point3D;
import javafx.scene.transform.Rotate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Adnan on 17.8.2014.
 */
public class PicturePanel extends JPanel implements ActionListener {
    public static final Integer POINT_SIZE = new Integer("5");
    public static final Integer PANEL_SIZE = new Integer("200");
    private Integer numberOfPoints = new Integer("10"); // DEFAULT FOR TESTING
    private static Graphics2D g2d;
    private ArrayList<Point3D> startArrayOfPoints;
    private ArrayList<Point3D> arrayOfFixedPositionsOfPoints;
    JButton rotateButton;
    private int counterOfRotations = 0;

    private static int rotationSpeedX = 1;
    private static int rotationSpeedY = 1;
    private static int rotationSpeedZ = 1;

    public static void setRotationSpeedX(int rotationSpeedX) {
        PicturePanel.rotationSpeedX = rotationSpeedX;
    }

    public static void setRotationSpeedY(int rotationSpeedY) {
        PicturePanel.rotationSpeedY = rotationSpeedY;
    }

    public static void setRotationSpeedZ(int rotationSpeedZ) {
        PicturePanel.rotationSpeedZ = rotationSpeedZ;
    }

    public Integer getNumberOfPoints() {
        return numberOfPoints;
    }

    public void setNumberOfPoints(Integer numberOfPoints) {
        this.numberOfPoints = numberOfPoints;
    }

    public PicturePanel() {
        this.setVisible(true);
        this.setSize(PANEL_SIZE, PANEL_SIZE);
        numberOfPoints = new Integer("30");

        startArrayOfPoints = GeneratePoints.generateList(numberOfPoints);

        rotateButton = new JButton("Rotate!");
        rotateButton.addActionListener(this);
        this.add(rotateButton);

        arrayOfFixedPositionsOfPoints = startArrayOfPoints;
    }

    public void paintComponent(Graphics g) {
        g2d = (Graphics2D) g;
        super.paintComponent(g2d);

        g2d.setColor(Color.BLUE);


        System.out.println("================");
        for (Point3D point : arrayOfFixedPositionsOfPoints) {
            System.out.println(point.toString());
            drawPoint(g2d, point.getX().intValue(), point.getY().intValue());
        }
    }

    public static void drawPoint(Graphics2D g, int x, int y) {
        x = ((x / 2) + 250) - POINT_SIZE;
        y = ((y / 2) + 250) - POINT_SIZE;
        g.fillOval(x, y, POINT_SIZE , POINT_SIZE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == rotateButton) {
            // TEST
            arrayOfFixedPositionsOfPoints = RotatePoints.rotate(arrayOfFixedPositionsOfPoints, rotationSpeedX, rotationSpeedY, rotationSpeedZ);
            System.out.println("rotation nr." + ++counterOfRotations);
            this.repaint();
            // END TEST
            /*arrayOfFixedPositionsOfPoints = RotatePoints.rotate(arrayOfFixedPositionsOfPoints, 0, rotationSpeedY, 0);
            this.repaint();*/
        }
    }

    public void doAction() {
        arrayOfFixedPositionsOfPoints = RotatePoints.rotate(arrayOfFixedPositionsOfPoints, rotationSpeedX, rotationSpeedY, rotationSpeedZ);
        this.repaint();
    }
}
