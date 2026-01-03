import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
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

            // Add a simple label
            JLabel label1 = new JLabel("Hello, Swing!", JLabel.CENTER);
            panel.add(label1);

            // Create label with frame dimensions
            JLabel label2 = new JLabel(
                    "Width: " + frame.getWidth() + ", Height: " + frame.getHeight(),
                    JLabel.CENTER);
            panel.add(label2);

            // Add panel to frame
            frame.add(panel, BorderLayout.CENTER);

            // Make the window visible
            frame.setVisible(true);

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
        });
    }
}
