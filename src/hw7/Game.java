package hw7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Game class.
 *
 * @author Xu Zheng
 * <p>
 * Andrew id: xuzheng
 */
public class Game {

    /**
     * Start button.
     */
    private JButton startButton;

    /**
     * score field.
     */
    private JTextField scoreField;

    /**
     * time field.
     */
    private JTextField timerField;

    /**
     * list of buttons.
     */
    private List<JButton> buttonList = new ArrayList<>();

    /**
     * list of button threads.
     */
    private List<ButtonThread> buttonThreadList = new ArrayList<>();

    /**
     * Constructor.
     */
    public Game() {
        //create JFrame
        JFrame frame = new JFrame("Whack-A-Mole");
        //set window size
        frame.setSize(800, 400);
        //set exit on close
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //content panel
        JPanel globalPanel = new JPanel();
        globalPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel controlPanel = new JPanel();
        startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startButton.setEnabled(false);
                scoreField.setText("0");
                for (JButton button : buttonList) {
                    ButtonThread buttonThread = new ButtonThread(button);
                    buttonThreadList.add(buttonThread);
                }
                new Thread(new TimerThread(timerField, startButton, buttonThreadList)).start();
                for (ButtonThread thread : buttonThreadList) {
                    new Thread(thread).start();
                }
            }
        });
        controlPanel.add(startButton);

        JLabel timeLeftLabel = new JLabel("Time Left: ");
        controlPanel.add(timeLeftLabel);
        timerField = new JTextField(10);
        timerField.setEditable(false);
        controlPanel.add(timerField);

        JLabel scoreLabel = new JLabel("Score: ");
        controlPanel.add(scoreLabel);
        scoreField = new JTextField(10);
        scoreField.setEditable(false);
        controlPanel.add(scoreField);

        JPanel buttonPanel = new JPanel(new GridLayout(8, 1));
        for (int i = 0; i < 8; i++) {
            JPanel levelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            for (int j = 0; j < 8; j++) {
                JButton button = new JButton("Down");
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (!timerField.getText().equals("") && Integer.parseInt(timerField.getText()) > 0) {
                            if (button.getText().equals("Up")) {
                                button.setText("Hit");
                                button.setBackground(Color.RED);
                                button.setOpaque(true);
                                synchronized (scoreField) {
                                    scoreField.setText(String.valueOf(Integer.parseInt(scoreField.getText()) + 1));
                                }
                            }
                        }

                    }
                });
                button.setBackground(Color.LIGHT_GRAY);
                button.setOpaque(true);
                levelPanel.add(button);
                buttonList.add(button);
            }
            buttonPanel.add(levelPanel);
        }

        globalPanel.add(controlPanel);
        globalPanel.add(buttonPanel);

        //set content panel
        frame.setContentPane(globalPanel);
        //set visible
        frame.setVisible(true);
    }

    private static class TimerThread implements Runnable {
        /**
         * store reference to timerThread.
         */
        private JTextField myTimerField;
        /**
         * store reference to startButton.
         */
        private JButton myStartButton;

        /**
         * button list.
         */
        private List<ButtonThread> myThreadList;

        /**
         * Constructor.
         *
         * @param timerField  timerField
         * @param startButton startButton
         * @param threadList  list of button threads
         */
        TimerThread(JTextField timerField, JButton startButton, List<ButtonThread> threadList) {
            myTimerField = timerField;
            myStartButton = startButton;
            myThreadList = threadList;
        }

        /**
         * run.
         */
        @Override
        public void run() {
            int count = 20;
            myTimerField.setText(String.valueOf(count));
            try {
                while (count > 0) {
                    Thread.sleep(1000);
                    count--;
                    myTimerField.setText(String.valueOf(count));
                }
                for (ButtonThread thread : myThreadList) {
                    thread.setFinished();
                }
                Thread.sleep(5000);
                myStartButton.setEnabled(true);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class ButtonThread implements Runnable {
        /**
         * button.
         */
        private JButton myButton;

        /**
         * random number generator.
         */
        private Random random;

        /**
         * flag.
         */
        private boolean finished;

        /**
         * Constructor.
         *
         * @param button button
         */
        ButtonThread(JButton button) {
            myButton = button;
            random = new Random();
            finished = false;
        }

        /**
         * set finished variable to true.
         */
        public void setFinished() {
            finished = true;
        }

        /**
         * run.
         */
        @Override
        public void run() {
            try {
                while (!finished) {
                    //wait a moment to get up
                    Thread.sleep(random.nextInt(2) * 1000);
                    if (finished) {
                        break;
                    }
                    int randomNum = random.nextInt(4) + 1;
                    myButton.setText("Up");
                    myButton.setBackground(Color.GREEN);
                    myButton.setOpaque(true);
                    Thread.sleep(randomNum * 1000);
                    myButton.setText("Down");
                    myButton.setBackground(Color.LIGHT_GRAY);
                    myButton.setOpaque(true);
                    if (finished) {
                        break;
                    }
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * main.
     *
     * @param args args
     */
    public static void main(String[] args) {
        new Game();
    }
}
