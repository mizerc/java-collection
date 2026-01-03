import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

public class TabbedNotes {
    public static void main(String[] args) {
        // Always run GUI code on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> {
            // Create a new JFrame (window)
            JFrame frame = new JFrame("My First Swing Window");
            frame.setResizable(false);
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Create tabbed pane
            JTabbedPane tabbedPane = new JTabbedPane();
            tabbedPane.addTab("Note 1", createTextArea());

            // Button to add new tabs
            JButton addTabButton = new JButton("Add Tab");
            addTabButton.addActionListener((ActionEvent e) -> {
                int tabCount = tabbedPane.getTabCount() + 1;
                tabbedPane.addTab("Note " + tabCount, createTextArea());
                tabbedPane.setSelectedIndex(tabbedPane.getTabCount() - 1);
            });

            // Add panel to frame
            frame.setLayout(new BorderLayout());
            frame.add(tabbedPane, BorderLayout.CENTER);
            frame.add(addTabButton, BorderLayout.SOUTH);

            // Make the window visible
            frame.setVisible(true);
        });
    }

    // Helper: create scrollable text area
    private static JScrollPane createTextArea() {
        JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        return new JScrollPane(textArea);
    }
}
