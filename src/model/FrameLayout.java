package model;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author TinDev
 */
public class FrameLayout {
    public static void setFrameLayout(JFrame f, int width, int height, String title) {
        f.setVisible(true);
        f.setTitle(title);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setSize(width, height);
        f.setLocationRelativeTo(null);
    }
    
    public static void setPanelToFrame(JFrame f, JPanel p, int width, int height, int x, int y) {
        p.setSize(width, height);
        f.getContentPane().add(p);
        p.setLocation(x, y);
    }
}
