
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChoiceButtons extends JButton {
    private static final Color HOVER_COLOR = Color.decode("#38B6FF");
    private static final Color NORMAL_COLOR = new Color(0x191919);
    private static final Color TEXT_COLOR = Color.WHITE;

    public ChoiceButtons(String text) {
        super(text);
        setupButton();
        addHoverEffect();
    }

    private void setupButton() {
        setBackground(NORMAL_COLOR);
        setForeground(TEXT_COLOR);
        setFont(new Font("Arial", Font.BOLD, 15));
        setFocusable(false);
        setBorder(BorderFactory.createLineBorder(TEXT_COLOR, 1));
    }

    private void addHoverEffect() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(HOVER_COLOR);
                setBorder(BorderFactory.createLineBorder(HOVER_COLOR, 1));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(NORMAL_COLOR);
                setBorder(BorderFactory.createLineBorder(TEXT_COLOR, 1));
            }
        });
    }

}
