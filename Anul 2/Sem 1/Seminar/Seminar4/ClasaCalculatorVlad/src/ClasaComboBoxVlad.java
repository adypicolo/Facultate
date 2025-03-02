import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClasaComboBoxVlad {
    private JPanel mainPanel;
    private JPanel topPanel;
    private JPanel bottomPanel;
    private JLabel schimbValutarLabel;
    private JTextField leiDisplay;
    private JComboBox<String> alegeComboBox;
    private JButton convertButton;
    private JTextField conversieDisplay;
    private JLabel leiLabel;
    private JLabel moneyTypeLabel;

    public ClasaComboBoxVlad() {
        initializeComponents();

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double lei = Double.parseDouble(leiDisplay.getText());
                    String moneda = (String) alegeComboBox.getSelectedItem();
                    double rataConversie = switch (moneda) {
                        case "EURO" -> 4.9;
                        case "DOLARI" -> 4.5;
                        case "FRANCI" -> 5.0;
                        default -> 0;
                    };
                    double rezultat = lei / rataConversie;
                    conversieDisplay.setText(String.format("%.2f", rezultat));
                } catch (NumberFormatException ex) {
                    conversieDisplay.setText("Eroare la introducere");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Exercițiul 2 - Schimb Valutar");
        ClasaComboBoxVlad comboBox = new ClasaComboBoxVlad();
        frame.setContentPane(comboBox.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void initializeComponents() {
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(0, 255, 255));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        mainPanel.setMinimumSize(new Dimension(610, 210));

        topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(255, 0, 255));
        topPanel.setMinimumSize(new Dimension(600, 50));
        mainPanel.add(topPanel, BorderLayout.NORTH);

        schimbValutarLabel = new JLabel("SCHIMB VALUTAR DIN LEI:", SwingConstants.CENTER);
        schimbValutarLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        schimbValutarLabel.setForeground(new Color(255, 255, 0));
        schimbValutarLabel.setMinimumSize(new Dimension(600, 40));
        topPanel.add(schimbValutarLabel, BorderLayout.CENTER);

        bottomPanel = new JPanel(null);
        bottomPanel.setBackground(new Color(0, 0, 255));
        bottomPanel.setMinimumSize(new Dimension(600, 150));
        mainPanel.add(bottomPanel, BorderLayout.CENTER);

        leiDisplay = createTextField();
        leiDisplay.setBounds(10, 10, 200, 75);
        bottomPanel.add(leiDisplay);

        alegeComboBox = new JComboBox<>(new String[]{"EURO", "DOLARI", "FRANCI"});
        alegeComboBox.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        alegeComboBox.setBounds(220, 10, 100, 75);
        bottomPanel.add(alegeComboBox);

        convertButton = new JButton("CONVERT");
        convertButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        convertButton.setBounds(330, 10, 100, 75);
        bottomPanel.add(convertButton);

        conversieDisplay = createTextField();
        conversieDisplay.setBounds(440, 10, 200, 75);
        conversieDisplay.setEditable(false);
        bottomPanel.add(conversieDisplay);

        leiLabel = createLabel("LEI", new Color(255, 255, 255));
        leiLabel.setBounds(10, 90, 200, 75);
        bottomPanel.add(leiLabel);

        moneyTypeLabel = createLabel("MONEDA STRAINA", new Color(255, 128, 0));
        moneyTypeLabel.setBounds(440, 90, 200, 75);
        bottomPanel.add(moneyTypeLabel);
    }

    private JTextField createTextField() {
        JTextField textField = new JTextField();
        textField.setFont(new Font("Times New Roman", Font.BOLD, 20));
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setMinimumSize(new Dimension(200, 75));
        return textField;
    }

    private JLabel createLabel(String text, Color color) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(new Font("Times New Roman", Font.BOLD, 20));
        label.setForeground(color);
        label.setMinimumSize(new Dimension(200, 75));
        return label;
    }
}
