package ba.unsa.pmf.hull.convex.main;

import ba.unsa.pmf.hull.convex.components.IntroFrame;

import javax.swing.*;

/**
 * Created by Adnan on 17.8.2014.
 */
public class ConvexStart {
    public static void main(String[] args) {
        IntroFrame introFrame = new IntroFrame();
        introFrame.setTitle("Convex Hull 3D");
        introFrame.setSize(600, 600);
        introFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        introFrame.setVisible(true);
    }
}
