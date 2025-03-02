import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
public class ClasaPanzaVlad extends JComponent {
    private int width, height;

    public ClasaPanzaVlad(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;

        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2D.setRenderingHints(rh);

        Rectangle2D.Double bgr = new Rectangle2D.Double(0, 0, width, height);
        g2D.setColor(Color.CYAN);
        g2D.fill(bgr);


        /*Ellipse2D.Double e = new Ellipse2D.Double(200,75,100,200);
        g2D.setColor(Color.RED);
        g2D.fill(e);
        g2D.setColor(Color.BLUE);
        g2D.setStroke (new BasicStroke(5));
        g2D.draw(e);

        Ellipse2D.Double ep = new Ellipse2D.Double(400,75,100,200);
        g2D.setColor(Color.BLUE);
        g2D.setStroke (new BasicStroke(6));
        g2D.draw(ep);
        g2D.setColor(Color.RED);
        g2D.fill(ep);

        Line2D.Double line = new Line2D.Double(100,250,300,75);
        g2D.setColor(Color.BLACK);
        g2D.setStroke (new BasicStroke( 3));
        g2D.draw(line);*/

        Ellipse2D.Double ellipse1 = new Ellipse2D.Double(200, 95, 100, 100); // (250, 225), semi-axes 50, 50
        Ellipse2D.Double ellipse2 = new Ellipse2D.Double(235, 55, 180, 140); // (325, 125), semi-axes 90, 70
        Ellipse2D.Double ellipse3 = new Ellipse2D.Double(350, 105, 90, 90);   // (395, 135), semi-axes 45, 45
        Ellipse2D.Double ellipse4 = new Ellipse2D.Double(380, 80, 30, 30);    // (395, 95), semi-axes 15, 15

        g2D.setColor(Color.BLUE);
        g2D.fill(ellipse1);
        g2D.fill(ellipse2);
        g2D.fill(ellipse3);
        g2D.fill(ellipse4);

        //g2D.setColor(Color.WHITE);
        //g2D.setStroke(new BasicStroke(5));
        g2D.draw(ellipse1);
        g2D.draw(ellipse2);
        g2D.draw(ellipse3);
        g2D.draw(ellipse4);


        /*
        AffineTransform oldTransform = g2D.getTransform();
        g2D.rotate(Math.toRadians(300), 400, 400);
        Ellipse2D.Double frunza = new Ellipse2D.Double(400, 400, 45, 170);
        g2D.setColor(Color.GREEN);
        g2D.fill(frunza);
        g2D.setColor(Color.BLACK);
        g2D.setStroke(new BasicStroke(1));
        g2D.draw(frunza);
        g2D.setTransform(oldTransform);

        Ellipse2D.Double p1 = new Ellipse2D.Double(340, 390, 80, 110);
        g2D.setColor(Color.RED);
        g2D.fill(p1);
        g2D.setColor(Color.BLACK);
        g2D.setStroke(new BasicStroke(1));
        g2D.draw(p1);

        oldTransform = g2D.getTransform();
        g2D.rotate(Math.toRadians(55), 355, 390);
        Ellipse2D.Double p2 = new Ellipse2D.Double(355 - 25, 390 - 20, 80, 110);
        g2D.setColor(Color.RED);
        g2D.fill(p2);
        g2D.setColor(Color.BLACK);
        g2D.setStroke(new BasicStroke(1));
        g2D.draw(p2);
        g2D.setTransform(oldTransform);

        oldTransform = g2D.getTransform();
        g2D.rotate(Math.toRadians(120), 355, 390);
        Ellipse2D.Double p3 = new Ellipse2D.Double(355 - 45, 390 - 20, 80, 110);
        g2D.setColor(Color.RED);
        g2D.fill(p3);
        g2D.setColor(Color.BLACK);
        g2D.setStroke(new BasicStroke(1));
        g2D.draw(p3);
        g2D.setTransform(oldTransform);

        oldTransform = g2D.getTransform();
        g2D.rotate(Math.toRadians(180), 355, 390);
        Ellipse2D.Double p4 = new Ellipse2D.Double(350-65, 390, 80, 110);
        g2D.setColor(Color.RED);
        g2D.fill(p4);
        g2D.setColor(Color.BLACK);
        g2D.setStroke(new BasicStroke(1));
        g2D.draw(p4);
        g2D.setTransform(oldTransform);


        oldTransform = g2D.getTransform();
        g2D.rotate(Math.toRadians(235), 355, 390);
        Ellipse2D.Double p5 = new Ellipse2D.Double(285, 410, 80, 110);
        g2D.setColor(Color.RED);
        g2D.fill(p5);
        g2D.setColor(Color.BLACK);
        g2D.setStroke(new BasicStroke(1));
        g2D.draw(p5);
        g2D.setTransform(oldTransform);

        oldTransform = g2D.getTransform();
        g2D.rotate(Math.toRadians(305), 355, 390);
        Ellipse2D.Double p6 = new Ellipse2D.Double(330, 420, 80, 110);
        g2D.setColor(Color.RED);
        g2D.fill(p6);
        g2D.setColor(Color.BLACK);
        g2D.setStroke(new BasicStroke(1));
        g2D.draw(p6);
        g2D.setTransform(oldTransform);


        Ellipse2D.Double centru = new Ellipse2D.Double(350, 350, 70, 70);
        g2D.setColor(Color.YELLOW);
        g2D.fill(centru);
        g2D.setColor(Color.BLACK);
        g2D.setStroke(new BasicStroke(1));
        g2D.draw(centru);
        */

    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Rotated Leaf Example");
        ClasaPanzaVlad canvas = new ClasaPanzaVlad(400, 400);
        frame.add(canvas);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}