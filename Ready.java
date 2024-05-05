//package name::::

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ready extends JFrame implements ActionListener {
    private ChoiceButtons returnButton, printButton;
    private LogoButton logo;
    

    public Ready() {
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

        JLabel headingLabel = new JLabel("READY TO WALK?");
        headingLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 68)); 
        headingLabel.setForeground(new Color(0x38B6FF));
        heading.add(headingLabel);

        JLabel or1 = new JLabel("or");
        or1.setFont(new Font("Arial", Font.ITALIC, 20)); 
        or1.setBounds(460,605,20,20);
        or1.setForeground(Color.WHITE);
        panel.add(or1);

        JLabel or2 = new JLabel("or");
        or2.setFont(new Font("Arial", Font.ITALIC, 20)); 
        or2.setBounds(780,605,20,20);
        or2.setForeground(Color.WHITE);
        panel.add(or2);
        
        returnButton = new ChoiceButtons("TAKE A PICTURE", "GOT IT!");
        returnButton.setBounds(150, 585, 250, 60);
        returnButton.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 25)); 
        returnButton.addActionListener(this);
        panel.add(returnButton);

        logo = new LogoButton(">");
        logo.setBounds(480, 460, 300, 300);
        logo.setBackground(new Color(0x191919));
        logo.setForeground(Color.WHITE);
        panel.add(logo);

        printButton = new ChoiceButtons("PRINT GUIDE", "SHOW RECEIPT");
        printButton.setBounds(860, 585, 250, 60);
        printButton.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 25)); 
        printButton.addActionListener(this);
        panel.add(printButton);

        panel.add(resultPanel());

    
        return panel;
    }

    private JPanel resultPanel() {

        JPanel panel = new JPanel(null);
        panel.setBounds(40, 150, 1200, 340);
        panel.setBackground(Color.WHITE);

        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == returnButton) {
            dispose(); 
        }
    }
    
    public static void main(String[] args) {
        Ready ready = new Ready();
        ready.setVisible(true);
    }
}