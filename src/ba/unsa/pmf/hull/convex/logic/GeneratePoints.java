package ba.unsa.pmf.hull.convex.logic;

import ba.unsa.pmf.hull.convex.components.PicturePanel;
import ba.unsa.pmf.hull.convex.logic.model.Point3D;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Adnan on 17.8.2014.
 */
public class GeneratePoints {
    public static final Integer MAX_NUMBER_OF_POINTS = new Integer("100");

    private static Random rn = new Random();

    public static ArrayList<Point3D> generateList(int numberOfPoints) {
        if (numberOfPoints > MAX_NUMBER_OF_POINTS) {
            return null;
        }

        ArrayList<Point3D> listOfPoints = new ArrayList<Point3D>(numberOfPoints);

        Point3D temp;
        for (int i = 0; i < numberOfPoints; i++) {
            temp = new Point3D(rn.nextInt(PicturePanel.PANEL_SIZE), rn.nextInt(PicturePanel.PANEL_SIZE), rn.nextInt(PicturePanel.PANEL_SIZE));

            for (int j = 0; j < i; j++) {
                if (Point3D.distanceFromPoint(temp, listOfPoints.get(j)) < PicturePanel.POINT_SIZE) {
                    i--;
                    continue;
                }
            }

            listOfPoints.add(i, temp);
        }

        return listOfPoints;
    }
}
