
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Floor5 extends JFrame implements ActionListener{

    private ChoiceButtons returnButton;

    public Floor5() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Campus Route Path Navigator");
        setSize(new Dimension(1280, 720));
        setResizable(false);
        setLocationRelativeTo(null);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);

        // change path
        ImageIcon icon = new ImageIcon(getClass().getResource("/WalkToTheRight.png"));
        setIconImage(icon.getImage());

        add(mainPanel());
    }

    private JPanel mainPanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(0, 0, 1280, 720);
        panel.setBackground(Color.decode("#191919"));

        JPanel heading = new JPanel();
        heading.setBounds(100, 40, 1080, 40);
        heading.setBackground(Color.decode("#191919"));
        panel.add(heading);

        JLabel headingLabel = new JLabel("MAIN BUILDING - 5TH FLOOR");
        headingLabel.setFont(new Font("Arial", Font.BOLD, 25)); 
        headingLabel.setForeground(Color.decode("#38B6FF"));
        heading.add(headingLabel);

        ImageIcon floor = new ImageIcon(getClass().getResource("/5th Floor New.png"));
        JLabel floorPlan = new JLabel(floor);
        floorPlan.setBounds(0, 30, 1280, 600);
        panel.add(floorPlan);

        returnButton = new ChoiceButtons("RETURN", "HOME");
        returnButton.setBounds(570, 600, 150, 50);
        returnButton.setFont(new Font("Arial", Font.BOLD, 20)); 
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
        Floor5 floor = new Floor5();
        floor.setVisible(true);
    }
}
