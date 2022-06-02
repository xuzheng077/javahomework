package lecture11_threads;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * First Recipe: Implements Runnable.
 * @author Jeff Eppinger & Terry Lee
 */
public class Lights implements Runnable {
    /**
     * Off string constant.
     */
    private static final String OFF_STRING = ":-(";
    /**
     * On string constant.
     */
    private static final String ON_STRING = ":-)";
    /**
     * Off color constant.
     */
    private static final Color OFF_COLOR = Color.RED;
    /**
     * On color constant.
     */
    private static final Color ON_COLOR = Color.GREEN;

    /**
     * sleep time in millisecs.
     */
    private long sleepTime;
    /**
     * Array of buttons to show on and off.
     */
    private JButton[] buttons;
    /**
     * Random object to pick a button from the array.
     */
    private Random random = new Random();

    /**
     * Constructor.
     * @param numLights number of lights with buttons
     * @param sleep sleep time
     */
    public Lights(int numLights, long sleep) {
        this.sleepTime = sleep;
        Font font = new Font(Font.MONOSPACED, Font.BOLD, 14);

        // Create a window
        JFrame window = new JFrame("A Swing App to Demonstrate Threads Running");
        window.setSize(650, 630);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a container
        JPanel pane = new JPanel();

        // create and add components to the container dynamically
        // instantiate an array of JButtons
        buttons = new JButton[numLights];
        for (int i = 0; i < buttons.length; i++) {
            // initially, set every button to OFF
            buttons[i] = new JButton(OFF_STRING);
            buttons[i].setBackground(OFF_COLOR);
            buttons[i].setOpaque(true);
            buttons[i].setFont(font);
            pane.add(buttons[i]);
        }

        window.setContentPane(pane);
        window.setVisible(true);

        // starts off only one thread
        // what is happening here?   what instance am I passing here?
        Thread t = new Thread(this);
        t.start();
    }

    /**
     * Implement run method of Runnable interface.
     */
    @Override
    public void run() {
        try {
            // long-running task
            while (true) {
                Thread.sleep(sleepTime);
                // get a random number
                int randomLightNum = random.nextInt(buttons.length);

                // pick a button from an array of JButtons
                JButton b = buttons[randomLightNum];
                // logic to set the button either on or off
                if (b.getText().equals(OFF_STRING)) {
                    b.setText(ON_STRING);
                    b.setBackground(ON_COLOR);
                } else {
                    b.setText(OFF_STRING);
                    b.setBackground(OFF_COLOR);
                }
            }
        } catch (InterruptedException e) {
            throw new AssertionError(e);
        }
    }

    /**
     * Program to check lights on and off example.
     * @param args number of lights and sleep milliseconds
     */
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java Lights <numLights> <sleepMillis>");
            return;
        }

        int numLights = Integer.parseInt(args[0]);
        long sleepMillis = Long.parseLong(args[1]);

        // create an instance of Lights class
        // what type is this instance?
        new Lights(numLights, sleepMillis);
    }

}
