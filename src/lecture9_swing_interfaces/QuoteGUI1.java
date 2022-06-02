package lecture9_swing_interfaces;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

/**
 * Example code for lecture 9.
 * @author Jeffrey Eppinger & Terry Lee
 */
public class QuoteGUI1 {

    /**
     * Simple program to show cookbook programming for Swing.
     * @param args arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("17-681 QuoteGUI Example");
        frame.setSize(520, 420);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel pane = new JPanel();

        Font bigFont = new Font(Font.SERIF, Font.BOLD, 25);

        JLabel label = new JLabel("How about a presidential quote?");
        label.setFont(bigFont);
        pane.add(label);

        JPanel line = new JPanel();

        ImageIcon obamaIcon = new ImageIcon("obama.jpg");
        JButton obamaButton = new JButton("Barack Obama", obamaIcon);
        obamaButton.setHorizontalTextPosition(SwingConstants.CENTER);
        obamaButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        line.add(obamaButton);

        ImageIcon trumpIcon = new ImageIcon("trump.jpg");
        JButton trumpButton = new JButton("Donald Trump", trumpIcon);
        trumpButton.setHorizontalTextPosition(SwingConstants.CENTER);
        trumpButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        line.add(trumpButton);

        pane.add(line);

        JTextArea area = new JTextArea(10, 40);
        area.setText("Yes, we can.");
        pane.add(area);

        frame.setContentPane(pane);
        frame.setVisible(true);
    }

}
