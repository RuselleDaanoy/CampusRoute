import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatbotGUI {

    // Main method to run the GUI
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Always Right Chatbot");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 520);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        ImageIcon icon = new ImageIcon("WalkToTheRight.png");
        frame.setIconImage(icon.getImage());

        // Create the chat pane
        JTextPane chatPane = new JTextPane();
        chatPane.setEditable(false);
        chatPane.setMargin(new Insets(10, 15, 10, 15));
        chatPane.setBackground(Color.decode("#191919"));
        chatPane.setForeground(Color.WHITE);

        // Create the input field
        JTextField inputField = new JTextField(30);

        // Create the send button
        ChoiceButtons sendButton = new ChoiceButtons("Send", "Go");


        // Add action listener to the send button
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage(chatPane, inputField);
            }
        });

        // Panel to hold the input field and send button
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout()); // Use FlowLayout for the input panel
        inputPanel.add(inputField);
        inputPanel.add(sendButton);

        // Add components to the frame
        frame.getContentPane().add(new JScrollPane(chatPane), BorderLayout.CENTER);
        frame.getContentPane().add(inputPanel, BorderLayout.SOUTH);

        // Display the chatbot's greeting
        displayGreeting(chatPane);

        // Display the frame
        frame.setVisible(true);
    }


    // Method to display the chatbot's greetings
    private static void displayGreeting(JTextPane chatPane) {
        String greeting = "Hello! How can I assist you today?\n";
        SimpleAttributeSet leftAlign = new SimpleAttributeSet();
        StyleConstants.setAlignment(leftAlign, StyleConstants.ALIGN_LEFT);
        StyleConstants.setForeground(leftAlign, Color.decode("#38B6FF"));

        try {
            chatPane.getStyledDocument().insertString(chatPane.getStyledDocument().getLength(), greeting, null);
            chatPane.getStyledDocument().setParagraphAttributes(chatPane.getStyledDocument().getLength() - greeting.length(), greeting.length(), leftAlign, false);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    // Method to send message
    private static void sendMessage(JTextPane chatPane, JTextField inputField) {
    String userInput = inputField.getText();
    String response = ChatbotAlgorithm.getResponse(userInput); // Get response from the chatbot algorithm

    // Style for user's message
    SimpleAttributeSet rightAlign = new SimpleAttributeSet();
    StyleConstants.setAlignment(rightAlign, StyleConstants.ALIGN_RIGHT);
    StyleConstants.setForeground(rightAlign, Color.WHITE);

    // Style for chatbot's response
    SimpleAttributeSet leftAlign = new SimpleAttributeSet();
    StyleConstants.setAlignment(leftAlign, StyleConstants.ALIGN_LEFT);
    StyleConstants.setForeground(leftAlign, Color.decode("#38B6FF"));

        try {
            // Insert user's message hah image
            int userStart = chatPane.getStyledDocument().getLength();
            chatPane.getStyledDocument().insertString(userStart, "" + userInput + "\n\n", null);
            chatPane.getStyledDocument().setParagraphAttributes(userStart, userInput.length() + 4, rightAlign, false);

            // Insert chatbot's response
            int botStart = chatPane.getStyledDocument().getLength();
            chatPane.getStyledDocument().insertString(botStart, "" + response + "\n\n", null);
            chatPane.getStyledDocument().setParagraphAttributes(botStart, response.length() + 13, leftAlign, false);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }

        // Clear the input field
        inputField.setText("");
    }

}
