import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClasaCalculatorVlad {
    private JPanel mainPanel;
    private JPanel topPanel;
    private JPanel bottomPanel;
    private JLabel termen1Label;
    private JLabel termen2Label;
    private JLabel rezultatLabel;
    private JTextField termen1Display;
    private JTextField termen2Display;
    private JTextField rezultatDisplay;
    private JButton addButton;
    private JButton modButton;
    private JButton clearButton;

    public ClasaCalculatorVlad() {
        addButton = createButton("PLUS");
        modButton = createButton("MOD");
        clearButton = createButton("STERGE");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int termen1 = Integer.parseInt(termen1Display.getText());
                    int termen2 = Integer.parseInt(termen2Display.getText());
                    int rezultat = termen1 + termen2;
                    rezultatDisplay.setText(String.valueOf(rezultat));
                } catch (NumberFormatException ex) {
                    rezultatDisplay.setText("Termenul 1,2 nu e întreg, introdu altul!");
                }
            }
        });

        modButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int termen1 = Integer.parseInt(termen1Display.getText());
                    int termen2 = Integer.parseInt(termen2Display.getText());
                    int rezultat = termen1 % termen2;
                    rezultatDisplay.setText(String.valueOf(rezultat));
                } catch (NumberFormatException ex) {
                    rezultatDisplay.setText("Termenul 1,2 nu e întreg, introdu altul!");
                } catch (ArithmeticException ex) {
                    rezultatDisplay.setText("Împărțire la zero!");
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                termen1Display.setText("");
                termen2Display.setText("");
                rezultatDisplay.setText("");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Exercițiul 1 - Calculator");
        ClasaCalculatorVlad calculator = new ClasaCalculatorVlad();
        frame.setContentPane(calculator.createContentPane());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private JPanel createContentPane() {
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(0, 255, 255));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        mainPanel.setMinimumSize(new Dimension(610, 410));

        topPanel = new JPanel(new GridBagLayout());  // Folosim GridBagLayout pentru un control mai bun
        topPanel.setBackground(new Color(255, 0, 0));
        topPanel.setMinimumSize(new Dimension(600, 300));
        mainPanel.add(topPanel, BorderLayout.CENTER);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);  // Adăugăm puțin spațiu între componente

        termen1Label = createLabel("TERMEN 1:", new Color(0, 0, 255));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        topPanel.add(termen1Label, gbc);

        termen1Display = createTextField("termen1Display");
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        topPanel.add(termen1Display, gbc);

        termen2Label = createLabel("TERMEN 2:", new Color(0, 0, 255));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        topPanel.add(termen2Label, gbc);

        termen2Display = createTextField("termen2Display");
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        topPanel.add(termen2Display, gbc);

        rezultatLabel = createLabel("REZULTAT:", new Color(255, 255, 0));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        topPanel.add(rezultatLabel, gbc);

        rezultatDisplay = createTextField("rezultatDisplay");
        rezultatDisplay.setEditable(false);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        topPanel.add(rezultatDisplay, gbc);

        bottomPanel = new JPanel(new GridLayout(1, 3, 5, 5));
        bottomPanel.setBackground(new Color(0, 255, 0));
        bottomPanel.setMinimumSize(new Dimension(600, 100));
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        bottomPanel.add(addButton);
        bottomPanel.add(modButton);
        bottomPanel.add(clearButton);

        return mainPanel;
    }

    private JLabel createLabel(String text, Color color) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(new Font("Times New Roman", Font.BOLD, 20));
        label.setForeground(color);
        return label;
    }

    private JTextField createTextField(String name) {
        JTextField textField = new JTextField();
        textField.setName(name);
        textField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        textField.setForeground(new Color(0, 0, 255));
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setPreferredSize(new Dimension(500, 60));
        return textField;
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Times New Roman", Font.BOLD, 20));
        button.setPreferredSize(new Dimension(100, 60));
        return button;
    }
}
