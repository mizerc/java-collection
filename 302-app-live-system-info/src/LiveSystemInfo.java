import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.Border;

public class LiveSystemInfo {
    public static void run() {
        SwingUtilities.invokeLater(() -> {
            // Create a new JFrame (window)
            JFrame frame = new JFrame("My First Swing Window");
            frame.setResizable(false);
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Panel with VLIST layout
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

            // Create labels with centralized text aligment
            JLabel timeLabel = new JLabel("", JLabel.CENTER);
            JLabel screenLabel = new JLabel("", JLabel.CENTER);
            JLabel memoryLabel = new JLabel("", JLabel.CENTER);

            // Add red border to labels
            Border redBorder = BorderFactory.createLineBorder(Color.RED, 1);
            timeLabel.setBorder(redBorder);
            screenLabel.setBorder(redBorder);
            memoryLabel.setBorder(redBorder);

            Border blueBorder = BorderFactory.createLineBorder(Color.BLUE, 1);
            panel.setBorder(blueBorder);

            // Centralize labels in panel
            timeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            screenLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            memoryLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            panel.add(Box.createVerticalGlue());
            panel.add(timeLabel);
            panel.add(Box.createVerticalStrut(10));
            panel.add(screenLabel);
            panel.add(Box.createVerticalStrut(10));
            panel.add(memoryLabel);
            panel.add(Box.createVerticalGlue());

            // Add panel to frame
            frame.add(panel, BorderLayout.CENTER);

            // Make the window visible
            frame.setVisible(true);

            // Timer to update info every second
            Timer timer = new Timer(1000, e -> {
                // System Time
                String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
                timeLabel.setText("Time: " + time);

                // System Screen
                Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
                screenLabel.setText("Screen: " + screen.width + "x" + screen.height);

                // System Memory
                MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
                long used = memoryBean.getHeapMemoryUsage().getUsed() / (1024 * 1024);
                long total = memoryBean.getHeapMemoryUsage().getMax() / (1024 * 1024);
                memoryLabel.setText("Memory: " + used + " MB / " + total + " MB");
            });
            timer.start();
        });
    }

}
