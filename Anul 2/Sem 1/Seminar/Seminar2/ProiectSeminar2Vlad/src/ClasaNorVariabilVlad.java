import java.awt.*;
import java.awt.geom.Ellipse2D;

public class ClasaNorVariabilVlad {
    private double x, y, size;
    private Color colorNor, colorContur;
    private int grosimeContur;

    public ClasaNorVariabilVlad(double x, double y, double size, Color colorNor, Color colorContur, int grosimeContur) {
        this.x = x; this.y = y; this.size = size;
        this.colorNor = colorNor; this.colorContur = colorContur;
        this.grosimeContur = grosimeContur;
    }

    public void desenareNorVariabil(Graphics2D g2D) {
        Ellipse2D.Double e1 = new Ellipse2D.Double(x, y, size, size);
        Ellipse2D.Double e2 = new Ellipse2D.Double(x+0.35*size, y-0.3*size, 1.8*size, 1.4*size);
        Ellipse2D.Double e3 = new Ellipse2D.Double(x+1.5*size, y+0.05*size, 0.9*size, 0.9*size);
        Ellipse2D.Double e4 = new Ellipse2D.Double(x+1.8*size, y-0.1*size, 0.3*size, 0.3*size);

        g2D.setColor(colorContur);
        g2D.setStroke(new BasicStroke(grosimeContur));
        g2D.draw(e1);
        g2D.draw(e2);
        g2D.draw(e3);
        g2D.draw(e4);

        g2D.setColor(colorNor);
        g2D.fill(e1);
        g2D.fill(e2);
        g2D.fill(e3);
        g2D.fill(e4);
    }
}
