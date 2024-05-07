//package name::

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Capture extends JFrame implements ActionListener{
    
    LogoButton logo;

    public Capture() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Campus Route Path Navigator");
        setSize(new Dimension(1280, 720));

        setResizable(false);
        setLocationRelativeTo(null);
        setUndecorated(true);
        // setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Change path
        ImageIcon icon = new ImageIcon("");
        setIconImage(icon.getImage());

        add(mainPanel());
    }

    private JPanel mainPanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(0, 0, 1280, 720);
        panel.setBackground(Color.WHITE);
        
        panel.add(outlinePanel());

        return panel;
    }

    private JPanel outlinePanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(80, 80, 1120, 560);
        panel.setBackground(new Color(0x191919));

        panel.add(contentPanel());

        return panel;
    }

    private JPanel contentPanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(5, 5, 1110, 550);
        panel.setBackground(new Color(0x191919));
                       
        JLabel content = new JLabel("THANK YOU FOR CAPTURING!");
        content.setBounds(100, 220, 700, 50);
        content.setForeground(new Color(0x38B6FF));
        content.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 45));
        panel.add(content);

        String note = "<html><div style='text-align: center;'>"
                      + "HAVE A SAFE DAY AND ALWAYS REMEBER, <br>"
                      + "WALK TO THE RIGHT!";
                       
        JLabel remember = new JLabel(note);
        remember.setBounds(225, 245, 600, 100);
        remember.setForeground(Color.WHITE);
        remember.setFont(new Font("Arial", Font.PLAIN | Font.ITALIC, 20));
        panel.add(remember);


        logo = new LogoButton(">");
        logo.setBounds(775, 125, 300, 300);
        logo.setBackground(new Color(0x191919));
        logo.setForeground(Color.WHITE);
        logo.addActionListener(this);
        panel.add(logo);

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
        SwingUtilities.invokeLater(() -> {
            new Capture().setVisible(true);
        });
    }
}
