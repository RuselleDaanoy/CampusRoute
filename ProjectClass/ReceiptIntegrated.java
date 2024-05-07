import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class ReceiptIntegrated extends JFrame implements ActionListener {

    LogoButton logo;
    String results;
    JTextArea contentArea;
    
    public ReceiptIntegrated(String results) {
        this.results = results;
        initComponents();
    }

    private void initComponents() {
        setTitle("Campus Route Path Navigator");
        setSize(new Dimension(1280, 720));
        setResizable(false);
        setLocationRelativeTo(null);
        setUndecorated(true);

        ImageIcon icon = new ImageIcon("C:\\Users\\thoby\\WALK\\src\\Resources\\WalkToTheRight.png");
        setIconImage(icon.getImage());

        add(mainPanel());
    }

    private JPanel mainPanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(0, 0, 1280, 720);
        panel.setBackground(new Color(0x191919));

        panel.add(receiptPanel());
        panel.add(outlinePanel());

        return panel;
    }

    private JPanel outlinePanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(80, 80, 1120, 560);
        panel.setBackground(new Color(0xFFFFFF));

        panel.add(contentPanel());

        return panel;
    }

    private JPanel contentPanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(5, 5, 1110, 550);
        panel.setBackground(new Color(0x191919));
                       
        String note = "<html><div style='text-align: center;'>"
                       + "THANK YOU AND<br>"
                       + "HAVE A SAFE DAY<br>"
                       + "AHEAD!";
                       
        JLabel content = new JLabel(note);
        content.setBounds(85, 225, 200, 100);
        content.setForeground(Color.decode("#38B6FF"));
        content.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
        panel.add(content);

        logo = new LogoButton(">");
        logo.setBounds(775, 125, 300, 300);
        logo.setBackground(new Color(0x191919));
        logo.setForeground(Color.WHITE);
        logo.addActionListener(this);
        panel.add(logo);

        return panel;
    }

    private JPanel receiptPanel() {
        
        JPanel panel = new JPanel(null);
        panel.setBounds(440, 35, 400, 650);
        panel.setBackground(Color.WHITE);
        
        // Headings
        JLabel header = new JLabel("RECEIPT");
        header.setBounds(0, 50, 400, 60);
        header.setForeground(Color.BLACK);
        header.setFont(new Font("Courier New", Font.BOLD, 60));
        header.setHorizontalAlignment(JLabel.CENTER);
        panel.add(header);

        JLabel subheader1 = new JLabel("NEW ERA UNIVERSITY");
        subheader1.setBounds(0, 110, 400, 15);
        subheader1.setForeground(Color.BLACK);
        subheader1.setFont(new Font("Courier New", Font.PLAIN, 15));
        subheader1.setHorizontalAlignment(JLabel.CENTER);
        panel.add(subheader1);

        JLabel subheader2 = new JLabel("MAIN CAMPUS - MAIN BUILDING");
        subheader2.setBounds(0, 125, 400, 15);
        subheader2.setForeground(Color.BLACK);
        subheader2.setFont(new Font("Courier New", Font.PLAIN, 15));
        subheader2.setHorizontalAlignment(JLabel.CENTER);
        panel.add(subheader2);

        // Content's Header
        JLabel day = new JLabel(getFormattedDayDate("Asia/Manila"));
        day.setBounds(20, 170, 360, 15);
        day.setForeground(Color.BLACK);
        day.setFont(new Font("Courier New", Font.PLAIN, 15));
        panel.add(day);

        JLabel border = new JLabel("---------------------------------------");
        border.setBounds(20, 185, 360, 15);
        border.setForeground(Color.BLACK);
        border.setFont(new Font("Courier New", Font.PLAIN, 15));
        panel.add(border);

        JLabel contentLabel = new JLabel("GUIDE:");
        contentLabel.setBounds(20, 200, 300, 15);
        contentLabel.setForeground(Color.BLACK);
        contentLabel.setFont(new Font("Courier New", Font.PLAIN, 15));
        panel.add(contentLabel);

        // Display the results
        JTextArea content = new JTextArea(results.toUpperCase());
        content.setBounds(20, 220, 360, 300);
        content.setForeground(Color.BLACK);
        content.setFont(new Font("Courier New", Font.BOLD, 15));
        content.setEditable(false);
        panel.add(content);

        // Footer
        JLabel footer = new JLabel("REMEMBER TO ALWAYS WALK TO THE RIGHT!");
        footer.setBounds(0, 595, 400, 15);
        footer.setForeground(Color.BLACK);
        footer.setFont(new Font("Courier New", Font.BOLD, 15));
        footer.setHorizontalAlignment(JLabel.CENTER);
        panel.add(footer);

        return panel;
    }

    private String getFormattedDayDate(String timeZoneId) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(timeZoneId));
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE | MMMM dd, yyyy");
        dateFormat.setTimeZone(calendar.getTimeZone());
        String formattedDateTime = dateFormat.format(calendar.getTime());

        return formattedDateTime.toUpperCase();
    }

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
    }
}
