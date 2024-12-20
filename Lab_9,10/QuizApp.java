import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizApp extends JFrame implements ActionListener {

    // Define necessary components
    private JLabel questionLabel;
    private JRadioButton[] options;
    private ButtonGroup buttonGroup;
    private JButton nextButton, submitButton, finishButton;
    private JPanel panel;
    private int currentQuestionIndex = 0;
    private int score = 0;

    // Define questions and options
    private String[] questions = {
            "What is the capital of France?",
            "Which programming language is used for Android development?",
            "Who developed the theory of relativity?"
    };

    private String[][] optionsList = {
            {"Berlin", "Madrid", "Paris", "Rome"},
            {"Java", "Python", "C#", "JavaScript"},
            {"Isaac Newton", "Albert Einstein", "Nikola Tesla", "Galileo"}
    };

    private int[] correctAnswers = {2, 0, 1};  // The index of correct answers in each options array

    public QuizApp() {
        // Frame properties
        setTitle("Simple Quiz Application");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize components
        questionLabel = new JLabel();
        options = new JRadioButton[4];
        buttonGroup = new ButtonGroup();
        nextButton = new JButton("Next");
        submitButton = new JButton("Submit");
        finishButton = new JButton("Finish");

        // Set up the panel
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Add question label
        questionLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(questionLabel);

        // Add options
        for (int i = 0; i < 4; i++) {
            options[i] = new JRadioButton();
            buttonGroup.add(options[i]);
            panel.add(options[i]);
        }

        // Add buttons
        panel.add(nextButton);
        panel.add(submitButton);
        panel.add(finishButton);

        // Add action listeners
        nextButton.addActionListener(this);
        submitButton.addActionListener(this);
        finishButton.addActionListener(this);

        // Set layout for the frame and add panel
        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);

        // Initially display the first question
        showQuestion(currentQuestionIndex);

        // Make the Submit button invisible initially
        submitButton.setVisible(false);
        finishButton.setVisible(false);
    }

    // Method to display question and options
    private void showQuestion(int index) {
        if (index < questions.length) {
            questionLabel.setText(questions[index]);
            for (int i = 0; i < 4; i++) {
                options[i].setText(optionsList[index][i]);
            }
        }
    }

    // Method to check if the selected answer is correct
    private void checkAnswer() {
        for (int i = 0; i < 4; i++) {
            if (options[i].isSelected()) {
                if (i == correctAnswers[currentQuestionIndex]) {
                    score++;
                }
                break;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle button actions
        if (e.getSource() == nextButton) {
            checkAnswer();
            currentQuestionIndex++;
            if (currentQuestionIndex < questions.length) {
                showQuestion(currentQuestionIndex);
            } else {
                nextButton.setEnabled(false);
                submitButton.setVisible(true);
                finishButton.setVisible(true);
                nextButton.setVisible(false);
            }
        } else if (e.getSource() == submitButton) {
            checkAnswer();
            JOptionPane.showMessageDialog(this, "Your final score is: " + score + "/" + questions.length);
            System.exit(0);
        } else if (e.getSource() == finishButton) {
            JOptionPane.showMessageDialog(this, "Your final score is: " + score + "/" + questions.length);
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                QuizApp quizApp = new QuizApp();
                quizApp.setVisible(true);
            }
        });
    }
}