//package name::::::

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FloorSelection extends JFrame implements ActionListener {
    private ChoiceButtons returnButton; 

    public FloorSelection() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Campus Route");
        setSize(new Dimension(1280, 720));
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Change the path to your image file for the icon
        ImageIcon icon = new ImageIcon("C:\\Users\\rusel\\Downloads\\WalkToTheRight.png");
        setIconImage(icon.getImage());

        JPanel mainPanel = new JPanel(null);
        mainPanel.setBounds(0, 0, 1280, 720);
        mainPanel.setBackground(Color.decode("#191919"));
        
        JPanel subHeading = new JPanel();
        subHeading.setBounds(500, 50, 300, 38);
        subHeading.setBackground(Color.decode("#191919"));
        mainPanel.add(subHeading);

        JLabel subHeadingLabel = new JLabel("WALK TO THE RIGHT FLOOR");
        subHeadingLabel.setBounds(500, 30, 300, 40);
        subHeadingLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        subHeadingLabel.setForeground(Color.decode("#38B6FF"));
        subHeading.add(subHeadingLabel);

        JPanel heading = new JPanel();
        heading.setBounds(100, 70, 1060, 90);
        heading.setBackground(Color.decode("#191919"));
        mainPanel.add(heading);

        JLabel headingLabel = new JLabel("MAIN CAMPUS - MAIN BUILDING");
        headingLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 68));
        headingLabel.setForeground(Color.decode("#FFFFFF"));
        heading.add(headingLabel);

        // Floor panels
        int floorX = 100;
        for (int i = 1; i <= 5; i++) {
            JPanel floorPanel = new JPanel();
            floorPanel.setLayout(new BorderLayout());
            floorPanel.setBounds(floorX, 168, 180, 370);
            floorPanel.setForeground(Color.BLACK);
            floorPanel.setBackground(Color.WHITE);

            JLabel floorLabel = new JLabel(Integer.toString(i));
            floorLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 160));
            floorLabel.setHorizontalAlignment(SwingConstants.CENTER);
            floorPanel.add(floorLabel, BorderLayout.SOUTH);

            mainPanel.add(floorPanel);
            floorX += 220; // adjust the horizontal gaps
        }

        returnButton = new ChoiceButtons("RETURN");
        returnButton.setBounds(100, 570, 180, 60);
        returnButton.addActionListener(this); 
        mainPanel.add(returnButton);

        add(mainPanel);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == returnButton) {
            dispose(); 
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FloorSelection().setVisible(true);
        });
    }
}
