import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

public class SimpleWindow {
    public static void main(String[] args) {
        // Always run GUI code on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> {
            // Create a new JFrame (window)
            JFrame frame = new JFrame("My First Swing Window");

            // Disbale resize
            frame.setResizable(false);

            // Maximize the window
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

            // Default closing
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Create panel to hold labels
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

            // Add red border to panel
            Border redBorder = BorderFactory.createLineBorder(Color.RED, 2);
            panel.setBorder(redBorder);

            // Create label 1
            JLabel label1 = new JLabel("Hello, Swing!", JLabel.CENTER);

            // Create labe 2
            JLabel label2 = new JLabel(
                    "Width: " + frame.getWidth() + ", Height: " + frame.getHeight(),
                    JLabel.CENTER);

            // Create button
            JButton closeButton = new JButton("Close");
            closeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            closeButton.addActionListener((ActionEvent e) -> {
                System.exit(0);
            });

            // Add components to panel
            panel.add(label1);
            panel.add(label2);
            panel.add(closeButton);

            // Add panel to frame
            frame.add(panel, BorderLayout.CENTER);

            // Update label AFTER frame is visible
            // SwingUtilities.invokeLater(() -> {
            // label2.setText(
            // "Width: " + frame.getWidth() + ", Height: " + frame.getHeight());
            // });

            // Use ComponentListener to get correct size
            frame.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentShown(ComponentEvent e) {
                    label2.setText("Width: " + frame.getWidth() + ", Height: " + frame.getHeight());
                }

                @Override
                public void componentResized(ComponentEvent e) {
                    label2.setText("Width: " + frame.getWidth() + ", Height: " + frame.getHeight());
                }
            });

            // Make the window visible
            // frame.setVisible(true);

            // Make fullscreen
            // Full-screen setup
            GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
            frame.setUndecorated(true); // remove borders and title bar
            gd.setFullScreenWindow(frame); // make full screen
        });
    }
}
