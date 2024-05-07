import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ready extends JFrame implements ActionListener {
    private ChoiceButtons printButton, pictureButton;
    private LogoButton logo;
    private int[][] nodes;
    private String[][] directions;
    private int zoneNumber;
    String result, vertical;

    public Ready(int[][] nodes, String[][] directions, int zoneNumber) {
        this.nodes = nodes;
        this.directions = directions;
        this.zoneNumber = zoneNumber;
        initComponents();
    }

    private void initComponents() {
        setTitle("Campus Route Path Navigator");
        setSize(new Dimension(1280, 720));
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);

        ImageIcon icon = new ImageIcon(getClass().getResource("/WalkToTheRight.png"));
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

        logo = new LogoButton(">");
        logo.setBounds(480, 460, 300, 300);
        logo.setBackground(new Color(0x191919));
        logo.setForeground(Color.WHITE);
        logo.addActionListener(this);
        panel.add(logo);

        printButton = new ChoiceButtons("PRINT GUIDE", "SHOW RECEIPT");
        printButton.setBounds(860, 585, 250, 60);
        printButton.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 25)); 
        printButton.addActionListener(this);
        panel.add(printButton);

        panel.add(resultPanel());

        return panel;
    }

    private JPanel resultPanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(40, 150, 1200, 340);
        panel.setBackground(Color.WHITE);

        Dijkstra dijkstra = new Dijkstra(nodes, directions, zoneNumber);
        this.result = dijkstra.getResults();
        this.vertical = dijkstra.getVerticalResults();

        JTextArea resulting = new JTextArea(result);
        resulting.setBounds(100, 65, 1100, 340);
        resulting.setFont(new Font("Courier New", Font.BOLD, 30));
        resulting.setForeground(Color.decode("#191919"));

        panel.add(resulting);

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
            SwingUtilities.invokeLater(() -> {
                new Capture().setVisible(true);
                
            });
        }

        if (e.getSource() == printButton) { 
            SwingUtilities.invokeLater(() -> {
                new ReceiptIntegrated(this.vertical).setVisible(true);
                
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
}
