//package name::::

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HelpReady extends JFrame implements ActionListener {
    private ChoiceButtons printButton, pictureButton;
    private LogoButton logo;
    

    public HelpReady() {
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

        String note = "<html><div style='text-align: center;'>"
                       + "Your directions display here.";
                       
        JLabel content = new JLabel(note);
        content.setBounds(375, 270, 700, 100);
        content.setForeground(Color.decode("#191919"));
        content.setFont(new Font("Arial", Font.PLAIN, 40));
        panel.add(content);

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
        
        pictureButton = new ChoiceButtons("TAKE A PICTURE", "GOT IT!");
        pictureButton.setBounds(150, 585, 250, 60);
        pictureButton.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 25)); 
        pictureButton.addActionListener(this);
        panel.add(pictureButton);

        JLabel screen = new JLabel("Capture your guide through the screen");
        screen.setFont(new Font("Arial", Font.ITALIC, 15)); 
        screen.setBounds(145,650,300,25);
        screen.setForeground(new Color(0x38B6FF));
        panel.add(screen);

        logo = new LogoButton(">");
        logo.setBounds(480, 460, 300, 300);
        logo.setBackground(new Color(0x191919));
        logo.setForeground(Color.WHITE);
        logo.addActionListener(this);
        panel.add(logo);

        JLabel restart = new JLabel("Restart / return to home");
        restart.setFont(new Font("Arial", Font.ITALIC, 15)); 
        restart.setBounds(550,495,300,25);
        restart.setForeground(new Color(0x38B6FF));
        panel.add(restart);

        printButton = new ChoiceButtons("PRINT GUIDE", "SHOW RECEIPT");
        printButton.setBounds(860, 585, 250, 60);
        printButton.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 25)); 
        printButton.addActionListener(this);
        panel.add(printButton);

        JLabel physical = new JLabel("Have a physical print of your guide");
        physical.setFont(new Font("Arial", Font.ITALIC, 15)); 
        physical.setBounds(870,650,300,25);
        physical.setForeground(new Color(0x38B6FF));
        panel.add(physical);

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
       
        if (e.getSource() == logo) {
            disposeAllFrames(); 
            SwingUtilities.invokeLater(() -> {
                new Home().setVisible(true);
            });
        }
       
        if (e.getSource() == pictureButton) {
        }

        if (e.getSource() == printButton) {
        }
    }

    private void disposeAllFrames() {
        Window[] windows = Window.getWindows();
        for (Window window : windows) {
            if (window instanceof JFrame) {
            window.dispose();
            }
        }
    }

    
    public static void main(String[] args) {
        HelpReady ready = new HelpReady();
        ready.setVisible(true);
    }
}