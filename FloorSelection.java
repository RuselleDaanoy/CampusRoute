// package name here:::

import javax.swing.*;
import java.awt.*;

public class FloorSelection extends JFrame {

    public FloorSelection() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Campus Route");
        setSize(new Dimension(1280, 720));
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // change path
        ImageIcon icon = new ImageIcon("");
        setIconImage(icon.getImage());

        add(mainPanel());
    }

    private JPanel mainPanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(0, 0, 1280, 720);
        panel.setBackground(Color.decode("#191919"));

        JPanel subHeading = new JPanel();
        subHeading.setBounds(500, 50, 300, 38);
        subHeading.setBackground(Color.decode("#191919"));
        panel.add(subHeading);

        JLabel subHeadingLabel = new JLabel("WALK TO THE RIGHT FLOOR");
        subHeadingLabel.setBounds(500, 30, 300, 40);
        subHeadingLabel.setFont(new Font("Arial", Font.BOLD, 20));
        subHeadingLabel.setForeground(Color.decode("#38B6FF"));
        subHeading.add(subHeadingLabel);

        JPanel heading = new JPanel();
        heading.setBounds(100, 70, 1060, 90);
        heading.setBackground(Color.decode("#191919"));
        panel.add(heading);

        JLabel headingLabel = new JLabel("MAIN CAMPUS - MAIN BUILDING");
        headingLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 68)); 
        headingLabel.setForeground(Color.decode("#FFFFFF"));
        heading.add(headingLabel);
    
        // Floor panels
        int floorX = 100;
        for (int i = 1; i <= 5; i++) {
            FloorButtonHover floorPanel = new FloorButtonHover(); //changing from panel to button
            floorPanel.setLayout(new BorderLayout());
            floorPanel.setBounds(floorX, 168, 180, 370);
            floorPanel.setForeground(Color.BLACK);
            floorPanel.setBackground(Color.WHITE);

            JLabel floorLabel = new JLabel(Integer.toString(i));
            floorLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 160));
            floorLabel.setHorizontalAlignment(SwingConstants.CENTER);
            floorPanel.add(floorLabel, BorderLayout.SOUTH);

            panel.add(floorPanel);
            floorX += 220; // adjust the horizontal gaps
        }

        ChoiceButtons returnButton = new ChoiceButtons("RETURN");
        returnButton.setBounds(100, 570, 180, 60);
        panel.add(returnButton);

        ChoiceButtons exploreButton = new ChoiceButtons("EXPLORE");
        exploreButton.setBounds(980, 570, 180, 60);
        panel.add(exploreButton);
    
        return panel;
    }
    
    public static void main(String[] args) {
        FloorSelection floorSelection = new FloorSelection();
        floorSelection.setVisible(true);
    }
}
