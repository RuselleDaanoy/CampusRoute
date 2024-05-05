// package finals;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.text.*;

public class Receipt extends JFrame {

    public Receipt() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Campus Route Path Navigator");
        setSize(new Dimension(400, 650));

        setResizable(false);
        setLocationRelativeTo(null);
        setUndecorated(true);
        // setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Change file path for it to display
        ImageIcon icon = new ImageIcon("");
        setIconImage(icon.getImage());

        add(mainPanel());
    }

    private JPanel mainPanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(0, 0, 400, 600);
        panel.setBackground(Color.WHITE);

        // Headings
        JLabel header = new JLabel("RECEIPT");
        header.setBounds(0, 50, 400, 60);
        header.setForeground(Color.BLACK);
        header.setFont(new Font("Courier", Font.BOLD, 60));
        header.setHorizontalAlignment(JLabel.CENTER);
        panel.add(header);

        JLabel subheader1 = new JLabel("NEW ERA UNIVERSITY");
        subheader1.setBounds(0, 110, 400, 15);
        subheader1.setForeground(Color.BLACK);
        subheader1.setFont(new Font("Courier", Font.PLAIN, 15));
        subheader1.setHorizontalAlignment(JLabel.CENTER);
        panel.add(subheader1);

        JLabel subheader2 = new JLabel("MAIN CAMPUS - MAIN BUILDING");
        subheader2.setBounds(0, 125, 400, 15);
        subheader2.setForeground(Color.BLACK);
        subheader2.setFont(new Font("Courier", Font.PLAIN, 15));
        subheader2.setHorizontalAlignment(JLabel.CENTER);
        panel.add(subheader2);

        // Content's Header
        JLabel day = new JLabel(getFormattedDayDate("Asia/Manila"));
        day.setBounds(20, 170, 360, 15);
        day.setForeground(Color.BLACK);
        day.setFont(new Font("Courier", Font.PLAIN, 15));
        panel.add(day);

        JLabel border = new JLabel("---------------------------------------");
        border.setBounds(20, 185, 360, 15);
        border.setForeground(Color.BLACK);
        border.setFont(new Font("Courier", Font.PLAIN, 15));
        panel.add(border);

        // Content (No Algorithm Implementation yet) = TEMPORARY HOLDER FOR CONTENT
        String note = "Your content goes here...";

        JLabel content = new JLabel(note.toUpperCase());
        content.setBounds(20, 200, 360, 15);
        content.setForeground(Color.BLACK);
        content.setFont(new Font("Courier", Font.PLAIN, 15));
        panel.add(content);

        // Footer
        JLabel footer = new JLabel("REMEMBER TO ALWAYS WALK TO THE RIGHT!");
        footer.setBounds(0, 600, 400, 15);
        footer.setForeground(Color.BLACK);
        footer.setFont(new Font("Courier", Font.BOLD, 15));
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Receipt().setVisible(true);
        });
    }
}
