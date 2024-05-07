import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LogoButton extends JButton {
    private static final Color NORMAL_TEXT_COLOR = Color.WHITE;
    private static final Color TEXT_COLOR = Color.decode("#38B6FF");

    public LogoButton(String text) {
        super(text);
    
        setupButton();
        addHoverEffect();

    }

    private void setupButton() {
        setBackground(null);
        setForeground(NORMAL_TEXT_COLOR);
        setFont(new Font("Arial", Font.BOLD, 200));
        setFocusable(false);
        setBorder(null);
        setContentAreaFilled(false);
        
    }

    private void addHoverEffect() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                e.consume();
            }
        
            @Override
            public void mousePressed(MouseEvent e) {
            }
        
            @Override
            public void mouseReleased(MouseEvent e) {}
            
            @Override
            public void mouseEntered(MouseEvent e) {
                setFont(new Font("Arial", Font.BOLD, 300));
                setForeground(TEXT_COLOR);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setFont(new Font("Arial", Font.BOLD, 200));
                setForeground(NORMAL_TEXT_COLOR);
            }
        });
    }

}
