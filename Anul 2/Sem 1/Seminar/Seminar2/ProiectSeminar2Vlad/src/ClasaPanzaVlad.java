import java.awt.*;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

public class ClasaPanzaVlad extends JPanel {  // Extend JPanel
    private int width, height;
    private ClasaNorVariabilVlad nor1, nor2, nor3;

    public ClasaPanzaVlad(int width, int height) {
        this.width = width;
        this.height = height;
        nor1 = new ClasaNorVariabilVlad(200, 100, 50, Color.BLUE, Color.GRAY, 10);
        nor2 = new ClasaNorVariabilVlad(500, 100, 150, Color.RED, Color.WHITE, 15);
        nor3 = new ClasaNorVariabilVlad(350, 400, 120, Color.GREEN, Color.YELLOW, 7);

        // Set preferred size for the panel based on the input width and height
        setPreferredSize(new Dimension(width, height));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Ensure proper background painting
        Graphics2D g2D = (Graphics2D) g;

        // Set anti-aliasing for smoother rendering
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2D.setRenderingHints(rh);

        // Draw background
        Rectangle2D.Double fond = new Rectangle2D.Double(0, 0, width, height);
        g2D.setColor(Color.CYAN);
        g2D.fill(fond);

        // Draw the clouds (assuming ClasaNorVariabilVlad has the method desenareNorVariabil)
        nor1.desenareNorVariabil(g2D);
        nor2.desenareNorVariabil(g2D);
        nor3.desenareNorVariabil(g2D);
    }
}
