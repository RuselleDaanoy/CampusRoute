package finals;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class About extends JFrame implements ActionListener {
    RectangularButtonPanel returnButton;

    public About() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Campus Route");
        setSize(new Dimension(1280, 720));

        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Change file path for it to display
        ImageIcon icon = new ImageIcon("C:\\Users\\kamil\\OneDrive\\Desktop\\Kiosk\\demo\\src\\main\\java\\finals\\WalkToTheRight.png");
        setIconImage(icon.getImage());

        add(mainPanel());
    }

    private JPanel mainPanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(0, 0, 1280, 720);
        panel.setBackground(new Color(0x191919));

        panel.add(titlePanel());
        panel.add(contentPanel());
        
        return panel;
    }

    private JPanel titlePanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(260, 130, 760, 100);
        panel.setBackground(new Color(0x191919));

        JLabel walk = new JLabel("WALK");
        walk.setBounds(0, 0, 400, 100);
        walk.setForeground(Color.WHITE);
        walk.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 100));
        panel.add(walk);

        JLabel trans = new JLabel("TO THE");
        trans.setBounds(310, 35, 1280, 30);
        trans.setForeground(Color.WHITE);
        trans.setFont(new Font("Arial", Font.ITALIC, 30));
        panel.add(trans);

        JLabel right = new JLabel("RIGHT");
        right.setBounds(430, 0, 400, 100);
        right.setForeground(new Color(0x38B6FF));
        right.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 100));
        panel.add(right);

        return panel;
    }

    private JPanel contentPanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(0, 230, 1280, 490);
        panel.setBackground(new Color(0x191919));

        String note = "<html><div style='text-align: center;'>"
                    + "is a Design and Analysis of Algorithm project that utilizes mainly the Dijkstra Algorithm to provide<br>"
                    + "a guide to university residents in navigating their paths in the Main Building of New Era<br>"
                    + "University Campus.<br><br>"
                    + "Programmers:<br>"
                    + "Faye Camille Buri, Venus Ruselle B. Daanoy, Pia Katleya V. Macalanda, and Thoby Jim R. Ralleta<br>"
                    + "2BSCS-1";
        
        JLabel description = new JLabel(note);
        description.setBounds(0, 0, 1280, 300);
        description.setForeground(Color.WHITE);
        description.setFont(new Font("Arial", Font.ITALIC, 25));
        description.setHorizontalAlignment(JLabel.CENTER);
        panel.add(description);

        returnButton = new ChoiceButtons("RETURN");
        returnButton.setBounds(50, 370, 130, 40);
        returnButton.setBackground(new Color(0x191919));
        returnButton.setForeground(Color.WHITE);
        returnButton.setFont(new Font("Arial", Font.BOLD, 15));
        returnButton.setFocusable(false);
        returnButton.addActionListener(this);
        panel.add(returnButton);

        return panel;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == returnButton) {
            dispose();
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new About().setVisible(true);
        });
    }
}
