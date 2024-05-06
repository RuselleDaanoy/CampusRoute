// package finals;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WalkZone1 extends JFrame implements ActionListener {
    private FloorButtonHover[] floorButtons;
    
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

        panel.add(zonePanels1());
        panel.add(zonePanels2());

        JLabel footer = new JLabel("READY TO WALK?");
        footer.setBounds(0, 610, 1280, 70);
        footer.setForeground(new Color(0x38B6FF));
        footer.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 70));
        footer.setHorizontalAlignment(JLabel.CENTER);
        panel.add(footer);

        return panel;
    }

    private JPanel zonePanels1() {
        JPanel panel = new JPanel(null);
        panel.setBounds(0, 110, 1280, 240);
        panel.setBackground(new Color(0x191919));

        int floorX = 75;
        floorButtons = new FloorButtonHover[6]; 
        for (int i = 0; i < floorButtons.length; i++) {
            floorButtons[i] = new FloorButtonHover(); 
            floorButtons[i].setLayout(new BorderLayout());
            floorButtons[i].setBounds(floorX, 10, 180, 225);
            floorButtons[i].setForeground(Color.BLACK);
            floorButtons[i].setBackground(Color.WHITE);
            floorButtons[i].setFont(new Font("Arial", Font.BOLD, 50));

            JLabel floorLabel = new JLabel(Integer.toString(i + 1));
            floorLabel.setFont(new Font("Arial", Font.BOLD, 150));
            floorLabel.setHorizontalAlignment(SwingConstants.CENTER);
            floorButtons[i].add(floorLabel, BorderLayout.SOUTH);
            
            panel.add(floorButtons[i]); // Add floor buttons to panel
            floorX += 190; // adjust the horizontal gaps
        }

        return panel;
    }

    private JPanel zonePanels2() {
        JPanel panel = new JPanel(null);
        panel.setBounds(0, 350, 1280, 240);
        panel.setBackground(new Color(0x191919));

        int floorX = 75;
        floorButtons = new FloorButtonHover[12]; 
        for (int i = 6; i < floorButtons.length; i++) {
            floorButtons[i] = new FloorButtonHover(); 
            floorButtons[i].setLayout(new BorderLayout());
            floorButtons[i].setBounds(floorX, 5, 180, 225);
            floorButtons[i].setForeground(Color.BLACK);
            floorButtons[i].setBackground(Color.WHITE);
            floorButtons[i].setFont(new Font("Arial", Font.BOLD, 50));

            JLabel floorLabel = new JLabel(Integer.toString(i + 1));
            floorLabel.setFont(new Font("Arial", Font.BOLD, 150));
            floorLabel.setHorizontalAlignment(SwingConstants.CENTER);
            floorButtons[i].add(floorLabel, BorderLayout.SOUTH);
            
            panel.add(floorButtons[i]); // Add floor buttons to panel
            floorX += 190; // adjust the horizontal gaps
        }

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new WalkZone1().setVisible(true);
        });
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
