import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
public class PartA extends JFrame {
    public PartA() {
        setTitle("Google Earth POV");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        add(new Board());
        pack();
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PartA app = new PartA();
            app.setVisible(true);
        });
    }
}
class Board extends JPanel {
    private static final int BOARD_WIDTH  = 1000;
    private static final int BOARD_HEIGHT = 1000;
    private BufferedImage image;
    public Board() {
        setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
        setBackground(Color.CYAN);
        try {
            image = ImageIO.read(new File("kids.png"));
        } catch (IOException e) {
            System.err.println("Could not load image: " + e.getMessage());
        }
    }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            if (image != null) {
                g2d.drawImage(image, 0, 0, this);
            }
        }
    }
