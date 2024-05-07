//package name::::

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FloorDirectory extends JFrame implements ActionListener {
    private ChoiceButtons returnButton;
    private FloorButtonHover[] floorButtons;
    private JPanel mainPanel;

    public FloorDirectory() {
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
        ImageIcon icon = new ImageIcon(getClass().getResource("/WalkToTheRight.png"));
        setIconImage(icon.getImage());

        mainPanel();
        add(this.mainPanel);
    }

    private void mainPanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(0, 0, 1280, 720);
        panel.setBackground(Color.decode("#191919"));

        JPanel subHeading = new JPanel();
        subHeading.setBounds(420, 40, 430, 38);
        subHeading.setBackground(Color.decode("#191919"));
        panel.add(subHeading);

        JLabel subHeadingLabel = new JLabel("WALK TO THE RIGHT");
        subHeadingLabel.setBounds(420, 60, 300, 30);
        subHeadingLabel.setFont(new Font("Arial", Font.BOLD, 20));
        subHeadingLabel.setForeground(Color.decode("#38B6FF"));
        subHeading.add(subHeadingLabel);

        JPanel heading = new JPanel();
        heading.setBounds(100, 70, 1080, 90);
        heading.setBackground(Color.decode("#191919"));
        panel.add(heading);

        JLabel headingLabel = new JLabel("MAIN CAMPUS - MAIN BUILDING");
        headingLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 68)); 
        headingLabel.setForeground(Color.WHITE);
        heading.add(headingLabel);

        returnButton = new ChoiceButtons("RETURN", "HOME");
        returnButton.setBounds(560, 620, 130, 40);
        returnButton.setFont(new Font("Arial", Font.BOLD, 20)); 
        returnButton.addActionListener(this);
        panel.add(returnButton);
        panel.add(floorPanel());
    
        this.mainPanel = panel;
    }

    private JPanel floorPanel(){

        JPanel panel = new JPanel(null);
        panel.setBounds(265, 90, 100, 500);
        panel.setBackground(Color.decode("#191919"));

        int floorX = 100;
        floorButtons = new FloorButtonHover[5]; 
        for (int i = 0; i < floorButtons.length; i++) {
            floorButtons[i] = new FloorButtonHover(); 
            floorButtons[i].setLayout(new BorderLayout());
            floorButtons[i].setBounds(0, floorX, 80, 70);
            floorButtons[i].setForeground(Color.BLACK);
            floorButtons[i].setBackground(Color.WHITE);
            floorButtons[i].setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 50));

            JLabel floorLabel = new JLabel(Integer.toString(i + 1));
            floorLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 50));
            floorLabel.setHorizontalAlignment(SwingConstants.CENTER);
            floorButtons[i].add(floorLabel, BorderLayout.CENTER);

            final int floorNumber = i + 1; 
            floorButtons[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    openFloorClass(floorNumber);
                }
            });
            
            floorX += 80; // adjust the horizontal gaps

            panel.add(floorButtons[i]); 
    }
            return panel;
}

    private JScrollPane directory(String targetFloor){
        JScrollPane panel = new JScrollPane();
        panel.setBounds(370, 190, 600, 390);
        panel.setBackground(Color.WHITE);

        ZoneRoom zf = new ZoneRoom(targetFloor);

        JTextArea textArea = new JTextArea(zf.getRoomsText());
        textArea.setEditable(false);
        textArea.setFont(new Font("Courier New", Font.BOLD, 20));
        textArea.setForeground(Color.decode("#191919"));
        textArea.setMargin(new Insets(10, 10, 10, 10));
        
        panel.setViewportView(textArea);
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == returnButton) {
            dispose(); 
        }
    }

    private void openFloorClass(int floorNumber) {
        switch (floorNumber) {
            case 1:
           
            for(Component comp : mainPanel.getComponents()) {
                if(comp instanceof JScrollPane) {
                    mainPanel.remove(comp);
                    break;
                }
            }
               this.mainPanel.add(directory("Floor 1"));
               this.mainPanel.revalidate();
               this.mainPanel.repaint();
               break;
            case 2:

            for(Component comp : mainPanel.getComponents()) {
                if(comp instanceof JScrollPane) {
                    mainPanel.remove(comp);
                    break;
                }
            }
                this.mainPanel.add(directory("Floor 2"));
                this.mainPanel.revalidate();
                this.mainPanel.repaint();
                break;
            case 3:
            for(Component comp : mainPanel.getComponents()) {
                if(comp instanceof JScrollPane) {
                    mainPanel.remove(comp);
                    break;
                }
            }
                this.mainPanel.add(directory("Floor 3"));
                this.mainPanel.revalidate();
                this.mainPanel.repaint();
                break;
            case 4:
            for(Component comp : mainPanel.getComponents()) {
                if(comp instanceof JScrollPane) {
                    mainPanel.remove(comp);
                    break;
                }
            }
            this.mainPanel.add(directory("Floor 4"));
            this.mainPanel.revalidate();
            this.mainPanel.repaint();
                break;
            case 5:
            for(Component comp : mainPanel.getComponents()) {
                if(comp instanceof JScrollPane) {
                    mainPanel.remove(comp);
                    break;
                }
            }
            this.mainPanel.add(directory("Floor 5"));
            this.mainPanel.revalidate();
            this.mainPanel.repaint();
                break;
            default:
                break;
        }
    }
    
    public static void main(String[] args) {
        FloorDirectory floorSelection = new FloorDirectory();
        floorSelection.setVisible(true);
    }
}
