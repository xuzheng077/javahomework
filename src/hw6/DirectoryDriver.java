package hw6;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;


/**
 * DirectoryDriver class.
 *
 * @author Xu Zheng
 * <p>
 * Andrew id: xuzheng
 */
public class DirectoryDriver {

    /**
     * directory.
     */
    private Directory directory;

    /**
     * result area.
     */
    private JTextArea resultArea;

    /**
     * search key.
     */
    private JTextField searchKeyField;
    /**
     * first name.
     */
    private JTextField firstNameField;
    /**
     * last name.
     */
    private JTextField lastNameField;
    /**
     * andrew id.
     */
    private JTextField andrewIdField;
    /**
     * phone num.
     */
    private JTextField phoneNumField;
    /**
     * andrew id in delete panel.
     */
    private JTextField andrewIdFieldDelete;

    /**
     * add student button.
     */
    private JButton addButton;
    /**
     * delete student button.
     */
    private JButton deleteButton;
    /**
     * last name button.
     */
    private JButton byLastNameButton;
    /**
     * first name button.
     */
    private JButton byFirstNameButton;
    /**
     * andrew id button.
     */
    private JButton byAndrewIdButton;

    /**
     * Constructor.
     */
    public DirectoryDriver() {
        this(null);
    }

    /**
     * Constructor.
     *
     * @param filepath file path
     */
    public DirectoryDriver(String filepath) {
        //initialize directory
        directory = new Directory();
        //load data
        if (filepath != null) {
            loadData(filepath);
        }
        //create JFrame
        JFrame frame = new JFrame("Student Directory");
        //set window size
        frame.setSize(1000, 600);
        //set exit on close
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //content panel
        JPanel globalPanel = new JPanel();
        globalPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        Font globalFont = new Font(Font.SERIF, Font.BOLD, 20);

        //menu panel
        JPanel menuPanel = new JPanel(new GridLayout(7, 1));
        //add student panel
        createAddPanel(menuPanel, globalFont);
        //delete student panel
        createDeletePanel(menuPanel, globalFont);
        //search panel
        createSearchPanel(menuPanel, globalFont);

        //result panel
        JLabel resultLabel = new JLabel("  Results");
        resultLabel.setFont(globalFont);
        menuPanel.add(resultLabel);
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        resultArea = new JTextArea(10, 40);

        JScrollPane scroller = new JScrollPane(resultArea);
        resultPanel.add(scroller);

        globalPanel.add(menuPanel);
        globalPanel.add(resultPanel);

        //set action listeners
        setAddActionListener();
        setDeleteActionListener();
        setByAndrewIdActionListener();
        setByLastNameActionListener();
        setByFirstNameActionListener();

        //set content panel
        frame.setContentPane(globalPanel);
        //set enter key to press byAndrewIdButton
        searchKeyField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    byAndrewIdButton.doClick();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        //set visible
        frame.setVisible(true);
        //set focus to searchKey field
        searchKeyField.grabFocus();
    }


    /**
     * Method to load data from csv file.
     *
     * @param filepath file path
     */
    private void loadData(String filepath) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            br.readLine(); //skip header line
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String firstName = values[0].replace("\"", "");
                String lastName = values[1].replace("\"", "");
                String andrewId = values[2].replace("\"", "");
                String phoneNum = null;
                if (values.length >= 4 && !values[3].replace("\"", "").equals("")) {
                    phoneNum = values[3].replace("\"", "");
                }
                Student student = new Student(andrewId, firstName, lastName, phoneNum);
                directory.addStudent(student);
            }
        } catch (IOException e) {
            System.out.println("File does not exist");
        }
    }

    /**
     * create add panel.
     *
     * @param menuPanel  menu panel
     * @param globalFont font
     */
    private void createAddPanel(JPanel menuPanel, Font globalFont) {
        JLabel addStudentLabel = new JLabel("  Add a new student");
        addStudentLabel.setFont(globalFont);
        menuPanel.add(addStudentLabel);
        JPanel addStudentPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel firstNameLabel = new JLabel(" First Name: ");
        addStudentPanel.add(firstNameLabel);
        firstNameField = new JTextField(10);
        addStudentPanel.add(firstNameField);
        JLabel lastNameLabel = new JLabel("Last Name: ");
        addStudentPanel.add(lastNameLabel);
        lastNameField = new JTextField(10);
        addStudentPanel.add(lastNameField);
        JLabel andrewIdLabel = new JLabel("Andrew ID: ");
        addStudentPanel.add(andrewIdLabel);
        andrewIdField = new JTextField(10);
        addStudentPanel.add(andrewIdField);
        JLabel phoneNumLabel = new JLabel("Phone Number: ");
        addStudentPanel.add(phoneNumLabel);
        phoneNumField = new JTextField(10);
        addStudentPanel.add(phoneNumField);
        addButton = new JButton("Add");
        addStudentPanel.add(addButton);
        menuPanel.add(addStudentPanel);
    }

    /**
     * create delete panel.
     *
     * @param menuPanel  menu panel
     * @param globalFont font
     */
    private void createDeletePanel(JPanel menuPanel, Font globalFont) {
        JLabel deleteStudentLabel = new JLabel("  Delete a student");
        deleteStudentLabel.setFont(globalFont);
        menuPanel.add(deleteStudentLabel);
        JPanel deleteStudentPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel andrewIdLabelDelete = new JLabel(" Andrew ID: ");
        deleteStudentPanel.add(andrewIdLabelDelete);
        andrewIdFieldDelete = new JTextField(10);
        deleteStudentPanel.add(andrewIdFieldDelete);
        deleteButton = new JButton("Delete");
        deleteStudentPanel.add(deleteButton);
        menuPanel.add(deleteStudentPanel);
    }

    /**
     * create search panel.
     *
     * @param menuPanel  menu panel
     * @param globalFont font
     */
    private void createSearchPanel(JPanel menuPanel, Font globalFont) {
        JLabel searchStudentLabel = new JLabel("  Search student(s)");
        searchStudentLabel.setFont(globalFont);
        menuPanel.add(searchStudentLabel);
        JPanel searchStudentPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel searchKeyLabel = new JLabel(" Search Key: ");
        searchStudentPanel.add(searchKeyLabel);
        searchKeyField = new JTextField(10);
        searchStudentPanel.add(searchKeyField);
        byAndrewIdButton = new JButton("By Andrew ID");
        byFirstNameButton = new JButton("By First Name");
        byLastNameButton = new JButton("By Last Name");
        searchStudentPanel.add(byAndrewIdButton);
        searchStudentPanel.add(byFirstNameButton);
        searchStudentPanel.add(byLastNameButton);
        menuPanel.add(searchStudentPanel);
    }

    /**
     * set add action listener.
     */
    private void setAddActionListener() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = firstNameField.getText();
                if (firstName == null || firstName.trim().equals("")) {
                    resultArea.setText("");
                    resultArea.append("First name is missing\n");
                    return;
                }
                String lastName = lastNameField.getText();
                if (lastName == null || lastName.trim().equals("")) {
                    resultArea.setText("");
                    resultArea.append("Last name is missing\n");
                    return;
                }
                String andrewId = andrewIdField.getText();
                if (andrewId == null || andrewId.trim().equals("")) {
                    resultArea.setText("");
                    resultArea.append("Andrew ID is missing\n");
                    return;
                }
                String phoneNum = phoneNumField.getText();
                Student student = new Student(andrewId, firstName, lastName, phoneNum);
                try {
                    directory.addStudent(student);
                } catch (IllegalArgumentException exception) {
                    resultArea.setText("");
                    resultArea.append("Data already contains an entry for this Andrew ID \"" + andrewId + "\"\n");
                    return;
                }
                resultArea.append("New entry added: " + student.toString() + "\n");
                firstNameField.setText("");
                lastNameField.setText("");
                andrewIdField.setText("");
                phoneNumField.setText("");
            }
        });
    }

    /**
     * set delete action listener.
     */
    private void setDeleteActionListener() {
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String andrewId = andrewIdFieldDelete.getText();
                if (andrewId == null || andrewId.trim().equals("")) {
                    resultArea.setText("");
                    resultArea.append("Andrew ID is missing\n");
                    return;
                }
                Student s = directory.searchByAndrewId(andrewId);
                if (s == null) {
                    resultArea.append("Student with this Andrew ID \"" + andrewId + "\" does not exist\n");
                } else {
                    directory.deleteStudent(andrewId);
                    resultArea.append("Student deleted: " + s.toString() + "\n");
                    andrewIdFieldDelete.setText("");
                }
            }
        });
    }

    /**
     * set by andrew id action listener.
     */
    private void setByAndrewIdActionListener() {
        byAndrewIdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = searchKeyField.getText();
                if (value == null || value.trim().equals("")) {
                    resultArea.setText("");
                    resultArea.append("Andrew ID is missing\n");
                    return;
                }
                Student student = directory.searchByAndrewId(value);
                if (student == null) {
                    resultArea.append("Student with andrew id \"" + value + "\" does not exist\n");
                    return;
                }
                resultArea.append(student.toString() + "\n");
                searchKeyField.setText("");
            }
        });
    }

    /**
     * set by last name action listener.
     */
    private void setByLastNameActionListener() {
        byLastNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = searchKeyField.getText();
                if (value == null || value.trim().equals("")) {
                    resultArea.setText("");
                    resultArea.append("Last name is missing\n");
                    return;
                }
                List<Student> students = directory.searchByLastName(value);
                if (students.size() == 0) {
                    resultArea.append("Student with last name \"" + value + "\" does not exist\n");
                    return;
                }
                for (Student s : students) {
                    resultArea.append(s.toString() + "\n");
                }
                searchKeyField.setText("");
            }
        });
    }

    /**
     * set by first name action listener.
     */
    private void setByFirstNameActionListener() {
        byFirstNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = searchKeyField.getText();
                if (value == null || value.trim().equals("")) {
                    resultArea.setText("");
                    resultArea.append("First name is missing\n");
                    return;
                }
                List<Student> students = directory.searchByFirstName(value);
                if (students.size() == 0) {
                    resultArea.append("Student with first name \"" + value + "\" does not exist\n");
                    return;
                }
                for (Student s : students) {
                    resultArea.append(s.toString() + "\n");
                }
                searchKeyField.setText("");
            }
        });
    }

    /**
     * Main method.
     *
     * @param args arguments that contains a optional argument which is a csv file
     */
    public static void main(String[] args) {
        if (args.length > 0) {
            new DirectoryDriver(args[0]);
        } else {
            new DirectoryDriver();
        }
    }
}
