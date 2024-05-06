// package finals;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ZoneClicked extends JPanel implements MouseListener {
    private Color clickedBackground = Color.decode("#38B6FF");
    private Color clickedForeground = Color.WHITE;
    private boolean clicked = false;

    public ZoneClicked() {
        this.addMouseListener(this);

        setOpaque(true);
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                clicked = !clicked;
                setBackground(clicked ? Color.decode("#38B6FF") : Color.WHITE); // Change color when clicked
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        this.setBackground(clickedBackground);
        setChildForeground(this, clickedForeground); 
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    private void setChildForeground(Container container, Color color) {
        Component[] components = container.getComponents();
        for (Component component : components) {
            if (component instanceof Container) {
                setChildForeground((Container) component, color);
            }
            component.setForeground(color);
        }
    }

    public boolean isClicked() {
        return clicked;
    }
}
