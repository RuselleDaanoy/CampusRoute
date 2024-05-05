// package name here:::

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FloorSelection extends JFrame implements ActionListener{

    private ChoiceButtons returnButton;

    public FloorSelection() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Campus Route Path Navigator");
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
        subHeading.setBounds(420, 50, 430, 38);
        subHeading.setBackground(Color.decode("#191919"));
        panel.add(subHeading);

        JLabel subHeadingLabel = new JLabel("WALK TO THE RIGHT FLOOR");
        subHeadingLabel.setBounds(420, 60, 300, 30);
        subHeadingLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        subHeadingLabel.setForeground(Color.decode("#38B6FF"));
        subHeading.add(subHeadingLabel);

        JPanel heading = new JPanel();
        heading.setBounds(100, 70, 1080, 90);
        heading.setBackground(Color.decode("#191919"));
        panel.add(heading);

        JLabel headingLabel = new JLabel("MAIN CAMPUS - MAIN BUILDING");
        headingLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 68)); 
        headingLabel.setForeground(Color.WHITE);
        heading.add(headingLabel);

        // Floor panels
        int floorX = 100;
        for (int i = 1; i <= 5; i++) {
            FloorButtonHover floorPanel = new FloorButtonHover(); //changing from panel to button
            floorPanel.setLayout(new BorderLayout());
            floorPanel.setBounds(floorX, 178, 180, 370);
            floorPanel.setForeground(Color.BLACK);
            floorPanel.setBackground(Color.WHITE);
            floorPanel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 50));

            JLabel floorLabel = new JLabel(Integer.toString(i));
            floorLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 170));
            floorLabel.setHorizontalAlignment(SwingConstants.CENTER);
            floorPanel.add(floorLabel, BorderLayout.SOUTH);

            panel.add(floorPanel);
            floorX += 220; // adjust the horizontal gaps
        }

        returnButton = new ChoiceButtons("RETURN", "HOME");
        returnButton.setBounds(560, 600, 130, 40);
        returnButton.setFont(new Font("Arial", Font.BOLD, 20)); 
        returnButton.addActionListener(this);
        panel.add(returnButton);
    
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == returnButton) {
            dispose(); 
        }
    }
    
    public static void main(String[] args) {
        FloorSelection floorSelection = new FloorSelection();
        floorSelection.setVisible(true);
    }
}
