package src;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DigitalClock {
    private JFrame frame;
    private JLabel timeLabel;

    public DigitalClock() {
        // Set up the frame
        frame = new JFrame("Digital Clock");
        frame.setLayout(new BorderLayout());
        frame.setSize(800, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JLabel to display the current time
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Verdana", Font.CENTER_BASELINE, 30));
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timeLabel.setVerticalAlignment(SwingConstants.CENTER);
        frame.add(timeLabel, BorderLayout.AFTER_LAST_LINE);

        // Use a timer to update the time every second
        javax.swing.Timer timer = new javax.swing.Timer(1000, e -> updateTime());
        timer.start();

        // Start updating the time immediately
        updateTime();

        // Make the frame visible
        frame.setVisible(true);
    }

    private void updateTime() {
        // Format the current time
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata")); // Set time zone to IST
        String currentTime = dateFormat.format(new Date());

        // Update the JLabel with the current time
        timeLabel.setText(currentTime);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DigitalClock::new);
    }
}
