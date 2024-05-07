// package finals;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ZoneClicked extends JPanel implements MouseListener {
    private Color clickedBackground = Color.decode("#38B6FF");
    private Color originalBackground = Color.WHITE;
    private Color clickedForeground = Color.WHITE;
    private Color originalForeground = Color.decode("#191919");
    private boolean clicked = false;

    public ZoneClicked() {
        this.addMouseListener(this);

        setOpaque(true);
        setBackground(originalBackground); 
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        clicked = !clicked;
        setBackground(clicked ? clickedBackground : originalBackground); 
        setForeground(clicked ? clickedForeground : originalForeground); 
        repaint(); 
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    public boolean isClicked() {
        return clicked;
    }
}
