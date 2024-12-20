import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class StudentManagementSystem extends JFrame implements ActionListener {
    private JTextField txtStudentID, txtName, txtAge, txtGender, txtDepartment;
    private JButton btnAdd, btnUpdate, btnDelete, btnView;
    private JTable studentTable;
    private DefaultTableModel tableModel;

    // Database credentials
    private final String DB_URL = "jdbc:mysql://localhost:3306/student_db";
    private final String DB_USER = "root";
    private final String DB_PASSWORD = "Ashish7698";

    public StudentManagementSystem() {
        // Initialize the UI
        setTitle("Student Management System");
        setLayout(new BorderLayout());

        // Create form panel
        JPanel formPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        formPanel.add(new JLabel("Student ID:"));
        txtStudentID = new JTextField();
        formPanel.add(txtStudentID);

        formPanel.add(new JLabel("Name:"));
        txtName = new JTextField();
        formPanel.add(txtName);

        formPanel.add(new JLabel("Age:"));
        txtAge = new JTextField();
        formPanel.add(txtAge);

        formPanel.add(new JLabel("Gender:"));
        txtGender = new JTextField();
        formPanel.add(txtGender);

        formPanel.add(new JLabel("Department:"));
        txtDepartment = new JTextField();
        formPanel.add(txtDepartment);

        add(formPanel, BorderLayout.NORTH);

        // Create button panel
        JPanel buttonPanel = new JPanel(new GridLayout(1, 4, 10, 10));

        btnAdd = new JButton("Add");
        btnAdd.addActionListener(this);
        buttonPanel.add(btnAdd);

        btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(this);
        buttonPanel.add(btnUpdate);

        btnDelete = new JButton("Delete");
        btnDelete.addActionListener(this);
        buttonPanel.add(btnDelete);

        btnView = new JButton("View");
        btnView.addActionListener(this);
        buttonPanel.add(btnView);

        add(buttonPanel, BorderLayout.CENTER);

        // Create table panel
        tableModel = new DefaultTableModel(new String[]{"Student ID", "Name", "Age", "Gender", "Department"}, 0);
        studentTable = new JTable(tableModel);
        add(new JScrollPane(studentTable), BorderLayout.SOUTH);

        // Set JFrame properties
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // Initialize database
        initDatabase();
    }

    private void initDatabase() {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement()) {
            String createTableSQL = "CREATE TABLE IF NOT EXISTS students (" +
                    "student_id VARCHAR(10) PRIMARY KEY, " +
                    "name VARCHAR(50), " +
                    "age INT, " +
                    "gender VARCHAR(10), " +
                    "department VARCHAR(50))";
            stmt.execute(createTableSQL);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error initializing database: " + e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAdd) {
            addStudent();
        } else if (e.getSource() == btnUpdate) {
            updateStudent();
        } else if (e.getSource() == btnDelete) {
            deleteStudent();
        } else if (e.getSource() == btnView) {
            viewStudents();
        }
    }

    private void addStudent() {
        String id = txtStudentID.getText();
        String name = txtName.getText();
        String age = txtAge.getText();
        String gender = txtGender.getText();
        String department = txtDepartment.getText();

        String insertSQL = "INSERT INTO students (student_id, name, age, gender, department) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            pstmt.setString(1, id);
            pstmt.setString(2, name);
            pstmt.setInt(3, Integer.parseInt(age));
            pstmt.setString(4, gender);
            pstmt.setString(5, department);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Student added successfully!");
            clearFields();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error adding student: " + ex.getMessage());
        }
    }

    private void updateStudent() {
        String id = txtStudentID.getText();
        String name = txtName.getText();
        String age = txtAge.getText();
        String gender = txtGender.getText();
        String department = txtDepartment.getText();

        String updateSQL = "UPDATE students SET name=?, age=?, gender=?, department=? WHERE student_id=?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, Integer.parseInt(age));
            pstmt.setString(3, gender);
            pstmt.setString(4, department);
            pstmt.setString(5, id);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Student updated successfully!");
            clearFields();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error updating student: " + ex.getMessage());
        }
    }

    private void deleteStudent() {
        String id = txtStudentID.getText();

        String deleteSQL = "DELETE FROM students WHERE student_id=?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(deleteSQL)) {
            pstmt.setString(1, id);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Student deleted successfully!");
            clearFields();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error deleting student: " + ex.getMessage());
        }
    }

    private void viewStudents() {
        String selectSQL = "SELECT * FROM students";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(selectSQL)) {

            tableModel.setRowCount(0); // Clear the table
            while (rs.next()) {
                String id = rs.getString("student_id");
                String name = rs.getString("name");
                String age = String.valueOf(rs.getInt("age"));
                String gender = rs.getString("gender");
                String department = rs.getString("department");
                tableModel.addRow(new Object[]{id, name, age, gender, department});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error viewing students: " + ex.getMessage());
        }
    }

    private void clearFields() {
        txtStudentID.setText("");
        txtName.setText("");
        txtAge.setText("");
        txtGender.setText("");
        txtDepartment.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StudentManagementSystem::new);
    }
}
