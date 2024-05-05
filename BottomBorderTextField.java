import javax.swing.*;
import java.awt.*;

public class BottomBorderTextField extends JTextField {
    private Color borderColor = new Color(0x38B6FF); // Change this to set the border color

    public BottomBorderTextField() {
        setOpaque(false); // Make the text field transparent
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();

        int height = getHeight();
        int width = getWidth();

        // Draw bottom border
        g2.setColor(borderColor);
        g2.drawLine(0, height - 1, width, height - 1);

        g2.dispose();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(super.getPreferredSize().width, 50); // Adjust height as needed
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Bottom Border JTextField");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new FlowLayout());
            
            BottomBorderTextField textField = new BottomBorderTextField();
            textField.setPreferredSize(new Dimension(200, 30)); // Set preferred size
            
            frame.add(textField);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}