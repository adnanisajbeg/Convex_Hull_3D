package ba.unsa.pmf.hull.convex.components;

import ba.unsa.pmf.hull.convex.components.PicturePanel;
import ba.unsa.pmf.hull.convex.logic.Rotator;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Adnan on 17.8.2014.
 */
public class IntroFrame extends JFrame implements ActionListener {
    private JPanel introPanel;
    JButton introButtonStart;
    PicturePanel picturePanel;
    JTextField pointsNumbeJTextField;
    public static Integer POINTS_NUMBER = new Integer("50");

    public IntroFrame() {
        pointsNumbeJTextField = new JTextField(POINTS_NUMBER.toString(), 3);

        pointsNumbeJTextField.getDocument().addDocumentListener(new DocumentListener() {
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
                String text = pointsNumbeJTextField.getText();

                if (text == null || text.isEmpty()) {
                    POINTS_NUMBER = 50;
                } else {
                    POINTS_NUMBER = getNumber(text);
                    System.out.println(POINTS_NUMBER);  // BRISATI
                }
            }
        });

        introPanel = new JPanel();
        introButtonStart = new JButton("Begin!");
        introButtonStart.addActionListener(this);
        introPanel.add(introButtonStart);
        introPanel.add(pointsNumbeJTextField);
        this.add(introPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == introButtonStart) {
            POINTS_NUMBER = getNumber(pointsNumbeJTextField.getText());
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

    private Integer getNumber(String text) {
        try {
            Integer number = new Integer(text);

            if (number <= 3) {
                return new Integer("3");
            }
            else if (number >= 100) {
                return new Integer ("100");
            }
        } catch (Exception e) {
            System.out.println("Wrong number");   // TODO: popup
        }

        return new Integer("50");
    }
}
