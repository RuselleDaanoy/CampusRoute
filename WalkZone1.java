// package finals;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class WalkZone1 extends JFrame implements ActionListener {
    private NoBorderButtons footer;
    private FloorButtonHover one, two, three, four, five, six, seven, eight, nine, ten, eleven, twelve;
    private ArrayList<JPanel> clickedPanels;
    
    public WalkZone1() {
        initComponents();
        clickedPanels = new ArrayList<>();
    }

    private void initComponents() {
        setTitle("Campus Route Path Navigator");
        setSize(new Dimension(1280, 720));

        setResizable(false);
        setLocationRelativeTo(null);
        setUndecorated(true);
        // setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Change file path as needed
        ImageIcon icon = new ImageIcon("C:\\Users\\kamil\\OneDrive\\Desktop\\Kiosk\\demo\\src\\main\\resources\\WalkToTheRight.png");
        setIconImage(icon.getImage());

        add(mainPanel());
    }

    private JPanel mainPanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(0, 0, 1280, 720);
        panel.setBackground(new Color(0x191919));

        JLabel heading = new JLabel("WALK TO THE RIGHT ZONES");
        heading.setBounds(0, 40, 1280, 68);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 50));
        heading.setHorizontalAlignment(JLabel.CENTER);
        panel.add(heading);

        panel.add(zonePanels());

        footer = new NoBorderButtons("READY TO WALK?", Color.decode("#38B6FF"));
        footer.setBounds(0, 610, 1280, 70);
        footer.setForeground(new Color(0x38B6FF));
        footer.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 70));
        footer.setHorizontalAlignment(JLabel.CENTER);
        footer.addActionListener(this);
        panel.add(footer);

        return panel;
    }

    private JPanel zonePanels() {
        JPanel panel = new JPanel(null);
        panel.setBounds(0, 110, 1280, 480);
        panel.setBackground(new Color(0x191919));

        one = new FloorButtonHover();
        one.setBounds(75, 20, 180, 215);
        one.setBackground(Color.WHITE);
        panel.add(one);

        JLabel zone1 = new JLabel("1");
        zone1.setFont(new Font("Arial", Font.BOLD, 150));
        zone1.setHorizontalAlignment(SwingConstants.CENTER);
        one.setLayout(new BorderLayout());
        one.add(zone1, BorderLayout.CENTER);

        two = new FloorButtonHover();
        two.setBounds(265, 20, 180, 215);
        two.setBackground(Color.WHITE);
        panel.add(two);

        JLabel zone2 = new JLabel("2");
        zone2.setFont(new Font("Arial", Font.BOLD, 150));
        zone2.setHorizontalAlignment(SwingConstants.CENTER);
        two.setLayout(new BorderLayout());
        two.add(zone2, BorderLayout.CENTER);

        three = new FloorButtonHover();
        three.setBounds(455, 20, 180, 215);
        three.setBackground(Color.WHITE);
        panel.add(three);

        JLabel zone3 = new JLabel("3");
        zone3.setFont(new Font("Arial", Font.BOLD, 150));
        zone3.setHorizontalAlignment(SwingConstants.CENTER);
        three.setLayout(new BorderLayout());
        three.add(zone3, BorderLayout.CENTER);

        four = new FloorButtonHover();
        four.setBounds(645, 20, 180, 215);
        four.setBackground(Color.WHITE);
        panel.add(four);

        JLabel zone4 = new JLabel("4");
        zone4.setFont(new Font("Arial", Font.BOLD, 150));
        zone4.setHorizontalAlignment(SwingConstants.CENTER);
        four.setLayout(new BorderLayout());
        four.add(zone4, BorderLayout.CENTER);

        five = new FloorButtonHover();
        five.setBounds(835, 20, 180, 215);
        five.setBackground(Color.WHITE);
        panel.add(five);

        JLabel zone5 = new JLabel("5");
        zone5.setFont(new Font("Arial", Font.BOLD, 150));
        zone5.setHorizontalAlignment(SwingConstants.CENTER);
        five.setLayout(new BorderLayout());
        five.add(zone5, BorderLayout.CENTER);

        six = new FloorButtonHover();
        six.setBounds(1025, 20, 180, 215);
        six.setBackground(Color.WHITE);
        panel.add(six);

        JLabel zone6 = new JLabel("6");
        zone6.setFont(new Font("Arial", Font.BOLD, 150));
        zone6.setHorizontalAlignment(SwingConstants.CENTER);
        six.setLayout(new BorderLayout());
        six.add(zone6, BorderLayout.CENTER);

        seven = new FloorButtonHover();
        seven.setBounds(75, 245, 180, 215);
        seven.setBackground(Color.WHITE);
        panel.add(seven);

        JLabel zone7 = new JLabel("7");
        zone7.setFont(new Font("Arial", Font.BOLD, 150));
        zone7.setHorizontalAlignment(SwingConstants.CENTER);
        seven.setLayout(new BorderLayout());
        seven.add(zone7, BorderLayout.CENTER);

        eight = new FloorButtonHover();
        eight.setBounds(265, 245, 180, 215);
        eight.setBackground(Color.WHITE);
        panel.add(eight);

        JLabel zone8 = new JLabel("8");
        zone8.setFont(new Font("Arial", Font.BOLD, 150));
        zone8.setHorizontalAlignment(SwingConstants.CENTER);
        eight.setLayout(new BorderLayout());
        eight.add(zone8, BorderLayout.CENTER);

        nine = new FloorButtonHover();
        nine.setBounds(455, 245, 180, 215);
        nine.setBackground(Color.WHITE);
        panel.add(nine);

        JLabel zone9 = new JLabel("9");
        zone9.setFont(new Font("Arial", Font.BOLD, 150));
        zone9.setHorizontalAlignment(SwingConstants.CENTER);
        nine.setLayout(new BorderLayout());
        nine.add(zone9, BorderLayout.CENTER);

        ten = new FloorButtonHover();
        ten.setBounds(645, 245, 180, 215);
        ten.setBackground(Color.WHITE);
        panel.add(ten);

        JLabel zone10 = new JLabel("10");
        zone10.setFont(new Font("Arial", Font.BOLD, 150));
        zone10.setHorizontalAlignment(SwingConstants.CENTER);
        ten.setLayout(new BorderLayout());
        ten.add(zone10, BorderLayout.CENTER);

        eleven = new FloorButtonHover();
        eleven.setBounds(835, 245, 180, 215);
        eleven.setBackground(Color.WHITE);
        panel.add(eleven);

        JLabel zone11 = new JLabel("11");
        zone11.setFont(new Font("Arial", Font.BOLD, 150));
        zone11.setHorizontalAlignment(SwingConstants.CENTER);
        eleven.setLayout(new BorderLayout());
        eleven.add(zone11, BorderLayout.CENTER);

        twelve = new FloorButtonHover();
        twelve.setBounds(1025, 245, 180, 215);
        twelve.setBackground(Color.WHITE);
        panel.add(twelve);

        JLabel zone12 = new JLabel("12");
        zone12.setFont(new Font("Arial", Font.BOLD, 150));
        zone12.setHorizontalAlignment(SwingConstants.CENTER);
        twelve.setLayout(new BorderLayout());
        twelve.add(zone12, BorderLayout.CENTER);

        return panel;
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == footer) {
            if (clickedPanels.isEmpty()) {
                showErrorDialog("Choose a zone to visit!");
            } else {
                new Ready().setVisible(true);
                dispose();
            }
        }
    }

    private void showErrorDialog(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new WalkZone1().setVisible(true);
        });
    }
}
