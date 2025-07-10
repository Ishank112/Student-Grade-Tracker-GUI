import javax.swing.*;
import java.awt.*;

public class StudentGradeTrackerGUI extends JFrame {
    private JTextField nameField, gradeField, searchField;
    private JTextArea outputArea;
    private StudentManager manager = new StudentManager();

    public StudentGradeTrackerGUI() {
        setTitle("Student Grade Tracker");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        manager.loadFromFile();

        // Input panel
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        nameField = new JTextField();
        gradeField = new JTextField();
        searchField = new JTextField();

        inputPanel.add(new JLabel("Student Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Grade:"));
        inputPanel.add(gradeField);
        inputPanel.add(new JLabel("Search Name:"));
        inputPanel.add(searchField);

        add(inputPanel, BorderLayout.NORTH);

        // Button panel
        JPanel buttonPanel = new JPanel(new GridLayout(2, 3, 10, 10));
        JButton addBtn = new JButton("Add");
        JButton summaryBtn = new JButton("Summary");
        JButton sortNameBtn = new JButton("Sort by Name");
        JButton sortGradeBtn = new JButton("Sort by Grade");
        JButton searchBtn = new JButton("Search");
        JButton refreshBtn = new JButton("Refresh All");

        buttonPanel.add(addBtn);
        buttonPanel.add(summaryBtn);
        buttonPanel.add(sortNameBtn);
        buttonPanel.add(sortGradeBtn);
        buttonPanel.add(searchBtn);
        buttonPanel.add(refreshBtn);

        add(buttonPanel, BorderLayout.CENTER);

        // Output area
        outputArea = new JTextArea(15, 40);
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea), BorderLayout.SOUTH);

        refreshOutput();

        // Button actions
        addBtn.addActionListener(e -> {
            String name = nameField.getText();
            String gradeText = gradeField.getText();

            try {
                int grade = Integer.parseInt(gradeText);
                if (grade < 0 || grade > 100) {
                    JOptionPane.showMessageDialog(this, "Grade must be 0–100");
                    return;
                }
                manager.addStudent(new Student(name, grade));
                nameField.setText("");
                gradeField.setText("");
                refreshOutput();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid grade!");
            }
        });

        summaryBtn.addActionListener(e -> {
            double avg = manager.getAverage();
            int high = manager.getHighest();
            int low = manager.getLowest();
            outputArea.append("\n--- Summary ---\n");
            outputArea.append("Average Grade: " + avg + "\n");
            outputArea.append("Highest Grade: " + high + "\n");
            outputArea.append("Lowest Grade : " + low + "\n");
        });

        sortNameBtn.addActionListener(e -> {
            manager.sortByName();
            refreshOutput();
        });

        sortGradeBtn.addActionListener(e -> {
            manager.sortByGrade();
            refreshOutput();
        });

        searchBtn.addActionListener(e -> {
            String name = searchField.getText();
            Student s = manager.searchByName(name);
            if (s != null) {
                JOptionPane.showMessageDialog(this, "Found: " + s.toString());
            } else {
                JOptionPane.showMessageDialog(this, "Student not found.");
            }
        });

        refreshBtn.addActionListener(e -> refreshOutput());

        setVisible(true);
    }

    private void refreshOutput() {
        outputArea.setText("--- Student List ---\n");
        for (Student s : manager.getStudents()) {
            outputArea.append(s.toString() + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StudentGradeTrackerGUI::new);
    }
}
