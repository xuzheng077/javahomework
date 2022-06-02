package lecture11_threads;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Second Recipe: extends Thread.
 * @author Jeff Eppinger & Terry Lee
 */
public class Lights2 {

    /**
     * Constructor.
     * @param numLights number of lights using buttons
     * @param sleepTime sleep milliseconds
     */
    public Lights2(int numLights, long sleepTime) {
        Font font = new Font(Font.MONOSPACED, Font.BOLD, 14);

        // create a window
        JFrame window = new JFrame("A Swing App to Demonstrate Threads Running");
        window.setSize(650, 630);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create a container
        JPanel pane = new JPanel();

        // create and add components to the container dynamically
        JButton[] buttons = new JButton[numLights];
        for (int i = 0; i < buttons.length; i++) {
            // set every button to default state (neither walk nor stop)
            buttons[i] = new JButton("   ");
            buttons[i].setBackground(Color.LIGHT_GRAY);
            buttons[i].setFont(font);
            buttons[i].setOpaque(true);
            pane.add(buttons[i]);
        }

        // set window's content pane to be the container
        window.setContentPane(pane);
        window.setVisible(true);

        // Start two threads!!
        // Make sure to call start() method, not run() method!!
        // one thread to turn a light into green
        Thread walk = new HelperThread(buttons, sleepTime, Color.GREEN, ":-)");
        walk.start();

        // another thread to turn a light into red
        Thread stop = new HelperThread(buttons, sleepTime, Color.RED, ":-(");
        stop.start();
    }

    /**
     * static nested class that extends Thread
     * @author Jeff Eppinger & Terry Lee
     */
    private static class HelperThread extends Thread {
        // unique state (instance variables) per instance
        private JButton[] myButtons;
        private long mySleepTime;
        private Color myColor;
        private String myText;
        private Random random = new Random();

        /**
         * Constructor.
         * @param buttons array of buttons
         * @param sleepTime sleep time milliseconds
         * @param color color
         * @param text text
         */
        public HelperThread(JButton[] buttons, long sleepTime, Color color,
                String text) {
            myButtons = buttons;
            mySleepTime = sleepTime;
            myColor = color;
            myText = text;
        }

        /**
         * Implement run method of Thread class.
         */
        @Override
        public void run() {
            try {
                // long-running task
                while (true) {
                    Thread.sleep(mySleepTime);

                    // pick a random button based on random number
                    // what is the chance that two threads pick the same number?
                    int randomLightNum = random.nextInt(myButtons.length);
                    JButton light = myButtons[randomLightNum];
                    synchronized (light) {
                        // used the unique state of instance to set text and color
                        light.setText(myText);
                        light.setBackground(myColor);
                    }
                }
            } catch (InterruptedException e) {
                throw new AssertionError(e);
            }
        }
    }
    
    /**
     * Program to check lights on and off example.
     * @param args number of lights and sleep milliseconds
     */
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java Lights2 <numLights> <sleepMillis>");
            return;
        }

        int numLights = Integer.parseInt(args[0]);
        long sleepMillis = Long.parseLong(args[1]);
        new Lights2(numLights, sleepMillis);
    }

}
