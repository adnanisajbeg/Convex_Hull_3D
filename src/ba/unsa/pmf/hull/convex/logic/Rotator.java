package ba.unsa.pmf.hull.convex.logic;

import ba.unsa.pmf.hull.convex.components.PicturePanel;

/**
 * Created by Adnan on 24.8.2014.
 */
public class Rotator implements Runnable {
    private PicturePanel picturePanel;

    public void setPicturePanel(PicturePanel picturePanel) {
        this.picturePanel = picturePanel;
    }

    @Override
    public void run() {
        while(true) {
            picturePanel.doAction();

            try {
                Thread.sleep(50);
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        }
    }
}
