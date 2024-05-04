//package name::::

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FloorButtonHover extends JPanel implements MouseListener {
    private Color normalBackground;
    private Color hoverBackground = Color.decode("#38B6FF");
    private Color normalForeground;
    private Color hoverForeground = Color.WHITE;

    public FloorButtonHover() {
        this.addMouseListener(this);
        this.normalBackground = this.getBackground();
        this.normalForeground = this.getForeground();
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {
        this.setBackground(hoverBackground);
        setChildForeground(this, hoverForeground); 
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setBackground(normalBackground);
        setChildForeground(this, normalForeground);
    }

    private void setChildForeground(Container container, Color color) {
        Component[] components = container.getComponents();
        for (Component component : components) {
            if (component instanceof Container) {
                setChildForeground((Container) component, color);
            }
            component.setForeground(color);
        }
    }
}
