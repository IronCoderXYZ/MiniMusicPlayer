import java.awt.*;
import javax.swing.*;
import javax.sound.midi.*;

public class MyDrawPanel extends JPanel implements ControllerEventListener {
    boolean message = false;

    public void controlChange(ShortMessage event) {
        message = true;
        repaint();
    }

    public void paintComponent(Graphics g) {
        if (message) {
            Graphics2D g2 = (Graphics2D) g;

            int red = (int) (Math.random() * 250);
            int green = (int) (Math.random() * 250);
            int blue = (int) (Math.random() * 250);

            int x = (int) ((Math.random() * 40) + 10);
            int y = (int) ((Math.random() * 40) + 10);
            int width = (int) ((Math.random() * 120) + 10);
            int height = (int) ((Math.random() * 120) + 10);

            g.setColor(new Color(red, green, blue));
            g.fillRect(x, y, width, height);

            message = false;
        }
    }
}
