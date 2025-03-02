import java.awt.*;
import java.awt.geom.Ellipse2D;

public class ClasaNorVlad {
    public ClasaNorVlad() {

    }

    public void desenareNor(Graphics2D g2D){
        Ellipse2D.Double e1 = new Ellipse2D.Double(200, 85, 100, 100);
        Ellipse2D.Double e2 = new Ellipse2D.Double(235, 55, 180, 140);
        Ellipse2D.Double e3 = new Ellipse2D.Double(350, 90, 90, 90);
        Ellipse2D.Double e4 = new Ellipse2D.Double(380, 75, 30, 30);

        g2D.setColor(Color.WHITE);
        g2D.setStroke(new BasicStroke(10));
        g2D.draw(e1);
        g2D.draw(e2);
        g2D.draw(e3);
        g2D.draw(e4);

        g2D.setColor(Color.BLUE);
        g2D.fill(e1);
        g2D.fill(e2);
        g2D.fill(e3);
        g2D.fill(e4);
    }
}
