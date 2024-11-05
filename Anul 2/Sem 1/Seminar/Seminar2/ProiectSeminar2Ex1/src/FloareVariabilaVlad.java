import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

public class FloareVariabilaVlad {
    private int x, y, size;
    private Color petalColor, outlineColor;
    private double rotation; // Unghiul de rotație al florii

    public FloareVariabilaVlad(int x, int y, int size, Color petalColor, Color outlineColor, double rotation) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.petalColor = petalColor;
        this.outlineColor = outlineColor;
        this.rotation = rotation;
    }

    public void desenareFloare(Graphics2D g2D) {
        AffineTransform oldTransform = g2D.getTransform();  // Salvăm transformările inițiale

        // Aplicăm rotația pentru întreaga floare
        g2D.rotate(Math.toRadians(rotation), x, y);

        // Desenare frunză
        AffineTransform frunzaTransform = g2D.getTransform();
        g2D.rotate(Math.toRadians(300), x, y);
        Ellipse2D.Double frunza = new Ellipse2D.Double(x, y, size * 0.3, size * 1.5);
        g2D.setColor(Color.GREEN);
        g2D.fill(frunza);
        g2D.setColor(outlineColor);
        g2D.setStroke(new BasicStroke(1));
        g2D.draw(frunza);
        g2D.setTransform(frunzaTransform);  // Resetăm transformarea după frunză

        // Desenare petale
        for (int i = 0; i < 6; i++) {
            AffineTransform petalaTransform = g2D.getTransform();
            g2D.rotate(Math.toRadians(i * 60), x, y);
            Ellipse2D.Double petala = new Ellipse2D.Double(x - size * 0.4, y - size * 0.7, size * 0.8, size * 1.1);
            g2D.setColor(petalColor);
            g2D.fill(petala);
            g2D.setColor(outlineColor);
            g2D.draw(petala);
            g2D.setTransform(petalaTransform);  // Resetăm transformarea după fiecare petală
        }

        // Desenare centru floare
        Ellipse2D.Double centru = new Ellipse2D.Double(x - size * 0.35, y - size * 0.35, size * 0.7, size * 0.7);
        g2D.setColor(Color.YELLOW);
        g2D.fill(centru);
        g2D.setColor(outlineColor);
        g2D.draw(centru);

        // Resetăm transformările inițiale pentru a nu afecta alte desene
        g2D.setTransform(oldTransform);
    }

    // Metode pentru a schimba poziția și caracteristicile florii
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setColors(Color petalColor, Color outlineColor) {
        this.petalColor = petalColor;
        this.outlineColor = outlineColor;
    }

    public void setRotation(double rotation) {
        this.rotation = rotation;
    }
}
