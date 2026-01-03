import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

public class Pixel {
    public static void start() {
        SwingUtilities.invokeLater(() -> {
            // Create a new JFrame (window)
            JFrame frame = new JFrame("Pixel Window");
            frame.setResizable(false);
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Panel with VLIST layout
            JPanel panel = new PixelPanel();

            // Set panel border
            Border blueBorder = BorderFactory.createLineBorder(Color.BLUE, 1);
            panel.setBorder(blueBorder);

            // Add panel to frame
            frame.add(panel, BorderLayout.CENTER);

            // Make the window visible
            frame.setVisible(true);
        });
    }

    // Static inner nested class
    static class PixelPanel extends JPanel {
        private Color[][] pixels;

        @Override
        protected void paintComponent(Graphics g) {
            // Super must be called
            super.paintComponent(g);

            // Extract panel size
            int width = getWidth();
            int height = getHeight();

            // Initialize pixels array if null or size changed
            if (pixels == null || pixels.length != width || pixels[0].length != height) {
                pixels = new Color[width][height];
                Random rand = new Random();
                for (int x = 0; x < width; x++) {
                    for (int y = 0; y < height; y++) {
                        pixels[x][y] = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
                    }
                }
            }

            // Draw each pixel
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    g.setColor(pixels[x][y]);
                    g.drawLine(x, y, x, y);
                }
            }
        }
    }

}
