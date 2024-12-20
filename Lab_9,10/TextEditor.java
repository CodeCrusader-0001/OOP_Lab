import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class TextEditor extends JFrame implements ActionListener {
    private JTextArea textArea;
    private JLabel statusBar;
    private JMenuItem openItem, saveItem, clearItem, exitItem;

    public TextEditor() {
        // Initialize the JFrame
        setTitle("Text Editor");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create text area
        textArea = new JTextArea();
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        // Create status bar
        statusBar = new JLabel("Lines: 0 | Characters: 0");
        add(statusBar, BorderLayout.SOUTH);

        // Add document listener to update the status bar
        textArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                updateStatusBar();
            }
        });

        // Create menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");

        openItem = new JMenuItem("Open");
        saveItem = new JMenuItem("Save");
        clearItem = new JMenuItem("Clear");
        exitItem = new JMenuItem("Exit");

        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(clearItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        // Add action listeners
        openItem.addActionListener(this);
        saveItem.addActionListener(this);
        clearItem.addActionListener(this);
        exitItem.addActionListener(this);

        // Make the JFrame visible
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == openItem) {
            openFile();
        } else if (e.getSource() == saveItem) {
            saveFile();
        } else if (e.getSource() == clearItem) {
            clearText();
        } else if (e.getSource() == exitItem) {
            exitApplication();
        }
    }

    private void openFile() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt", "java", "csv");
        fileChooser.setFileFilter(filter);

        int option = fileChooser.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                textArea.read(reader, null);
                updateStatusBar();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error opening file: " + ex.getMessage());
            }
        }
    }

    private void saveFile() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt", "java", "csv");
        fileChooser.setFileFilter(filter);

        int option = fileChooser.showSaveDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                textArea.write(writer);
                JOptionPane.showMessageDialog(this, "File saved successfully!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage());
            }
        }
    }

    private void clearText() {
        textArea.setText("");
        updateStatusBar();
    }

    private void exitApplication() {
        int option = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    private void updateStatusBar() {
        String text = textArea.getText();
        int lines = textArea.getLineCount();
        int characters = text.length();
        statusBar.setText("Lines: " + lines + " | Characters: " + characters);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TextEditor::new);
    }
}
