package lecture3_java_classes;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Example code for Swing GUI for todo list.
 * @author Terry Lee
 */
public class ToDoSwingGUI extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
	// instance variables
    private JTextField item;
    private JTextArea listArea;
    private JButton topButton, bottomButton;
    private List<String> toDoList = new ArrayList<String>();

    // constructor
    public ToDoSwingGUI() {
        setTitle("A To Do List implemented Using Swing");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel content = new JPanel();

        Font fixFont = new Font(Font.MONOSPACED, Font.BOLD, 20);
        Font varFont = new Font(Font.SANS_SERIF, Font.BOLD, 20);

        JLabel label = new JLabel("Item: ");
        label.setFont(varFont);
        content.add(label);

        item = new JTextField(35);
        item.setFont(fixFont);
        content.add(item);

        topButton = new JButton("Add To Top");
        topButton.setFont(varFont);
        topButton.addActionListener(this);
        content.add(topButton);

        bottomButton = new JButton("Add To Bottom");
        bottomButton.setFont(varFont);
        bottomButton.addActionListener(this);
        content.add(bottomButton);

        listArea = new JTextArea(11, 45);
        listArea.setFont(fixFont);
        JScrollPane scroller = new JScrollPane(listArea);
        content.add(scroller);

        setContentPane(content);
        setVisible(true);
    }

	// instance method (override)
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == bottomButton) {
            addToBottom(item.getText());
            item.setText("");
            displayList();
        } else if (ae.getSource() == topButton) {
            addToTop(item.getText());
            item.setText("");
            displayList();
        } else {
            listArea.setText("Unknown Event");
        }
    }

	// instance methods below
    private void addToBottom(String s) {
        toDoList.add(s);
    }

    private void addToTop(String s) {
        toDoList.add(0, s);
    }

    private void displayList() {
        StringBuilder b = new StringBuilder();

        for (int i = 0; i < toDoList.size(); i++) {
            b.append(i + 1);
            b.append(". ");
            b.append(toDoList.get(i));
            b.append('\n');
        }

        listArea.setText(b.toString());
    }

	// main method
    public static void main(String[] args) {
		// create a new instance (instantiation)
        new ToDoSwingGUI();
    }
}
