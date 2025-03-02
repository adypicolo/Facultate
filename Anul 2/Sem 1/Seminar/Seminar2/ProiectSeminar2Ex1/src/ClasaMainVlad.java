import javax.swing.*;

public class ClasaMainVlad {
    public static void main(String[] args) {
        int w = 1200, h = 900;
        JFrame f = new JFrame();

        ClasaPanzaVlad pm = new ClasaPanzaVlad(w,h);
        f.add(pm);

        f.setSize(w,h);
        f.setTitle("Fereastra grafica Vlad");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

    }
}
