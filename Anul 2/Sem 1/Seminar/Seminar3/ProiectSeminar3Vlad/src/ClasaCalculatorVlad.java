import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClasaCalculatorVlad {
    private JPanel panelCalculatorVlad;
    private JTextField textDisplay;
    private JButton ACButton;
    private JButton arrowButton;
    private JButton pmButton;
    private JButton plusButton;
    private JButton a7Button;
    private JButton a8Button;
    private JButton a9Button;
    private JButton minusButton;
    private JButton a4Button;
    private JButton a5Button;
    private JButton a6Button;
    private JButton timesButton;
    private JButton a1Button;
    private JButton a2Button;
    private JButton a3Button;
    private JButton divButton;
    private JButton a000Button;
    private JButton a0Button;
    private JButton commaButton;
    private JButton equalButton;

    private double operand1 = 0;
    private double operand2 = 0;
    private String operator = "";

    public ClasaCalculatorVlad() {
        panelCalculatorVlad = new JPanel();
        panelCalculatorVlad.setLayout(new BorderLayout());
        panelCalculatorVlad.setBackground(new Color(128, 255, 255));
        panelCalculatorVlad.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panelCalculatorVlad.setPreferredSize(new Dimension(285, 405));

        textDisplay = new JTextField();
        textDisplay.setHorizontalAlignment(JTextField.RIGHT);
        textDisplay.setFont(new Font("Times New Roman", Font.BOLD, 18));
        textDisplay.setPreferredSize(new Dimension(275, 60));
        panelCalculatorVlad.add(textDisplay, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(5, 4, 5, 5));
        buttonPanel.setBackground(new Color(128, 255, 255));
        panelCalculatorVlad.add(buttonPanel, BorderLayout.CENTER);

        Font buttonFont = new Font("Times New Roman", Font.BOLD, 18);
        Dimension buttonSize = new Dimension(60, 60);

        ACButton = createButton("AC", buttonFont, buttonSize);
        arrowButton = createButton("←", buttonFont, buttonSize);
        pmButton = createButton("±", buttonFont, buttonSize);
        plusButton = createButton("+", buttonFont, buttonSize);
        a7Button = createButton("7", buttonFont, buttonSize);
        a8Button = createButton("8", buttonFont, buttonSize);
        a9Button = createButton("9", buttonFont, buttonSize);
        minusButton = createButton("-", buttonFont, buttonSize);
        a4Button = createButton("4", buttonFont, buttonSize);
        a5Button = createButton("5", buttonFont, buttonSize);
        a6Button = createButton("6", buttonFont, buttonSize);
        timesButton = createButton("×", buttonFont, buttonSize);
        a1Button = createButton("1", buttonFont, buttonSize);
        a2Button = createButton("2", buttonFont, buttonSize);
        a3Button = createButton("3", buttonFont, buttonSize);
        divButton = createButton("÷", buttonFont, buttonSize);
        a000Button = createButton("000", buttonFont, buttonSize);
        a0Button = createButton("0", buttonFont, buttonSize);
        commaButton = createButton(",", buttonFont, buttonSize);
        equalButton = createButton("=", buttonFont, buttonSize);

        buttonPanel.add(ACButton);
        buttonPanel.add(arrowButton);
        buttonPanel.add(pmButton);
        buttonPanel.add(plusButton);
        buttonPanel.add(a7Button);
        buttonPanel.add(a8Button);
        buttonPanel.add(a9Button);
        buttonPanel.add(minusButton);
        buttonPanel.add(a4Button);
        buttonPanel.add(a5Button);
        buttonPanel.add(a6Button);
        buttonPanel.add(timesButton);
        buttonPanel.add(a1Button);
        buttonPanel.add(a2Button);
        buttonPanel.add(a3Button);
        buttonPanel.add(divButton);
        buttonPanel.add(a000Button);
        buttonPanel.add(a0Button);
        buttonPanel.add(commaButton);
        buttonPanel.add(equalButton);

        ACButton.addActionListener(e -> {
            textDisplay.setText("");
            operand1 = 0;
            operand2 = 0;
            operator = "";
        });

        ActionListener numberListener = e -> {
            JButton source = (JButton) e.getSource();
            textDisplay.setText(textDisplay.getText() + source.getText());
        };

        a0Button.addActionListener(numberListener);
        a1Button.addActionListener(numberListener);
        a2Button.addActionListener(numberListener);
        a3Button.addActionListener(numberListener);
        a4Button.addActionListener(numberListener);
        a5Button.addActionListener(numberListener);
        a6Button.addActionListener(numberListener);
        a7Button.addActionListener(numberListener);
        a8Button.addActionListener(numberListener);
        a9Button.addActionListener(numberListener);

        a000Button.addActionListener(e -> textDisplay.setText(textDisplay.getText() + "000"));

        pmButton.addActionListener(e -> {
            if (!textDisplay.getText().isEmpty()) {
                double value = Double.parseDouble(textDisplay.getText());
                textDisplay.setText(String.valueOf(-value));
            }
        });

        commaButton.addActionListener(e -> {
            if (!textDisplay.getText().contains(".")) {
                textDisplay.setText(textDisplay.getText() + ".");
            }
        });

        ActionListener operatorListener = e -> {
            JButton source = (JButton) e.getSource();
            operand1 = Double.parseDouble(textDisplay.getText());
            operator = source.getText();
            textDisplay.setText("");
        };

        plusButton.addActionListener(operatorListener);
        minusButton.addActionListener(operatorListener);
        timesButton.addActionListener(operatorListener);
        divButton.addActionListener(operatorListener);

        arrowButton.addActionListener(e -> {
            String currentText = textDisplay.getText();
            if (!currentText.isEmpty()) {
                textDisplay.setText(currentText.substring(0, currentText.length() - 1));
            }
        });

        equalButton.addActionListener(e -> {
            if (!operator.isEmpty()) {
                operand2 = Double.parseDouble(textDisplay.getText());
                double result = 0;
                switch (operator) {
                    case "+":
                        result = operand1 + operand2;
                        break;
                    case "-":
                        result = operand1 - operand2;
                        break;
                    case "×":
                        result = operand1 * operand2;
                        break;
                    case "÷":
                        if (operand2 != 0) {
                            result = operand1 / operand2;
                        } else {
                            textDisplay.setText("Error");
                            return;
                        }
                        break;
                }
                textDisplay.setText(String.valueOf(result));
                operator = "";
            }
        });
    }

    private JButton createButton(String text, Font font, Dimension size) {
        JButton button = new JButton(text);
        button.setFont(font);
        button.setPreferredSize(size);
        button.setMaximumSize(size);
        button.setMinimumSize(size);
        return button;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator Științific");
        frame.setContentPane(new ClasaCalculatorVlad().panelCalculatorVlad);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
