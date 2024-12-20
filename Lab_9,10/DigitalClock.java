import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DigitalClock extends JFrame {
    private JLabel timeLabel;

    public DigitalClock() {
        setTitle("Digital Clock");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Arial", Font.PLAIN, 48));
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        add(timeLabel);

        // Center the window on the screen
        setLocationRelativeTo(null);

        setVisible(true);

        // Timer to update the time every second
        Timer timer = new Timer(1000, e -> updateTime());
        timer.start();

        updateTime(); // Initial call to set the time immediately
    }

    private void updateTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss a");
        String currentTime = formatter.format(new Date());
        timeLabel.setText(currentTime);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DigitalClock::new);
    }
}