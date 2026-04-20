import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
public class PartB extends JFrame {
    public PartB() {
        setTitle("Animated Image");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        add(new Board());
        pack();
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PartB app = new PartB();
            app.setVisible(true);
        });
    }
}
class Board extends JPanel implements ActionListener {
    private static final int BOARD_WIDTH  = 720;
    private static final int BOARD_HEIGHT = 720;
    private static final int IMG_DRAW_SIZE = 100;
    private double x = 0;
    private double y = 0;
    private double dx = 1;
    private double dy = 1;
    private double angleDegrees = 0;
    private BufferedImage image;
    private Timer timer;
    public Board() {
        setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
        setBackground(Color.BLACK);
        try {
            image = ImageIO.read(new File("andy.png"));
        } catch (IOException e) {
            System.err.println("Could not load image: " + e.getMessage());
        }
        timer = new Timer(25, this);
        timer.start();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        x += dx;
        y += dy;
        angleDegrees += 5.0;
        if (angleDegrees >= 360) angleDegrees -= 360;
        if (x > BOARD_WIDTH)  x = 0;
        if (x < 0)            x = BOARD_WIDTH;
        if (y > BOARD_HEIGHT) y = 0;
        if (y < 0)            y = BOARD_HEIGHT;
        repaint();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image == null) return;
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                             RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                             RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        AffineTransform at = new AffineTransform();
        at.translate(x, y);
        at.rotate(Math.toRadians(angleDegrees));
        at.translate(-IMG_DRAW_SIZE / 2.0, -IMG_DRAW_SIZE / 2.0);
        at.scale((double) IMG_DRAW_SIZE / image.getWidth(),
                 (double) IMG_DRAW_SIZE / image.getHeight());
        g2d.drawImage(image, at, this);
    }
}