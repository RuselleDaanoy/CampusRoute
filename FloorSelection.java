//package name::::

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FloorSelection extends JFrame implements ActionListener {
    private ChoiceButtons returnButton;
    private FloorButtonHover[] floorButtons;

    public FloorSelection() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Campus Route Path Navigator");
        setSize(new Dimension(1280, 720));
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);

        // change path as needed
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
        floorButtons = new FloorButtonHover[5]; 
        for (int i = 0; i < floorButtons.length; i++) {
            floorButtons[i] = new FloorButtonHover(); 
            floorButtons[i].setLayout(new BorderLayout());
            floorButtons[i].setBounds(floorX, 178, 180, 370);
            floorButtons[i].setForeground(Color.BLACK);
            floorButtons[i].setBackground(Color.WHITE);
            floorButtons[i].setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 50));

            JLabel floorLabel = new JLabel(Integer.toString(i + 1));
            floorLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 170));
            floorLabel.setHorizontalAlignment(SwingConstants.CENTER);
            floorButtons[i].add(floorLabel, BorderLayout.SOUTH);

            final int floorNumber = i + 1; 
            floorButtons[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    openFloorClass(floorNumber);
                }
            });
            
            panel.add(floorButtons[i]); // Add floor buttons to panel
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
        }
    }

    private void openFloorClass(int floorNumber) {
        switch (floorNumber) {
            case 1:
                Floor1 floor1 = new Floor1();
                floor1.setVisible(true);
                break;
            case 2:
                Floor2 floor2 = new Floor2();
                floor2.setVisible(true);
                break;
            case 3:
                Floor3 floor3 = new Floor3();
                floor3.setVisible(true);
                break;
            case 4:
                Floor4 floor4 = new Floor4();
                floor4.setVisible(true);
                break;
            case 5:
                Floor5 floor5 = new Floor5();
                floor5.setVisible(true);
                break;
            default:
                break;
        }
    }
    
    public static void main(String[] args) {
        FloorSelection floorSelection = new FloorSelection();
        floorSelection.setVisible(true);
    }
}
