import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class ClasaPanzaVlad extends JPanel {
    private int width, height;
    private FloareVariabilaVlad floare1, floare2, floare3, floare4;

    public ClasaPanzaVlad(int width, int height) {
        this.width = width;
        this.height = height;

        // Poziții fixe pe orizontală pentru flori, pe același rând
        floare1 = new FloareVariabilaVlad(150, height / 2, 100, Color.RED, Color.BLACK, 0);
        floare2 = new FloareVariabilaVlad(350, height / 2, 120, Color.BLUE, Color.BLACK, 0);
        floare3 = new FloareVariabilaVlad(650, height / 2, 100, Color.MAGENTA, Color.BLACK, 0);
        floare4 = new FloareVariabilaVlad(850, height / 2, 120, Color.ORANGE, Color.BLACK, 0);

        setPreferredSize(new Dimension(width, height));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;

        // Anti-aliasing pentru desenare lină
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2D.setRenderingHints(rh);

        // Fundal negru
        Rectangle2D.Double background = new Rectangle2D.Double(0, 0, width, height);
        g2D.setColor(Color.BLACK);
        g2D.fill(background);

        // Desenare flori în linie orizontală
        floare1.desenareFloare(g2D);
        floare2.desenareFloare(g2D);
        floare3.desenareFloare(g2D);
        floare4.desenareFloare(g2D);
    }
}
