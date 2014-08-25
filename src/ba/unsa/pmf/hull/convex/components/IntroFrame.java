package ba.unsa.pmf.hull.convex.components;

import ba.unsa.pmf.hull.convex.components.PicturePanel;
import ba.unsa.pmf.hull.convex.logic.Rotator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Adnan on 17.8.2014.
 */
public class IntroFrame extends JFrame implements ActionListener {
    private JPanel introPanel;
    JButton introButtonStart;
    PicturePanel picturePanel;

    public IntroFrame() {
        introPanel = new JPanel();
        introButtonStart = new JButton("Begin!");
        introButtonStart.addActionListener(this);
        introPanel.add(introButtonStart);
        this.add(introPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == introButtonStart) {
            introButtonStart.setVisible(false);
            introPanel.setVisible(false);
            addPicturePanel();
            startRotator();
        }
    }

    private void addPicturePanel() {
        picturePanel = new PicturePanel();
        this.add(picturePanel);
        this.repaint();
    }

    private void startRotator() {
        Rotator rotator = new Rotator();
        rotator.setPicturePanel(picturePanel);
        new Thread(rotator).start();
    }
}
