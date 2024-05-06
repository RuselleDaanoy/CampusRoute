//package name::::

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class IsThisRight extends JFrame implements ActionListener {
    private ChoiceButtons moreButton, directionsButton; 

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
        
        moreButton = new ChoiceButtons("ADD MORE", "+");
        moreButton.setBounds(350, 570, 250, 60);
        moreButton.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 25)); 
        moreButton.addActionListener(this);
        panel.add(moreButton);

        JLabel forgot = new JLabel("Forgot a point?");
        forgot.setFont(new Font("Arial", Font.ITALIC, 15)); 
        forgot.setBounds(420,635,200,25);
        forgot.setForeground(new Color(0x38B6FF));
        panel.add(forgot);

        directionsButton = new ChoiceButtons("GET DIRECTIONS", "RIGHT");
        directionsButton.setBounds(710, 570, 250, 60);
        directionsButton.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 25)); 
        directionsButton.addActionListener(this);
        panel.add(directionsButton);

        JLabel turn = new JLabel("There's no turning back.");
        turn.setFont(new Font("Arial", Font.ITALIC, 15)); 
        turn.setBounds(755,635,200,25);
        turn.setForeground(new Color(0x38B6FF));
        panel.add(turn);

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
        if (e.getSource() == moreButton) {
            dispose(); 
        }

        if (e.getSource() == directionsButton) {
            SwingUtilities.invokeLater(() -> {
                new Ready().setVisible(true);
            });
        }
    }
    
    public static void main(String[] args) {
        IsThisRight isThisRight = new IsThisRight();
        isThisRight.setVisible(true);
    }
}
