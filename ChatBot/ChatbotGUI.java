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
        frame.setSize(500, 620);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        ImageIcon icon = new ImageIcon("WalkToTheRight.png");
        frame.setIconImage(icon.getImage());

        // Create the chat pane
        JTextPane chatPane = new JTextPane();
        chatPane.setEditable(false);
        chatPane.setMargin(new Insets(15, 15, 15, 15));
        chatPane.setBackground(Color.decode("#191919"));
        chatPane.setForeground(Color.WHITE);

        // Create the input field
        JTextField inputField = new JTextField(30);

        // Create the send button
        ChoiceButtons sendButton = new ChoiceButtons("Send", "Send");


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
        inputPanel.setBackground(Color.decode("#191919"));

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
        StyleConstants.setFontFamily(leftAlign, "Arial");
        StyleConstants.setFontSize(leftAlign, 13);
        //StyleConstants.setBackground(leftAlign, Color.decode("#4caf50")); // Bot's bubble color

        try {
            chatPane.getStyledDocument().insertString(chatPane.getStyledDocument().getLength(), greeting, null);
            chatPane.getStyledDocument().setParagraphAttributes(chatPane.getStyledDocument().getLength() - greeting.length(), greeting.length(), leftAlign, false);
        } 
        
        catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

        // Method to send message with rounded background shapes
    private static void sendMessage(JTextPane chatPane, JTextField inputField) {

    String userInput = inputField.getText();
    String response = ChatbotAlgorithm.getResponse(userInput); // Get response from the chatbot algorithm

    // Style for user's message bubble
    SimpleAttributeSet userStyle = new SimpleAttributeSet();
    StyleConstants.setAlignment(userStyle, StyleConstants.ALIGN_RIGHT);
    StyleConstants.setForeground(userStyle, Color.WHITE);
    StyleConstants.setFontFamily(userStyle, "Arial");
    StyleConstants.setFontSize(userStyle, 13);
    // StyleConstants.setBackground(userStyle, Color.decode("#007bff")); // User's bubble color

    // Style for chatbot's message bubble
    SimpleAttributeSet botStyle = new SimpleAttributeSet();
    StyleConstants.setAlignment(botStyle, StyleConstants.ALIGN_LEFT);
    StyleConstants.setForeground(botStyle, Color.decode("#38B6FF"));
    StyleConstants.setFontFamily(botStyle, "Arial"); // Set the font family
    StyleConstants.setFontSize(botStyle, 13); // Set the font size
    // StyleConstants.setBackground(botStyle, Color.decode("#4caf50")); // Bot's bubble color

        try {
            // Insert user's message with rounded background
            int userStart = chatPane.getStyledDocument().getLength();
            chatPane.getStyledDocument().insertString(userStart, " " + userInput + " \n\n", userStyle);
            chatPane.getStyledDocument().setParagraphAttributes(userStart, userInput.length() + 4, userStyle, false);

            // Insert chatbot's response with rounded background
            int botStart = chatPane.getStyledDocument().getLength();
            chatPane.getStyledDocument().insertString(botStart, " " + response + " \n\n", botStyle);
            chatPane.getStyledDocument().setParagraphAttributes(botStart, response.length() + 4, botStyle, false);
        } 
        
        catch (BadLocationException e) {
            e.printStackTrace();
        }

        // Clear the input field
        inputField.setText("");
    }
}
