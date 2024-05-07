

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Floor4 extends JFrame implements ActionListener{

    private ChoiceButtonsWhiteBG returnButton;

    public Floor4() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Campus Route Path Navigator");
        setSize(new Dimension(1280, 720));
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);

        // change path
        ImageIcon icon = new ImageIcon("");
        setIconImage(icon.getImage());

        add(mainPanel());
    }

    private JPanel mainPanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(0, 0, 1280, 720);
        panel.setBackground(Color.WHITE);

        JPanel subHeading = new JPanel();
        subHeading.setBounds(500, 50, 300, 35);
        subHeading.setBackground(Color.WHITE);
        panel.add(subHeading);

        JLabel subHeadingLabel = new JLabel("WALK TO THE RIGHT ROOM");
        subHeadingLabel.setBounds(420, 60, 300, 30);
        subHeadingLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        subHeadingLabel.setForeground(Color.decode("#38B6FF"));
        subHeading.add(subHeadingLabel);

        JPanel heading = new JPanel();
        heading.setBounds(100, 70, 1080, 90);
        heading.setBackground(Color.WHITE);
        panel.add(heading);

        JLabel headingLabel = new JLabel("MAIN BUILDING - FLOOR 4");
        headingLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 68)); 
        headingLabel.setForeground(Color.decode("#191919"));
        heading.add(headingLabel);

        ImageIcon floor = new ImageIcon("C:\\Users\\thoby\\WALK\\src\\4th Floor.png");
        JLabel floorPlan = new JLabel(floor);
        floorPlan.setBounds(0, 60, 1280, 600);
        panel.add(floorPlan);

        returnButton = new ChoiceButtonsWhiteBG("RETURN", "FLOOR");
        returnButton.setBounds(560, 600, 130, 40);
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
        Floor4 floor = new Floor4();
        floor.setVisible(true);
    }
}
