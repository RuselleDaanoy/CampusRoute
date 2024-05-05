
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class About extends JFrame implements ActionListener {
    private ChoiceButtons returnButton;

    public About() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Campus Route Path Navigator");
        setSize(new Dimension(1280, 720));

        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);

        // Change file path for it to display
        ImageIcon icon = new ImageIcon("C:\\\\Users\\\\thoby\\\\WALK\\\\src\\\\W.png");
        setIconImage(icon.getImage());

        add(mainPanel());
    }

    private JPanel mainPanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(0, 0, 1280, 720);
        panel.setBackground(new Color(0x191919));

        panel.add(titlePanel());
        panel.add(contentPanel());
        
        return panel;
    }

    private JPanel titlePanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(200, 20, 780, 320);
        panel.setBackground(new Color(0x191919));

        JLabel walk = new JLabel("WALK");
        walk.setBounds(330, 80, 400, 100);
        walk.setForeground(Color.WHITE);
        walk.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 100));
        panel.add(walk);

        JLabel trans = new JLabel("TO THE");
        trans.setBounds(330, 170, 1280, 30);
        trans.setForeground(Color.WHITE);
        trans.setFont(new Font("Arial", Font.ITALIC, 25));
        panel.add(trans);

        JLabel right = new JLabel("RIGHT");
        right.setBounds(420, 170, 400, 100);
        right.setForeground(new Color(0x38B6FF));
        right.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 100));
        panel.add(right);

        //ImageIcon logo = new ImageIcon("C:\\Users\\thoby\\WALK\\src\\LOGO.png");
        //JLabel logoLabel = new JLabel(logo);
        //logoLabel.setBounds(0, 70, 400, 200);
        //panel.add(logoLabel);

        LogoButton logo = new LogoButton(">");
        logo.setBounds(70, 30, 300, 300);
        logo.setBackground(new Color(0x191919));
        logo.setForeground(Color.WHITE);

        panel.add(logo);
        

        return panel;
    }

    private JPanel contentPanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(0, 270, 1280, 490);
        panel.setBackground(new Color(0x191919));

        //'WALK TO YOUR RIGHT' is an innovative project developed as part 
        //of the Design and Analysis of Algorithm course. The project aims 
        //to streamline navigation within the Main Building 
        //of New Era University - Main Campus for its residents. 
        //Leveraging primarily the Dijkstra Algorithm, the system provides efficient guidance 
        //through the complex layout of the building.

        String note = "<html><div style='text-align: center;'>"
                    + "is an innovative project developed as part of the Design and Analysis of Algorithm course.<br>"
                    + "The project aims to streamline navigation within the Main Building of New Era University - Main Campus for its residents and visitors. <br>"
                    + "Leveraging primarily the Dijkstra Algorithm, the system provides efficient guidance through the complex layout of the building. <br><br>"

                    + "Programmed by <br>"
                    + "Faye Camille Buri, Venus Ruselle B. Daanoy, Pia Katleya V. Macalanda, and Thoby Jim R. Ralleta<br>"
                    + "Bachelor of Science in Computer Science | 2BSCS-1";
        
        JLabel description = new JLabel(note);
        description.setBounds(0, 20, 1280, 300);
        description.setForeground(Color.WHITE);
        description.setFont(new Font("Arial", Font.ITALIC, 18));
        description.setHorizontalAlignment(JLabel.CENTER);
        panel.add(description);

        returnButton = new ChoiceButtons("RETURN", "HOME");
        returnButton.setBounds(580, 330, 130, 40);
        returnButton.setBackground(new Color(0x191919));
        returnButton.setForeground(Color.WHITE);
        returnButton.setFont(new Font("Arial", Font.BOLD, 20));
        returnButton.setFocusable(false);
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
        SwingUtilities.invokeLater(() -> {
            new About().setVisible(true);
        });
    }
}
