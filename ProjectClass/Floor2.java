
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Floor2 extends JFrame implements ActionListener{

    ChoiceButtons returnButton;
    NoBorderButtons footer;

    public Floor2() {
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

        JLabel headingLabel = new JLabel("MAIN BUILDING - 2ND FLOOR");
        headingLabel.setFont(new Font("Arial", Font.BOLD, 25)); 
        headingLabel.setForeground(Color.decode("#38B6FF"));
        heading.add(headingLabel);

        ImageIcon floor = new ImageIcon(getClass().getResource("/2nd Floor with Zone.png"));
        JLabel floorPlan = new JLabel(floor);
        floorPlan.setBounds(0, 30, 1280, 600);
        panel.add(floorPlan);

        returnButton = new ChoiceButtons("RETURN", "HOME");
        returnButton.setBounds(80, 620, 150, 50);
        returnButton.setFont(new Font("Arial", Font.BOLD, 20)); 
        returnButton.addActionListener(this);
        panel.add(returnButton);

        footer = new NoBorderButtons("PICK ZONE", Color.decode("#38B6FF"));
        footer.setBounds(330, 610, 600, 70);
        footer.setForeground(new Color(0x38B6FF));
        footer.setHorizontalAlignment(JLabel.CENTER);
        footer.addActionListener(this);
        panel.add(footer);

        return panel;
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == returnButton) {
            dispose();
        }

        if (e.getSource() == footer) {
            SwingUtilities.invokeLater(() -> {
                new WalkZone2().setVisible(true);
            });
        }
    }
    
    public static void main(String[] args) {
        Floor2 floor = new Floor2();
        floor.setVisible(true);
    }
}
