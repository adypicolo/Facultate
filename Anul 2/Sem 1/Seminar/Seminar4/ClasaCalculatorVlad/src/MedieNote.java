import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.DefaultListModel;

public class MedieNote {
    private JPanel mainPanel;
    private JList<Integer> jListNOTE;
    private JButton jButtonOK;
    private JButton jButtonMEDIE;
    private JButton jButtonRESET;
    private JButton jButtonEXIT;
    private JTextField jTextFieldNOTE;
    private JTextField jTextFieldMEDIE;
    private JLabel jLabelTITLU;
    private JLabel jLabelNOTE;
    private JLabel jLabelMEDIE;
    private JLabel jLabelCALIFICATIV;
    private JRadioButton jRadioButtonCALIFICATIV;

    private DefaultListModel<Integer> number;
    private int total;
    private int numarNote;

    public MedieNote() {
        initializeComponents();

        jButtonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int nota = Integer.parseInt(jTextFieldNOTE.getText());
                    if (nota < 0 || nota > 100) {
                        JOptionPane.showMessageDialog(mainPanel, "Nota nu este validă (0-100).", "Eroare", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    number.addElement(nota);
                    jListNOTE.setModel(number);
                    total += nota;
                    numarNote++;
                    jTextFieldNOTE.setText("");
                    jTextFieldNOTE.requestFocus();

                    if (number.size() == 10) {
                        jTextFieldNOTE.setEnabled(false);
                        jButtonOK.setEnabled(false);
                        jButtonMEDIE.setEnabled(true);
                        jRadioButtonCALIFICATIV.setEnabled(true);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(mainPanel, "Introduceți o valoare numerică.", "Eroare", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        jButtonMEDIE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double medie = (double) total / numarNote;
                String calificativ;

                if (medie >= 95) calificativ = "EXCELENT";
                else if (medie >= 85) calificativ = "FOARTE BINE";
                else if (medie >= 75) calificativ = "BINE";
                else if (medie >= 60) calificativ = "SATISFACATOR";
                else if (medie >= 45) calificativ = "SUFICIENT";
                else calificativ = "INSUFICIENT";

                jTextFieldMEDIE.setText(String.format("%.2f", medie));
                jLabelCALIFICATIV.setText(calificativ);
                jButtonMEDIE.setEnabled(false);
                jRadioButtonCALIFICATIV.setEnabled(true);
            }
        });

        jButtonRESET.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                number.clear();
                jListNOTE.setModel(number);
                total = 0;
                numarNote = 0;
                jTextFieldNOTE.setEnabled(true);
                jButtonOK.setEnabled(true);
                jButtonMEDIE.setEnabled(false);
                jRadioButtonCALIFICATIV.setEnabled(false);
                jTextFieldMEDIE.setText("");
                jLabelCALIFICATIV.setText("");
            }
        });

        jButtonEXIT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(mainPanel, "Sigur doriți să ieșiți?", "Confirmare", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        jTextFieldNOTE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
                    Toolkit.getDefaultToolkit().beep();
                    evt.consume();
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Exercițiul 3 - Media Note");
        MedieNote medieNote = new MedieNote();
        frame.setContentPane(medieNote.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 400);
        frame.setResizable(true);
        frame.setVisible(true);
    }

    private void initializeComponents() {
        mainPanel = new JPanel(null);

        jLabelTITLU = createLabel("CALCUL MEDIE NOTE", new Font("Times New Roman", Font.BOLD, 24), new Color(0, 0, 255));
        jLabelTITLU.setBounds(150, 10, 300, 30);
        mainPanel.add(jLabelTITLU);

        jLabelNOTE = createLabel("INTRODU NOTE:", new Font("Times New Roman", Font.BOLD, 14), Color.BLACK);
        jLabelNOTE.setBounds(20, 50, 150, 20);
        mainPanel.add(jLabelNOTE);

        jTextFieldNOTE = new JTextField();
        jTextFieldNOTE.setFont(new Font("Times New Roman", Font.BOLD, 14));
        jTextFieldNOTE.setBounds(200, 50, 150, 25);
        mainPanel.add(jTextFieldNOTE);

        jLabelMEDIE = createLabel("CALCUL MEDIE:", new Font("Times New Roman", Font.BOLD, 14), Color.BLACK);
        jLabelMEDIE.setBounds(20, 100, 150, 20);
        mainPanel.add(jLabelMEDIE);

        jTextFieldMEDIE = new JTextField();
        jTextFieldMEDIE.setFont(new Font("Times New Roman", Font.BOLD, 14));
        jTextFieldMEDIE.setBounds(200, 100, 150, 25);
        jTextFieldMEDIE.setEditable(false);
        mainPanel.add(jTextFieldMEDIE);

        jLabelCALIFICATIV = createLabel("CALIFICATIV", new Font("Times New Roman", Font.BOLD, 14), Color.BLACK);
        jLabelCALIFICATIV.setBounds(20, 150, 150, 20);
        mainPanel.add(jLabelCALIFICATIV);

        jRadioButtonCALIFICATIV = new JRadioButton("Afișează calificativ");
        jRadioButtonCALIFICATIV.setBounds(200, 150, 200, 25);
        jRadioButtonCALIFICATIV.setEnabled(false);
        mainPanel.add(jRadioButtonCALIFICATIV);

        jButtonOK = createButton("OK", 400, 50);
        mainPanel.add(jButtonOK);

        jButtonMEDIE = createButton("MEDIE", 400, 100);
        jButtonMEDIE.setEnabled(false);
        mainPanel.add(jButtonMEDIE);

        jButtonRESET = createButton("RESET", 400, 150);
        mainPanel.add(jButtonRESET);

        jButtonEXIT = createButton("EXIT", 400, 200);
        mainPanel.add(jButtonEXIT);

        number = new DefaultListModel<>();
        jListNOTE = new JList<>(number);
        JScrollPane scrollPane = new JScrollPane(jListNOTE);
        scrollPane.setBounds(600, 50, 150, 200);
        mainPanel.add(scrollPane);
    }

    private JLabel createLabel(String text, Font font, Color color) {
        JLabel label = new JLabel(text);
        label.setFont(font);
        label.setForeground(color);
        return label;
    }

    private JButton createButton(String text, int x, int y) {
        JButton button = new JButton(text);
        button.setFont(new Font("Times New Roman", Font.BOLD, 24));
        button.setBounds(x, y, 150, 40);
        return button;
    }
}
