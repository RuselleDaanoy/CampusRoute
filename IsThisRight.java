//package name::::

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class IsThisRight extends JFrame implements ActionListener {
    private ChoiceButtons returnButton, printButton; 

    public IsThisRight() {
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

        JPanel heading = new JPanel();
        heading.setBounds(120, 40, 1080, 90);
        heading.setBackground(Color.decode("#191919"));
        panel.add(heading);

        JLabel headingLabel = new JLabel("IS THIS RIGHT?");
        headingLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 68)); 
        headingLabel.setForeground(new Color(0x38B6FF));
        heading.add(headingLabel);

        JLabel or1 = new JLabel("or");
        or1.setFont(new Font("Arial", Font.ITALIC, 20)); 
        or1.setBounds(650,590,20,20);
        or1.setForeground(Color.WHITE);
        panel.add(or1);
        
        returnButton = new ChoiceButtons("ADD MORE", "+");
        returnButton.setBounds(350, 570, 250, 60);
        returnButton.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 25)); 
        returnButton.addActionListener(this);
        panel.add(returnButton);

        printButton = new ChoiceButtons("GET DIRECTIONS", "SHOW PATH");
        printButton.setBounds(710, 570, 250, 60);
        printButton.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 25)); 
        printButton.addActionListener(this);
        panel.add(printButton);

        panel.add(resultPanel());

    
        return panel;
    }

    private JPanel resultPanel() {

        JPanel panel = new JPanel(null);
        panel.setBounds(40, 150, 1200, 340);
        panel.setBackground(new Color(0x191919));

        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == returnButton) {
            dispose(); 
        }
    }
    
    public static void main(String[] args) {
        IsThisRight isThisRight = new IsThisRight();
        isThisRight.setVisible(true);
    }
}