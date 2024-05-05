// package finals;

import java.awt.*;
import javax.swing.*;

public class ReceiptBG extends JFrame {
    
    public ReceiptBG() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Campus Route Path Navigator");
        setSize(new Dimension(1280, 720));

        setResizable(false);
        setLocationRelativeTo(null);
        setUndecorated(true);
        // setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Change path
        ImageIcon icon = new ImageIcon("C:\\Users\\kamil\\OneDrive\\Desktop\\Kiosk\\demo\\src\\main\\java\\finals\\WalkToTheRight.png");
        setIconImage(icon.getImage());

        add(mainPanel());
    }

    private JPanel mainPanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(0, 0, 1280, 720);
        panel.setBackground(new Color(0x191919));

        panel.add(outlinePanel());

        return panel;
    }

    private JPanel outlinePanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(80, 80, 1120, 560);
        panel.setBackground(new Color(0xFFFFFF));

        panel.add(contentPanel());

        return panel;
    }

    private JPanel contentPanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(5, 5, 1110, 550);
        panel.setBackground(new Color(0x191919));

        String note = "<html><div style='text-align: center;'>"
                       + "THANK YOU AND<br>"
                       + "HAVE A SAFE DAY<br>"
                       + "AHEAD!";
                       
        JLabel content = new JLabel(note);
        content.setBounds(85, 225, 200, 100);
        content.setForeground(Color.WHITE);
        content.setFont(new Font("Arial", Font.PLAIN, 20));
        panel.add(content);

        LogoButton logo = new LogoButton(">");
        logo.setBounds(775, 125, 300, 300);
        logo.setBackground(new Color(0x191919));
        logo.setForeground(Color.WHITE);
        panel.add(logo);

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ReceiptBG().setVisible(true);
        });
    }
}
