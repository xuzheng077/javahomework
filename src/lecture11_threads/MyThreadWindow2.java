package lecture11_threads;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Example code for Lecture 11 (Threads).
 * @author Jeff Eppinger & Terry Lee
 */
public class MyThreadWindow2 implements ActionListener {
    /**
     * button variable.
     */
    private JButton button;
    /**
     * name text field.
     */
    private JTextField nameField;
    /**
     * text area to display values.
     */
    private JTextArea textArea;
    /**
     * sleep time variable with initial value.
     */
    private int sleepTimeInSecs = 0;

    /**
     * Constructor to launch SwingGUI app to demo thread running.
     */
    public MyThreadWindow2() {
        Font buttonFont = new Font(Font.SANS_SERIF, Font.BOLD, 19);
        Font labelFont = new Font(Font.SERIF, Font.BOLD, 19);
        Font textFont = new Font(Font.MONOSPACED, Font.BOLD, 19);

        // Create a window
        JFrame window = new JFrame("A Swing Application to Demonstrate Threads Running");
        window.setSize(800, 650);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a container
        JPanel pane = new JPanel();

        // add components to the container
        JLabel label = new JLabel("Name: ");
        label.setFont(labelFont);
        pane.add(label);

        nameField = new JTextField(20);
        nameField.setFont(textFont);
        // make pushing enter button to execute the actionPerformed method
        nameField.addActionListener(this);
        pane.add(nameField);

        button = new JButton("Start a New Thread");
        button.setFont(buttonFont);
        // make clicking the button to execute the actionPerformed method
        button.addActionListener(this);
        pane.add(button);

        textArea = new JTextArea(25, 70);
        textArea.setEditable(false);
        textArea.setFont(textFont);
        JScrollPane scroller = new JScrollPane(textArea);
        pane.add(scroller);

        // set window's content pane to be the container
        window.setContentPane(pane);
        window.setVisible(true);
    }

    /**
     * Implementation of actionPerformed method of ActionLister interface.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        sleepTimeInSecs++;

        Thread myThread = Thread.currentThread();
        textArea.append("In method \"actionPerformed()\": Thread is named: " + myThread.getName() + "\n"
                + "   Creating a new thread \"" + nameField.getText() + "\", sleeps for " + sleepTimeInSecs
                + " seconds\n");

        // Recipe 2
        // Only Thread instance
        Thread t = new MyThread(sleepTimeInSecs, textArea);
        t.setName(nameField.getText());
        t.start();

        // clear the textfield
        nameField.setText("");
    }

    /**
     * Execute program to demo Thread running with given names.
     * @param args arguments
     */
    public static void main(String[] args) {
        Thread myThread = Thread.currentThread();
        System.out.println("In method \"main()\".  Thread is named: " + myThread.getName());

        new MyThreadWindow2();

        System.out.println("Thread named " + myThread.getName() + " is done.");
    }
}
