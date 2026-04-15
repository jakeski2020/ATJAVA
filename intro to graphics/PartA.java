import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
public class PartA extends JFrame {
    public PartA() {
        setTitle("Square");
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
    private static final int BOARD_WIDTH  = 350;
    private static final int BOARD_HEIGHT = 350;
    private static final int RECT_WIDTH   = 150;
    private static final int RECT_HEIGHT  = 150;
    private static final double ROTATION_RADIANS = Math.toRadians(22.5);
    public Board() {
        setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
        setBackground(Color.CYAN);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                             RenderingHints.VALUE_ANTIALIAS_ON);
        double cx = getWidth()  / 2.0;
        double cy = getHeight() / 2.0;
        Rectangle2D rect = new Rectangle2D.Double(0, 0, RECT_WIDTH, RECT_HEIGHT);
        AffineTransform translateToCenter = new AffineTransform();
        translateToCenter.translate(cx - RECT_WIDTH / 2.0, cy - RECT_HEIGHT / 2.0);
        AffineTransform rotateCW = new AffineTransform();
        rotateCW.rotate(-ROTATION_RADIANS, cx, cy);
        AffineTransform combined = new AffineTransform(rotateCW);
        combined.concatenate(translateToCenter);
        Shape transformed = combined.createTransformedShape(rect);
        g2d.setColor(Color.PINK);
        g2d.fill(transformed);
    }
}