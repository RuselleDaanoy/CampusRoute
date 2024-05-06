// package finals;

import java.awt.*;
// import java.awt.event.*;
import javax.swing.*;

public class WalkZone1 extends JFrame {
    
    public WalkZone1() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Campus Route Path Navigator");
        setSize(new Dimension(1280, 720));

        setResizable(false);
        setLocationRelativeTo(null);
        setUndecorated(true);
        // setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Change file path as needed
        ImageIcon icon = new ImageIcon("C:\\Users\\kamil\\OneDrive\\Desktop\\Kiosk\\demo\\src\\main\\resources\\WalkToTheRight.png");
        setIconImage(icon.getImage());

        add(mainPanel());
    }

    private JPanel mainPanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(0, 0, 1280, 720);
        panel.setBackground(new Color(0x191919));

        JLabel heading = new JLabel("WALK TO THE RIGHT ZONES");
        heading.setBounds(0, 40, 1280, 68);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 50));
        heading.setHorizontalAlignment(JLabel.CENTER);
        panel.add(heading);

        panel.add(zonePanels());

        JLabel footer = new JLabel("READY TO WALK?");
        footer.setBounds(0, 610, 1280, 70);
        footer.setForeground(new Color(0x38B6FF));
        footer.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 70));
        footer.setHorizontalAlignment(JLabel.CENTER);
        panel.add(footer);

        return panel;
    }

    private JPanel zonePanels() {
        JPanel panel = new JPanel(null);
        panel.setBounds(0, 110, 1280, 480);
        panel.setBackground(new Color(0x191919));

        JPanel panel1 = new JPanel(null);
        panel1.setBounds(75, 10, 180, 225);
        panel1.setBackground(Color.WHITE);
        panel.add(panel1);

        JLabel zone1 = new JLabel("1");
        zone1.setBounds(0, 24, 170, 200);
        zone1.setForeground(new Color(0x191919));
        zone1.setFont(new Font("Arial", Font.BOLD, 150));
        zone1.setHorizontalAlignment(JLabel.CENTER);
        panel1.add(zone1);

        JPanel panel2 = new JPanel(null);
        panel2.setBounds(265, 10, 180, 225);
        panel2.setBackground(Color.WHITE);
        panel.add(panel2);

        JLabel zone2 = new JLabel("2");
        zone2.setBounds(0, 24, 170, 200);
        zone2.setForeground(new Color(0x191919));
        zone2.setFont(new Font("Arial", Font.BOLD, 150));
        zone2.setHorizontalAlignment(JLabel.CENTER);
        panel2.add(zone2);

        JPanel panel3 = new JPanel(null);
        panel3.setBounds(455, 10, 180, 225);
        panel3.setBackground(Color.WHITE);
        panel.add(panel3);

        JLabel zone3 = new JLabel("3");
        zone3.setBounds(0, 24, 170, 200);
        zone3.setForeground(new Color(0x191919));
        zone3.setFont(new Font("Arial", Font.BOLD, 150));
        zone3.setHorizontalAlignment(JLabel.CENTER);
        panel3.add(zone3);

        JPanel panel4 = new JPanel(null);
        panel4.setBounds(645, 10, 180, 225);
        panel4.setBackground(Color.WHITE);
        panel.add(panel4);

        JLabel zone4 = new JLabel("4");
        zone4.setBounds(0, 24, 170, 200);
        zone4.setForeground(new Color(0x191919));
        zone4.setFont(new Font("Arial", Font.BOLD, 150));
        zone4.setHorizontalAlignment(JLabel.CENTER);
        panel4.add(zone4);

        JPanel panel5 = new JPanel(null);
        panel5.setBounds(835, 10, 180, 225);
        panel5.setBackground(Color.WHITE);
        panel.add(panel5);

        JLabel zone5 = new JLabel("5");
        zone5.setBounds(0, 24, 170, 200);
        zone5.setForeground(new Color(0x191919));
        zone5.setFont(new Font("Arial", Font.BOLD, 150));
        zone5.setHorizontalAlignment(JLabel.CENTER);
        panel5.add(zone5);

        JPanel panel6 = new JPanel(null);
        panel6.setBounds(1025, 10, 180, 225);
        panel6.setBackground(Color.WHITE);
        panel.add(panel6);

        JLabel zone6 = new JLabel("6");
        zone6.setBounds(0, 24, 170, 200);
        zone6.setForeground(new Color(0x191919));
        zone6.setFont(new Font("Arial", Font.BOLD, 150));
        zone6.setHorizontalAlignment(JLabel.CENTER);
        panel6.add(zone6);

        JPanel panel7 = new JPanel(null);
        panel7.setBounds(75, 245, 180, 225);
        panel7.setBackground(Color.WHITE);
        panel.add(panel7);

        JLabel zone7 = new JLabel("7");
        zone7.setBounds(0, 24, 170, 200);
        zone7.setForeground(new Color(0x191919));
        zone7.setFont(new Font("Arial", Font.BOLD, 150));
        zone7.setHorizontalAlignment(JLabel.CENTER);
        panel7.add(zone7);

        JPanel panel8 = new JPanel(null);
        panel8.setBounds(265, 245, 180, 225);
        panel8.setBackground(Color.WHITE);
        panel.add(panel8);

        JLabel zone8 = new JLabel("8");
        zone8.setBounds(0, 24, 170, 200);
        zone8.setForeground(new Color(0x191919));
        zone8.setFont(new Font("Arial", Font.BOLD, 150));
        zone8.setHorizontalAlignment(JLabel.CENTER);
        panel8.add(zone8);

        JPanel panel9 = new JPanel(null);
        panel9.setBounds(455, 245, 180, 225);
        panel9.setBackground(Color.WHITE);
        panel.add(panel9);

        JLabel zone9 = new JLabel("9");
        zone9.setBounds(0, 24, 170, 200);
        zone9.setForeground(new Color(0x191919));
        zone9.setFont(new Font("Arial", Font.BOLD, 150));
        zone9.setHorizontalAlignment(JLabel.CENTER);
        panel9.add(zone9);

        JPanel panel10 = new JPanel(null);
        panel10.setBounds(645, 245, 180, 225);
        panel10.setBackground(Color.WHITE);
        panel.add(panel10);

        JLabel zone10 = new JLabel("10");
        zone10.setBounds(0, 24, 170, 200);
        zone10.setForeground(new Color(0x191919));
        zone10.setFont(new Font("Arial", Font.BOLD, 150));
        zone10.setHorizontalAlignment(JLabel.CENTER);
        panel10.add(zone10);

        JPanel panel11 = new JPanel(null);
        panel11.setBounds(835, 245, 180, 225);
        panel11.setBackground(Color.WHITE);
        panel.add(panel11);

        JLabel zone11 = new JLabel("11");
        zone11.setBounds(0, 24, 170, 200);
        zone11.setForeground(new Color(0x191919));
        zone11.setFont(new Font("Arial", Font.BOLD, 150));
        zone11.setHorizontalAlignment(JLabel.CENTER);
        panel11.add(zone11);

        JPanel panel12 = new JPanel(null);
        panel12.setBounds(1025, 245, 180, 225);
        panel12.setBackground(Color.WHITE);
        panel.add(panel12);

        JLabel zone12 = new JLabel("12");
        zone12.setBounds(0, 24, 170, 200);
        zone12.setForeground(new Color(0x191919));
        zone12.setFont(new Font("Arial", Font.BOLD, 150));
        zone12.setHorizontalAlignment(JLabel.CENTER);
        panel12.add(zone12);

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new WalkZone1().setVisible(true);
        });
    }
}
