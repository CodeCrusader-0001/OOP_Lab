import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BasicCalculator extends JFrame implements ActionListener, FocusListener, KeyListener {
    private JTextField display;
    private double result;
    private String operator;
    private boolean startNewNumber;

    public BasicCalculator() {
        // Set up the frame
        setTitle("Basic Calculator");
        setLayout(new BorderLayout());
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the display
        display = new JTextField("0");
        display.setFont(new Font("Verdana", Font.BOLD, 30));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.addFocusListener(this);
        display.addKeyListener(this);
        add(display, BorderLayout.NORTH);

        // Create the panel for buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));
        add(panel, BorderLayout.CENTER);

        // Create buttons
        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+"
        };
        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Verdana", Font.BOLD, 30));
            button.addActionListener(this);
            button.addFocusListener(this);
            button.addKeyListener(this);
            panel.add(button);
        }

        result = 0;
        operator = "=";
        startNewNumber = true;

        // Make the frame visible
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if ("0123456789.".contains(command)) {
            if (startNewNumber) {
                display.setText(command);
                startNewNumber = false;
            } else {
                display.setText(display.getText() + command);
            }
        } else {
            if (startNewNumber) {
                if (command.equals("-")) {
                    display.setText(command);
                    startNewNumber = false;
                } else {
                    operator = command;
                }
            } else {
                double x = Double.parseDouble(display.getText());
                calculate(x);
                operator = command;
                startNewNumber = true;
            }
        }
    }

    private void calculate(double x) {
        switch (operator) {
            case "+":
                result += x;
                break;
            case "-":
                result -= x;
                break;
            case "*":
                result *= x;
                break;
            case "/":
                if (x != 0) {
                    result /= x;
                } else {
                    display.setText("Error");
                    return;
                }
                break;
            case "=":
                result = x;
                break;
        }
        display.setText("" + result);
    }

    @Override
    public void focusGained(FocusEvent e) {
        // Highlight the button or text field when focused
        Component comp = e.getComponent();
        comp.setBackground(Color.CYAN);
    }

    @Override
    public void focusLost(FocusEvent e) {
        // Remove the highlight when focus is lost
        Component comp = e.getComponent();
        comp.setBackground(UIManager.getColor("Button.background"));
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Handle key typed events (e.g., digits and operators)
        char keyChar = e.getKeyChar();
        if ("0123456789.+-*/=".indexOf(keyChar) >= 0) {
            actionPerformed(new ActionEvent(e.getSource(), ActionEvent.ACTION_PERFORMED, String.valueOf(keyChar)));
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Handle special keys (e.g., Enter and Backspace)
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            actionPerformed(new ActionEvent(e.getSource(), ActionEvent.ACTION_PERFORMED, "="));
        } else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            String text = display.getText();
            if (text.length() > 0) {
                display.setText(text.substring(0, text.length() - 1));
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Not used
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BasicCalculator::new);
    }
}
