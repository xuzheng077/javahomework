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
 * Example with long-running task in actionPerformed.
 * @author Jeff Eppinger & Terry Lee
 */
public class ActionLoop implements ActionListener {
    /**
     * JButton for button field.
     */
    private JButton button;
    /**
     * Name field.
     */
    private JTextField nameField;
    /**
     * Text area to print status.
     */
    private JTextArea textArea;

    /**
     * Constructor.
     */
    public ActionLoop() {
        Font buttonFont = new Font(Font.SANS_SERIF, Font.BOLD, 16);
        Font labelFont = new Font(Font.SERIF, Font.BOLD, 16);
        Font textFont = new Font(Font.MONOSPACED, Font.BOLD, 14);

        // create a window
        JFrame window = new JFrame("A Swing App to Demonstrate Threads Running");
        window.setSize(650, 630);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create a container
        JPanel pane = new JPanel();

        // add components to the container
        JLabel label = new JLabel("Name: ");
        label.setFont(labelFont);
        pane.add(label);

        nameField = new JTextField(20);
        nameField.setFont(textFont);
        // connect actionlistener object with component
        nameField.addActionListener(this);
        pane.add(nameField);

        button = new JButton("Start");
        button.setFont(buttonFont);
        // connect actionlistener object with component
        button.addActionListener(this);
        pane.add(button);

        textArea = new JTextArea(30, 70);
        textArea.setEditable(false);
        textArea.setFont(textFont);
        JScrollPane scroller = new JScrollPane(textArea);
        pane.add(scroller);

        // set the window's content pane to be the container
        window.setContentPane(pane);
        window.setVisible(true);
    }

    /**
     * Implementation of actions.
     * @param evt ActionEvent object
     */
    @Override
    public void actionPerformed(ActionEvent evt) {
        String name = nameField.getText();
        // clear the field
        nameField.setText("");

        try {
            // long-running task
            while (true) {
                String status = name + ": " + System.currentTimeMillis() + "\n";
                System.out.println(status);
                textArea.append(status);
                // sleep for 1 second
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            textArea.append("Interrupted\n");
        }
    }

    /**
     * Test program to show thread information.
     * @param args arguments
     */
    public static void main(String[] args) {
        // get the reference to the currently running thread
        Thread myThread = Thread.currentThread();
        System.out.println("In method \"main()\".  Thread is named: " + myThread.getName());

        new ActionLoop();

        System.out.println("main() method is done.");
        System.out.println("Thread named " + myThread.getName() + " is done.");
    }
}
