import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class SimpleWindow {
    public static void main(String[] args) {
        // Always run GUI code on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> {
            // Create a new JFrame (window)
            JFrame frame = new JFrame("My First Swing Window");

            // Centralize window
            // frame.setLocationRelativeTo(null);

            // Define window size
            frame.setSize(400, 400);

            // Disbale resize
            frame.setResizable(false);

            // Default closing
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Add a simple label
            JLabel label = new JLabel("Hello, Swing!", JLabel.CENTER);
            frame.add(label);

            // Make the window visible
            frame.setVisible(true);
        });
    }
}
