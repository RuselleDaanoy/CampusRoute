import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ZoneClicked extends JPanel implements MouseListener {
    private static ZoneClicked lastClicked = null;
    private boolean clicked = false;

    public ZoneClicked() {
        this.addMouseListener(this);

        setOpaque(true);
        setBackground(Color.WHITE);
        setChildForeground(this, Color.decode("#191919"));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (lastClicked != null && lastClicked != this) {
            lastClicked.setBackground(Color.WHITE);
            setChildForeground(lastClicked, Color.decode("#191919"));
            lastClicked.clicked = false;
        }

        clicked = !clicked;
        lastClicked = this;

        if (clicked) {
            setBackground(Color.decode("#38B6FF"));
            setChildForeground(this, Color.WHITE);
        } else {
            setBackground(Color.WHITE);
            setChildForeground(this, Color.decode("#191919"));
        }
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
