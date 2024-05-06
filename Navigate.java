
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Navigate extends JFrame implements ActionListener {
    private ChoiceButtons returnButton, checkButton, searchButton; 
    private BottomBorderTextField search;

    public Navigate() {
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


        search = new BottomBorderTextField();
        search.setBounds(350, 100, 500, 50);
        search.setFont(new Font("Arial", Font.BOLD, 35));
        search.setForeground(Color.WHITE);
        search.setBorder(null);
        search.setHorizontalAlignment(JTextField.CENTER);
        panel.add(search);

        JLabel enter = new JLabel("ENTER LOCATION");
        enter.setBounds(560, 150, 1000, 30);
        enter.setForeground(Color.decode("#38B6FF"));
        enter.setFont(new Font("Arial", Font.ITALIC, 10));
        panel.add(enter); 

        searchButton = new ChoiceButtons("SEARCH", "SEARCH");
        searchButton.setBounds(870, 100, 150, 50);
        searchButton.setFont(new Font("Arial", Font.PLAIN, 20)); 
        searchButton.addActionListener(this);
        panel.add(searchButton);
        
        returnButton = new ChoiceButtons("RETURN", "HOME");
        returnButton.setBounds(50, 620, 150, 50);
        returnButton.setFont(new Font("Arial", Font.BOLD, 20)); 
        returnButton.addActionListener(this);
        panel.add(returnButton);

        checkButton = new ChoiceButtons("CHECK PATH", "REVIEW");
        checkButton.setBounds(970, 600, 250, 60);
        checkButton.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 25)); 
        checkButton.addActionListener(this);
        panel.add(checkButton);
    
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == returnButton) {
            dispose(); 
        }

        if (e.getSource() == checkButton) {
            SwingUtilities.invokeLater(() -> {
                new IsThisRight().setVisible(true);
            });
        }
    }
    
    public static void main(String[] args) {
        Navigate navigate = new Navigate();
        navigate.setVisible(true);
    }
}
