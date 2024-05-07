 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HelpNavigate extends JFrame implements ActionListener {
    private ChoiceButtons returnButton, checkButton, searchButton; 
    private BottomBorderTextField search;

    public HelpNavigate() {
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
        search.setText("ENTER TEXT HERE");
        search.setBounds(350, 100, 500, 50);
        search.setFont(new Font("Arial", Font.BOLD, 35));
        search.setForeground(Color.WHITE);
        search.setBorder(null);
        search.setHorizontalAlignment(JTextField.CENTER);
        search.setEditable(false);
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


        String note = "<html><div style='text-align: center;'>"
                       + "Points or locations will appear here<br>"
                       + "after clicking 'SEARCH' button.";
                       
        JLabel content = new JLabel(note);
        content.setBounds(355, 335, 500, 100);
        content.setForeground(Color.WHITE);
        content.setFont(new Font("Arial", Font.PLAIN, 20));
        panel.add(content);

        AddRemoveButtons add = new AddRemoveButtons("+", Color.WHITE);
        add.setBounds(790, 275, 70, 50);
        panel.add(add);
                       
        JLabel plusLabel = new JLabel("Add point to your path");
        plusLabel.setBounds(750, 300, 500, 100);
        plusLabel.setForeground(Color.WHITE);
        plusLabel.setFont(new Font("Arial", Font.ITALIC, 15));
        panel.add(plusLabel);

        AddRemoveButtons remove = new AddRemoveButtons("-", Color.decode("#38B6FF"));
        remove.setBounds(780, 400, 100, 50);
        panel.add(remove);
                       
        JLabel minusLabel = new JLabel("Remove point from your path");
        minusLabel.setBounds(730, 425, 500, 100);
        minusLabel.setForeground(Color.decode("#38B6FF"));
        minusLabel.setFont(new Font("Arial", Font.ITALIC, 15));
        panel.add(minusLabel);
        
        returnButton = new ChoiceButtons("RETURN", "HOME");
        returnButton.setBounds(50, 620, 150, 50);
        returnButton.setFont(new Font("Arial", Font.BOLD, 20)); 
        returnButton.addActionListener(this);
        panel.add(returnButton);

        JLabel see = new JLabel("See what you added");
        see.setBounds(1020, 530, 500, 100);
        see.setForeground(Color.decode("#38B6FF"));
        see.setFont(new Font("Arial", Font.ITALIC, 15));
        panel.add(see);

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
            new HelpIsThisRight().setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        HelpNavigate help = new HelpNavigate();
        help.setVisible(true);
    }
}
