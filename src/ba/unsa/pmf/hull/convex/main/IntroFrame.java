package ba.unsa.pmf.hull.convex.main;

import ba.unsa.pmf.hull.convex.components.PicturePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.text.AttributedCharacterIterator;
import java.util.Map;

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
        }
    }

    private void addPicturePanel() {
        picturePanel = new PicturePanel();
        this.add(picturePanel);
        this.repaint();
    }
}
