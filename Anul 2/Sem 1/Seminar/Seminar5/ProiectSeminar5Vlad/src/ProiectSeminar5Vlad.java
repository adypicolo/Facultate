import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProiectSeminar5Vlad {
    private JFrame frame;
    private JPanel mainPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JPanel[] greenPanels;
    private JPanel[] redPanels;
    private JButton[] gameButtons;
    private JLabel labelX, labelO;
    private JTextField textFieldX, textFieldO;
    private JButton resetButton, exitButton;

    private char currentPlayer = 'X';
    private boolean gameOver = false;

    public ProiectSeminar5Vlad() {
        initializeComponents();
        setupGame();
    }

    private void initializeComponents() {
        frame = new JFrame("Tic Tac Toe - Proiect Seminar 5 Vlad");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);  // Dimensiune mai mare
        frame.setResizable(false);

        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(0, 255, 255)); // Cyan
        mainPanel.setPreferredSize(new Dimension(690, 490)); // Ajustează dimensiunea principală
        mainPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        leftPanel = new JPanel(new GridLayout(3, 3));
        leftPanel.setBackground(new Color(0, 255, 0)); // Green
        leftPanel.setPreferredSize(new Dimension(400, 400));  // Mărire panou stâng

        rightPanel = new JPanel(new GridLayout(3, 2));
        rightPanel.setBackground(new Color(255, 0, 0)); // Red
        rightPanel.setPreferredSize(new Dimension(300, 400));  // Mărire panou drept

        greenPanels = new JPanel[9];
        gameButtons = new JButton[9];

        for (int i = 0; i < 9; i++) {
            greenPanels[i] = new JPanel(new BorderLayout());
            greenPanels[i].setBackground(new Color(0, 255, 0));
            greenPanels[i].setPreferredSize(new Dimension(120, 120));  // Mărire dimensiune panouri

            gameButtons[i] = new JButton();
            gameButtons[i].setPreferredSize(new Dimension(120, 120));  // Mărire dimensiune butoane
            gameButtons[i].setBackground(new Color(0, 255, 0));
            gameButtons[i].setFont(new Font("Times New Roman", Font.BOLD, 20));  // Mărire font
            gameButtons[i].setForeground(Color.BLACK);
            gameButtons[i].setFocusPainted(false);
            gameButtons[i].addActionListener(new GameButtonListener(i));

            greenPanels[i].add(gameButtons[i]);
            leftPanel.add(greenPanels[i]);
        }

        redPanels = new JPanel[6];
        for (int i = 0; i < 6; i++) {
            redPanels[i] = new JPanel(new BorderLayout());
            redPanels[i].setBackground(new Color(255, 0, 0));
            redPanels[i].setPreferredSize(new Dimension(120, 120));  // Mărire dimensiune panouri
            rightPanel.add(redPanels[i]);
        }

        labelX = createLabel("JUCATOR X:", Color.BLUE);
        labelO = createLabel("JUCATOR O:", Color.YELLOW);

        redPanels[0].add(labelX);
        redPanels[2].add(labelO);

        textFieldX = createTextField();
        textFieldO = createTextField();

        redPanels[1].add(textFieldX);
        redPanels[3].add(textFieldO);

        resetButton = createButton("RESET");
        resetButton.addActionListener(e -> resetGame());
        redPanels[4].add(resetButton);

        exitButton = createButton("EXIT");
        exitButton.addActionListener(e -> System.exit(0));
        redPanels[5].add(exitButton);

        mainPanel.add(leftPanel, BorderLayout.WEST);
        mainPanel.add(rightPanel, BorderLayout.EAST);

        frame.setContentPane(mainPanel);
    }

    private void setupGame() {
        frame.setVisible(true);
    }

    private JLabel createLabel(String text, Color foreground) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(new Font("Times New Roman", Font.BOLD, 16));
        label.setForeground(foreground);
        return label;
    }

    private JTextField createTextField() {
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(100, 50));
        textField.setBackground(Color.PINK);
        textField.setFont(new Font("Times New Roman", Font.BOLD, 16));
        textField.setForeground(Color.BLACK);
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setEditable(false);
        return textField;
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(100, 50));
        button.setBackground(Color.PINK);
        button.setFont(new Font("Times New Roman", Font.BOLD, 16));
        button.setForeground(Color.BLACK);
        button.setFocusPainted(false);
        return button;
    }

    private class GameButtonListener implements ActionListener {
        private final int index;

        public GameButtonListener(int index) {
            this.index = index;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!gameOver && gameButtons[index].getText().isEmpty()) {
                gameButtons[index].setText(String.valueOf(currentPlayer));
                gameButtons[index].setEnabled(false);
                if (checkWinner()) {
                    gameOver = true;
                    if (currentPlayer == 'X') {
                        textFieldX.setText("CASTIGATOR");
                    } else {
                        textFieldO.setText("CASTIGATOR");
                    }
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            }
        }
    }

    private boolean checkWinner() {
        int[][] winningCombinations = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
                {0, 4, 8}, {2, 4, 6}
        };

        for (int[] combo : winningCombinations) {
            if (!gameButtons[combo[0]].getText().isEmpty() &&
                    gameButtons[combo[0]].getText().equals(gameButtons[combo[1]].getText()) &&
                    gameButtons[combo[1]].getText().equals(gameButtons[combo[2]].getText())) {
                return true;
            }
        }

        return false;
    }

    private void resetGame() {
        for (JButton button : gameButtons) {
            button.setText("");
            button.setEnabled(true);
        }
        textFieldX.setText("");
        textFieldO.setText("");
        currentPlayer = 'X';
        gameOver = false;
    }

    public static void main(String[] args) {
        new ProiectSeminar5Vlad();
    }
}
