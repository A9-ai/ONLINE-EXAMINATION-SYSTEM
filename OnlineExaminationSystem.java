import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class OnlineExaminationSystem {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Online Examination System");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

        JPanel panel = new JPanel();
        frame.add(panel);
        placeLoginComponents(panel);

        frame.setVisible(true);
    }

    private static void placeLoginComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Username");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(150, 20, 165, 25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setBounds(150, 50, 165, 25);
        panel.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(10, 80, 150, 25);
        panel.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordField.getPassword());
                if (username.equals("admin") && password.equals("admin123")) {
                    JOptionPane.showMessageDialog(panel, "Login Successful as Admin");
                    AdminDashboard();
                } else if (username.equals("user") && password.equals("user123")) {
                    JOptionPane.showMessageDialog(panel, "Login Successful as User");
                    UserExam();
                } else {
                    JOptionPane.showMessageDialog(panel, "Invalid Credentials");
                }
            }
        });
    }

    // Admin Dashboard
    private static void AdminDashboard() {
        JFrame adminFrame = new JFrame("Admin Dashboard");
        adminFrame.setSize(400, 300);
        adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel adminPanel = new JPanel();
        adminFrame.add(adminPanel);
        adminPanel.setLayout(new FlowLayout());

        JButton addQuestionButton = new JButton("Add Question");
        addQuestionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddQuestion();
            }
        });

        adminPanel.add(addQuestionButton);
        adminFrame.setVisible(true);
    }

    // Function to Add a Question
    private static void AddQuestion() {
        String question = JOptionPane.showInputDialog("Enter Question:");
        String option1 = JOptionPane.showInputDialog("Option 1:");
        String option2 = JOptionPane.showInputDialog("Option 2:");
        String option3 = JOptionPane.showInputDialog("Option 3:");
        String option4 = JOptionPane.showInputDialog("Option 4:");
        String correctAnswer = JOptionPane.showInputDialog("Correct Answer (1-4):");
        
        // Here you would add the question to your question pool.
        // For simplicity, we just display it.
        JOptionPane.showMessageDialog(null, "Question added successfully!");
        // You can save the question into a file or database
    }

    // User Exam Dashboard
    private static void UserExam() {
        // Start the exam for the user
        JFrame examFrame = new JFrame("User Exam");
        examFrame.setSize(600, 400);
        examFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel examPanel = new JPanel();
        examPanel.setLayout(new BoxLayout(examPanel, BoxLayout.Y_AXIS));
        examFrame.add(examPanel);
        
        // Example questions
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("What is Java?", "Programming Language", "Soda", "Fruit", "Animal", "Technology", 1));
        questions.add(new Question("Who is the President of the USA?", "Barack Obama", "Donald Trump", "Joe Biden", "Abraham Lincoln", 3));

        // Display questions
        for (Question q : questions) {
            examPanel.add(new JLabel(q.getQuestion()));
            examPanel.add(new JRadioButton(q.getOption1()));
            examPanel.add(new JRadioButton(q.getOption2()));
            examPanel.add(new JRadioButton(q.getOption3()));
            examPanel.add(new JRadioButton(q.getOption4()));
        }

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evaluateExam(questions);
                examFrame.dispose();
            }
        });
        
        examPanel.add(submitButton);
        examFrame.setVisible(true);
    }

    // Evaluate Exam
    private static void evaluateExam(List<Question> questions) {
        int score = 0;
        for (Question q : questions) {
            // Assume correct answer based on user's choice, just for simplicity
            score++;
        }

        JOptionPane.showMessageDialog(null, "Your Score: " + score + "/" + questions.size());
    }

    // Question Class to hold data for each question
    static class Question {
        private String question;
        private String option1, option2, option3, option4;
        private int correctAnswer;

        public Question(String question, String option1, String option2, String option3, String option4, int correctAnswer) {
            this.question = question;
            this.option1 = option1;
            this.option2 = option2;
            this.option3 = option3;
            this.option4 = option4;
            this.correctAnswer = correctAnswer;
        }

        public String getQuestion() {
            return question;
        }

        public String getOption1() {
            return option1;
        }

        public String getOption2() {
            return option2;
        }

        public String getOption3() {
            return option3;
        }

        public String getOption4() {
            return option4;
        }
    }
}
