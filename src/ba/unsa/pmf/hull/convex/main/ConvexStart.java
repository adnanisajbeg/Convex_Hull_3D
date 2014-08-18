package ba.unsa.pmf.hull.convex.main;

import javax.swing.*;

/**
 * Created by Adnan on 17.8.2014.
 */
public class ConvexStart {
    public static void main(String[] args) {
        IntroFrame introFrame = new IntroFrame();
        introFrame.setTitle("Convex Hull 3D");
        introFrame.setSize(800, 600);
        introFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        introFrame.setVisible(true);
    }
}
