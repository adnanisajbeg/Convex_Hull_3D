package ba.unsa.pmf.hull.convex.components;

import ba.unsa.pmf.hull.convex.logic.GeneratePoints;
import ba.unsa.pmf.hull.convex.logic.Intersection;
import ba.unsa.pmf.hull.convex.logic.RotatePoints;
import ba.unsa.pmf.hull.convex.logic.model.Point3D;
import ba.unsa.pmf.hull.convex.logic.model.Triangle;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Adnan on 17.8.2014.
 */
public class PicturePanel extends JPanel implements ActionListener {
    public static final Integer POINT_SIZE = new Integer("5");
    public static final Integer PANEL_SIZE = new Integer("600");
    private Integer numberOfPoints = new Integer("10"); // DEFAULT FOR TESTING
    private static Graphics2D g2d;
    private ArrayList<Point3D> arrayOfPoints;
    private ArrayList<Triangle> arrayOfTriangles;
    private int counterOfRotations = 0;
    private int positionOfLastPoint = 0;

    JTextField speedX;
    JTextField speedY;
    JTextField speedZ;

    private static int rotationSpeedX = 0;
    private static int rotationSpeedY = 0;
    private static int rotationSpeedZ = 0;

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
        numberOfPoints = IntroFrame.POINTS_NUMBER;

        speedX = new JTextField("0", 3);
        speedY = new JTextField("0", 3);
        speedZ = new JTextField("0", 3);

        speedX.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                check();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                check();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                check();
            }

            public void check() {
                String text = speedX.getText();

                if (text == null || text.isEmpty()) {
                    rotationSpeedX = 0;
                } else {
                    rotationSpeedX = getNumber(text, "X");
                }
            }
        });

        speedY.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                check();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                check();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                check();
            }

            public void check() {
                String text = speedY.getText();

                if (text == null || text.isEmpty()) {
                    rotationSpeedY = 0;
                } else {
                    rotationSpeedY = getNumber(text, "Y");
                }
            }
        });

        speedZ.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                check();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                check();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                check();
            }

            public void check() {
                String text = speedZ.getText();

                if (text == null || text.isEmpty()) {
                    rotationSpeedZ = 0;
                } else {
                    rotationSpeedZ = getNumber(text, "Z");
                }
            }
        });


        speedX.setVisible(true);
        speedY.setVisible(true);
        speedZ.setVisible(true);

        arrayOfPoints = GeneratePoints.generateList(numberOfPoints);

        arrayOfTriangles = new ArrayList<Triangle>(numberOfPoints - 3); // TODO: find the max number of triangles

        this.add(speedX);
        this.add(speedY);
        this.add(speedZ);
    }

    public void paintComponent(Graphics g) {
        g2d = (Graphics2D) g;
        super.paintComponent(g2d);

        g2d.setColor(Color.BLUE);

        for (Point3D point : arrayOfPoints) {
            drawPoint(g2d, point.getRotatedX().intValue(), point.getRotatedY().intValue());
        }

        for (Triangle triangle : arrayOfTriangles) {
            drawTriangle(g2d, triangle);
        }
    }

    public static void drawPoint(Graphics2D g, int x, int y) {
        x = ((x / 2) + 250) - POINT_SIZE;
        y = ((y / 2) + 250) - POINT_SIZE;
        g.fillOval(x, y, POINT_SIZE , POINT_SIZE);
    }

    public static void drawTriangle(Graphics2D g, Triangle triangle) {
        int[] xPoints = new int[3];
        int[] yPoints = new int[3];
        xPoints[0] = ((triangle.getPoint1().getRotatedX().intValue() / 2) + 250) - POINT_SIZE / 2;
        xPoints[1] = ((triangle.getPoint2().getRotatedX().intValue() / 2) + 250) - POINT_SIZE / 2;
        xPoints[2] = ((triangle.getPoint3().getRotatedX().intValue() / 2) + 250) - POINT_SIZE / 2;
        yPoints[0] = ((triangle.getPoint1().getRotatedY().intValue() / 2) + 250) - POINT_SIZE / 2;
        yPoints[1] = ((triangle.getPoint2().getRotatedY().intValue() / 2) + 250) - POINT_SIZE / 2;
        yPoints[2] = ((triangle.getPoint3().getRotatedY().intValue() / 2) + 250) - POINT_SIZE / 2;

        g2d.setColor(Color.BLACK);
        g.drawPolygon(xPoints, yPoints, 3);

        g2d.setColor(Color.GREEN);
        g.fillPolygon(xPoints, yPoints, 3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*if (e.getSource() == rotateButton) {
            doAction();
        }*/
    }

    private Integer getNumber(String text, String whichOne) {
        try {
            Integer number = new Integer(text);

            if (number.intValue() <= 0) {
                return new Integer("0");
            } else if (number.intValue() >= 5) {
                return new Integer("5");
            } else {
                return number;
            }
        } catch(Exception e) {
            // TODO: Write somewhere that it is not a number...
        }

        if (whichOne.equals("X")) {
            return rotationSpeedX;
        } else if (whichOne.equals("Y")) {
            return rotationSpeedY;
        } else {
            return rotationSpeedZ;
        }
    }

    public void doAction() {
        RotatePoints.rotate(arrayOfPoints, rotationSpeedX, rotationSpeedY, rotationSpeedZ);

        if (positionOfLastPoint == 0) {
            Triangle firstOne = new Triangle(arrayOfPoints.get(0), arrayOfPoints.get(1), arrayOfPoints.get(2));
            arrayOfTriangles.add(firstOne);
            positionOfLastPoint = 3;
        } else if (positionOfLastPoint == 3){
            positionOfLastPoint = 4;
            Triangle triangle = arrayOfTriangles.get(0);
            Point3D point = arrayOfPoints.get(positionOfLastPoint);

            Triangle triangle1 = new Triangle(triangle.getPoint1(), triangle.getPoint2(), point);
            triangle.setTriangle12(triangle1);
            arrayOfTriangles.add(triangle1);

            Triangle triangle2 = new Triangle(triangle.getPoint1(), triangle.getPoint3(), point);
            triangle.setTriangle13(triangle2);
            arrayOfTriangles.add(triangle2);

            Triangle triangle3 = new Triangle(triangle.getPoint2(), triangle.getPoint3(), point);
            triangle.setTriangle23(triangle3);
            arrayOfTriangles.add(triangle3);
        }
        else if (positionOfLastPoint < numberOfPoints - 1) {
            positionOfLastPoint++;

            Point3D nextPoint = arrayOfPoints.get(positionOfLastPoint);

            for (int i = 0; i < arrayOfTriangles.size(); i++) {
                boolean valid = true;
                Triangle triangle = arrayOfTriangles.get(i);
                Point3D middle = triangle.getMiddle();

                for (int j = 0; j < arrayOfTriangles.size(); j++) {
                    Triangle tempTriangle = arrayOfTriangles.get(j);
                        if (Intersection.checkIntersection(nextPoint, middle, tempTriangle)) {
                            valid = false;
                            break;
                        }
                }

                if (valid) {
                    // TODO: create new triangle
                }
            }

            // TODO: delete triangle insade
        }

        this.repaint();
    }
}
