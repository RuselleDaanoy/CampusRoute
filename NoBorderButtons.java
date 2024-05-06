
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NoBorderButtons extends JButton {
    private Color TEXT_COLOR;

    public NoBorderButtons(String text, Color TEXT_COLOR) {
        super(text);
        this.TEXT_COLOR = TEXT_COLOR;
        
        setupButton();
        addHoverEffect();

    }

    private void setupButton() {
        setBackground(new Color(0x191919));
        setForeground(TEXT_COLOR);
        setSize(130, 40);
        setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 50));
        setFocusable(false);
        setContentAreaFilled(false);
        setBorder(null);
    }

    private void addHoverEffect() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 70));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 50));
            }
        });
    }

}
