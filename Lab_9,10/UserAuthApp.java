import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class UserAuthApp extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField emailField;

    private Connection connection;

    public UserAuthApp() {
        // Set up the JFrame
        setTitle("User  Authentication");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new CardLayout());

        // Create panels for registration and login
        JPanel registrationPanel = createRegistrationPanel();
        JPanel loginPanel = createLoginPanel();

        // Add panels to the frame
        add(registrationPanel, "Registration");
        add(loginPanel, "Login");

        // Show the registration panel by default
        CardLayout cl = (CardLayout) (getContentPane().getLayout());
        cl.show(getContentPane(), "Registration");

        // Connect to the database
        connectToDatabase();

        setVisible(true);
    }

    private JPanel createRegistrationPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        panel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        panel.add(usernameField);

        panel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        panel.add(new JLabel("Email:"));
        emailField = new JTextField();
        panel.add(emailField);

        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(new RegisterAction());
        panel.add(registerButton);

        JButton switchToLoginButton = new JButton("Already have an account? Login");
        switchToLoginButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) (getContentPane().getLayout());
            cl.show(getContentPane(), "Login");
        });
        panel.add(switchToLoginButton);

        return panel;
    }

    private JPanel createLoginPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        panel.add(new JLabel("Username:"));
        JTextField loginUsernameField = new JTextField();
        panel.add(loginUsernameField);

        panel.add(new JLabel("Password:"));
        JPasswordField loginPasswordField = new JPasswordField();
        panel.add(loginPasswordField);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new LoginAction(loginUsernameField, loginPasswordField));
        panel.add(loginButton);

        JButton switchToRegisterButton = new JButton("Don't have an account? Register");
        switchToRegisterButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) (getContentPane().getLayout());
            cl.show(getContentPane(), "Registration");
        });
        panel.add(switchToRegisterButton);

        return panel;
    }

    private void connectToDatabase() {
        try {
            // Change the URL, username, and password as per your MySQL setup
            String url = "jdbc:mysql://localhost:3306/user_db";
            String user = "root"; // Your MySQL username
            String password = "Ashish7698"; // Your MySQL password
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Database connected successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private class RegisterAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            String email = emailField.getText();

            try {
                String query = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";
                PreparedStatement pst = connection.prepareStatement(query);
                pst.setString(1, username);
                pst.setString(2, password); // In a real application , you should hash the password before storing it
                pst.setString(3, email);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Registration successful!");
                usernameField.setText("");
                passwordField.setText("");
                emailField.setText("");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Registration failed: " + ex.getMessage());
            }
        }
    }

    private class LoginAction implements ActionListener {
        private JTextField usernameField;
        private JPasswordField passwordField;

        public LoginAction(JTextField usernameField, JPasswordField passwordField) {
            this.usernameField = usernameField;
            this.passwordField = passwordField;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            try {
                String query = "SELECT * FROM users WHERE username = ? AND password = ?";
                PreparedStatement pst = connection.prepareStatement(query);
                pst.setString(1, username);
                pst.setString(2, password);
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Login successful!");
                    // Proceed to the next part of the application
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password.");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Login failed: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(UserAuthApp::new);
    }
}