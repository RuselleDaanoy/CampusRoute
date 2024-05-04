package finals;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Home extends JFrame implements ActionListener {
    RectangularButtonPanel navigateButton;
    RectangularButtonPanel aboutButton;
    RectangularButtonPanel helpButton;
    RectangularButtonPanel mapButton;

    public Home() {
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
        panel.setBackground(Color.WHITE);

        panel.add(titlePanel());
        panel.add(buttonPanel());
        
        return panel;
    }

    private JPanel titlePanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(0, 0, 900, 720);
        panel.setBackground(new Color(0x191919));

        JLabel header = new JLabel("NEW ERA UNIVERSITY");
        header.setBounds(50, 50, 300, 30);
        header.setForeground(Color.WHITE);
        header.setFont(new Font("Arial", Font.PLAIN, 20));
        panel.add(header);

        JLabel walk = new JLabel("WALK");
        walk.setBounds(90, 150, 600, 180);
        walk.setForeground(Color.WHITE);
        walk.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 180));
        panel.add(walk);

        JLabel trans = new JLabel("TO THE");
        trans.setBounds(110, 320, 200, 40);
        trans.setForeground(Color.WHITE);
        trans.setFont(new Font("Arial", Font.ITALIC, 40));
        panel.add(trans);

        JLabel right = new JLabel("RIGHT");
        right.setBounds(250, 300, 600, 180);
        right.setForeground(new Color(0x38B6FF));
        right.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 180));
        panel.add(right);

        JLabel campus = new JLabel("MAIN CAMPUS");
        campus.setBounds(50, 578, 300, 30);
        campus.setForeground(Color.WHITE);
        campus.setFont(new Font("Arial", Font.PLAIN, 20));
        panel.add(campus);
        
        JLabel building = new JLabel("MAIN BUILDING EDITION");
        building.setBounds(50, 600, 300, 30);
        building.setForeground(new Color(0x38B6FF));
        building.setFont(new Font("Arial", Font.PLAIN, 20));
        panel.add(building);

        return panel;
    }

    private JPanel buttonPanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(900, 0, 380, 720);
        panel.setBackground(Color.WHITE);
    
        JLabel heading1 = new JLabel("FIND YOUR ROUTE,");
        heading1.setBounds(0, 100, 380, 30);
        heading1.setForeground(new Color(0x191919));
        heading1.setFont(new Font("Arial", Font.ITALIC, 28));
        heading1.setHorizontalAlignment(JLabel.CENTER);
        panel.add(heading1);
    
        JLabel heading2 = new JLabel("START A PATH!");
        heading2.setBounds(0, 130, 380, 30);
        heading2.setForeground(new Color(0x191919));
        heading2.setFont(new Font("Arial", Font.ITALIC, 28));
        heading2.setHorizontalAlignment(JLabel.CENTER);
        panel.add(heading2);
    
        navigateButton = new RectangularButtonPanel("NAVIGATE");
        navigateButton.setBounds(60, 210, 260, 60);
        navigateButton.setBackground(new Color(0x191919));
        navigateButton.setForeground(Color.WHITE);
        navigateButton.setFont(new Font("Arial", Font.BOLD, 25));
        navigateButton.setFocusable(false);
        panel.add(navigateButton);
    
        mapButton = new RectangularButtonPanel("MAP");
        mapButton.setBounds(60, 310, 260, 60);
        mapButton.setBackground(new Color(0x191919));
        mapButton.setForeground(Color.WHITE);
        mapButton.setFont(new Font("Arial", Font.BOLD, 25));
        mapButton.setFocusable(false);
        panel.add(mapButton);
    
        aboutButton = new RectangularButtonPanel("ABOUT");
        aboutButton.setBounds(60, 410, 260, 60);
        aboutButton.setBackground(new Color(0x191919));
        aboutButton.setForeground(Color.WHITE);
        aboutButton.setFont(new Font("Arial", Font.BOLD, 25));
        aboutButton.setFocusable(false);
        aboutButton.addActionListener(this);
        panel.add(aboutButton);
    
        helpButton = new RectangularButtonPanel("HELP");
        helpButton.setBounds(60, 510, 260, 60);
        helpButton.setBackground(new Color(0x191919));
        helpButton.setForeground(Color.WHITE);
        helpButton.setFont(new Font("Arial", Font.BOLD, 25));
        helpButton.setFocusable(false);
        panel.add(helpButton);
        
        return panel;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == navigateButton) {
            // Source code goes here...
        }

        if (e.getSource() == mapButton) {
            // Source code goes here...
        }

        if (e.getSource() == aboutButton) {
            new About().setVisible(true);
        }

        if (e.getSource() == helpButton) {
            // Source code goes here...
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Home().setVisible(true);
        });
    }
}
